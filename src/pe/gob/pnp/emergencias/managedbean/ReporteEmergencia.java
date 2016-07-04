package pe.gob.pnp.emergencias.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

import com.google.common.collect.Lists;

import pe.gob.pnp.emergencias.model.Emergencia;
import pe.gob.pnp.emergencias.model.EquipoEmergencia;
import pe.gob.pnp.emergencias.model.Llamada;
import pe.gob.pnp.emergencias.service.EmergenciaService;

@ManagedBean
public class ReporteEmergencia implements Serializable {

	private static final long serialVersionUID = 1L;
	private LineChartModel animatedModel1;
	private HorizontalBarChartModel animatedModel2;
	private PieChartModel pieModel1;
	private Date fechaInicio;
	private Date fechaFin;
	private Emergencia emergencia = new Emergencia();
	private List<Emergencia> emergencias = new ArrayList<Emergencia>();
	private EquipoEmergencia equipoEmergencia = new EquipoEmergencia();
	private List<EquipoEmergencia> equiposEmergencia = new ArrayList<EquipoEmergencia>();
	private Llamada llamada = new Llamada();
	private List<Llamada> llamadas = new ArrayList<Llamada>();

	@ManagedProperty(value = "#{emergenciaService}")
	private EmergenciaService emergenciaService;

	@PostConstruct
	public void init() {
		createAnimatedModels();
	}

	public List<EquipoEmergencia> getEquiposEmergencia() {
		return equiposEmergencia;
	}

	public void setEquiposEmergencia(List<EquipoEmergencia> equiposEmergencia) {
		this.equiposEmergencia = equiposEmergencia;
	}

	public EquipoEmergencia getEquipoEmergencia() {
		return equipoEmergencia;
	}

	public void setEquipoEmergencia(EquipoEmergencia equipoEmergencia) {
		this.equipoEmergencia = equipoEmergencia;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public List<Emergencia> getEmergencias() {
		return emergencias;
	}

	public void setEmergencias(List<Emergencia> emergencias) {
		this.emergencias = emergencias;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Emergencia getEmergencia() {
		return emergencia;
	}

	public void setEmergencia(Emergencia emergencia) {
		this.emergencia = emergencia;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public PieChartModel getPieModel1() {
		return pieModel1;
	}

	public void setPieModel1(PieChartModel pieModel1) {
		this.pieModel1 = pieModel1;
	}

	public EmergenciaService getEmergenciaService() {
		return emergenciaService;
	}

	public void setEmergenciaService(EmergenciaService emergenciaService) {
		this.emergenciaService = emergenciaService;
	}

	public LineChartModel getAnimatedModel1() {
		return animatedModel1;
	}

	public HorizontalBarChartModel getAnimatedModel2() {
		return animatedModel2;
	}

	public Llamada getLlamada() {
		return llamada;
	}

	public void setLlamada(Llamada llamada) {
		this.llamada = llamada;
	}

	public List<Llamada> getLlamadas() {
		return llamadas;
	}

	public void setLlamadas(List<Llamada> llamadas) {
		this.llamadas = llamadas;
	}

	private void createAnimatedModels() {
		animatedModel1 = initLinearModel();
		animatedModel1.setTitle("Line Chart");
		animatedModel1.setAnimate(true);
		animatedModel1.setLegendPosition("se");
		Axis yAxis = animatedModel1.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(10);

		animatedModel2 = initBarModel();
		animatedModel2.setTitle("Nivel de Peligrosidad por Distritos");
		animatedModel2.setAnimate(true);
		animatedModel2.setLegendPosition("ne");
		yAxis = animatedModel2.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(5);

		createPieModel1();
	}

	private HorizontalBarChartModel initBarModel() {
		HorizontalBarChartModel model = new HorizontalBarChartModel();
		ChartSeries distritos = new ChartSeries();
		distritos.setLabel("Nivel Peligrosidad");
		List<Emergencia> lista = Lists
				.newArrayList(emergenciaService.getEmergenciaRepository().emergenciaOrdenadaxDistrito());

		Long codigoDistrito = lista.get(0).getDistrito().getDisId();
		Long suma = new Long(0);
		int cont = 0;
		for (int i = 0; i < lista.size(); i++) {
			if (i != 0 && codigoDistrito == lista.get(i).getDistrito().getDisId()) {
				suma = suma + lista.get(i).getNivelEmergencia().getNemId();
				cont++;
			} else {
				if (i == 0) {
					codigoDistrito = lista.get(i).getDistrito().getDisId();
					suma = suma + lista.get(i).getNivelEmergencia().getNemId();
					cont++;
				} else {
					distritos.set(lista.get(i - 1).getDistrito().getDisDescripcion(), (suma / cont));
					cont = 1;
					codigoDistrito = lista.get(i).getDistrito().getDisId();
					suma = lista.get(i).getNivelEmergencia().getNemId();
				}
			}
		}

		distritos.set(lista.get(lista.size() - 1).getDistrito().getDisDescripcion(), suma);
		model.addSeries(distritos);
		return model;
	}

	private LineChartModel initLinearModel() {
		LineChartModel model = new LineChartModel();

		LineChartSeries series1 = new LineChartSeries();
		series1.setLabel("Series 1");

		series1.set(1, 2);
		series1.set(2, 1);
		series1.set(3, 3);
		series1.set(4, 6);
		series1.set(5, 8);

		LineChartSeries series2 = new LineChartSeries();
		series2.setLabel("Series 2");

		series2.set(1, 6);
		series2.set(2, 3);
		series2.set(3, 2);
		series2.set(4, 7);
		series2.set(5, 9);

		model.addSeries(series1);
		model.addSeries(series2);

		return model;
	}

	private void createPieModel1() {
		pieModel1 = new PieChartModel();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringData");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createNativeQuery("sp_parteXEstadoFecha ?").setParameter(1, 1);
		int cantidadAtendidos = q.getResultList().size();

		Query q1 = manager.createNativeQuery("sp_parteXEstadoFecha ?").setParameter(1, 2);
		int cantidadFalsaAlarma = q1.getResultList().size();

		Query q3 = manager.createNativeQuery("sp_parteXEstadoFecha ?").setParameter(1, 3);
		int cantidadFrustrados = q3.getResultList().size();

		pieModel1.set("Atendidos", cantidadAtendidos);
		pieModel1.set("Falsa alarma", cantidadFalsaAlarma);
		pieModel1.set("Frustrados", cantidadFrustrados);

		pieModel1.setTitle("Emergencias en el último mes");
		pieModel1.setLegendPosition("w");
	}

	public String buscarReporteEmergencias() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringData");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createNativeQuery("sp_reporteEmergencia ?,?,?").setParameter(1, fechaInicio)
				.setParameter(2, fechaFin).setParameter(3, emergencia.getDistrito().getDisId());

		emergencias = q.getResultList();

		return "reporteEmergencia";
	}

	public String buscarReporteNivelPeligrosidad() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringData");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createNativeQuery("sp_reporteEmergencia ?,?,?",Emergencia.class)
				.setParameter(1, fechaInicio)
				.setParameter(2, fechaFin).setParameter(3, emergencia.getDistrito().getDisId());

		emergencias = q.getResultList();

		return "reporteEmergencia";
	}

	public String buscarReporteRecursos() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringData");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createNativeQuery("sp_reporteRecurso ?,?,?",EquipoEmergencia.class)
				.setParameter(1, equipoEmergencia.getRecurso().getComisaria().getComId())
				.setParameter(2, fechaInicio)
				.setParameter(3, fechaFin);
		
		equiposEmergencia = q.getResultList();
		
		return "reporteRecurso"; 
		
	}
	
	public String buscarReporteLlamada()
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringData");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createNativeQuery("sp_reporteLlamadas ?,?,?",Llamada.class)
				.setParameter(1, llamada.isLlaEstado())
				.setParameter(2, fechaInicio)
				.setParameter(3, fechaFin);
		
		llamadas = q.getResultList();
		return "reporteLlamada";
	}

}
