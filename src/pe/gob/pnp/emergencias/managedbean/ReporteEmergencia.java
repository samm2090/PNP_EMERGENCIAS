package pe.gob.pnp.emergencias.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import com.google.common.collect.Lists;

import pe.gob.pnp.emergencias.model.Emergencia;
import pe.gob.pnp.emergencias.service.EmergenciaService;

@ManagedBean
public class ReporteEmergencia implements Serializable {

	private static final long serialVersionUID = 1L;
	private LineChartModel animatedModel1;
	private HorizontalBarChartModel animatedModel2;

	@ManagedProperty(value = "#{emergenciaService}")
	private EmergenciaService emergenciaService;

	@PostConstruct
	public void init() {
		createAnimatedModels();
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

	private void createAnimatedModels() {
		animatedModel1 = initLinearModel();
		animatedModel1.setTitle("Line Chart");
		animatedModel1.setAnimate(true);
		animatedModel1.setLegendPosition("se");
		Axis yAxis = animatedModel1.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(10);

		animatedModel2 = initBarModel();
		animatedModel2.setTitle("Bar Charts");
		animatedModel2.setAnimate(true);
		animatedModel2.setLegendPosition("ne");
		yAxis = animatedModel2.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(6);
	}

	private HorizontalBarChartModel initBarModel() {
		HorizontalBarChartModel model = new HorizontalBarChartModel();
		ChartSeries distritos = new ChartSeries();
		distritos.setLabel("Nivel Peligrosidad");
		List<Emergencia> lista = Lists.newArrayList(emergenciaService.getEmergenciaRepository().emergenciaOrdenadaxDistrito());

		Long codigoDistrito = lista.get(0).getDistrito().getDisId();
		Long suma = new Long(0);
		int cont = 0;
		for (int i = 0; i < lista.size(); i++) {
			if (i != 0 && codigoDistrito == lista.get(i).getDistrito().getDisId()) {
				suma = suma + lista.get(i).getNivelEmergencia().getNemId();
				cont++;
			} else {
				if(i==0)
				{
					codigoDistrito = lista.get(i).getDistrito().getDisId();
					suma = suma + lista.get(i).getNivelEmergencia().getNemId();
					cont++;
				}
				else
				{
					distritos.set(lista.get(i-1).getDistrito().getDisDescripcion(), (suma / cont));
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
	/*
	 * @ManagedProperty(value = "#{emergenciaService}") private
	 * EmergenciaService emergenciaService;
	 * 
	 * private Emergencia emergencia = new Emergencia(); private BarChartModel
	 * reportePeligrosidad;
	 * 
	 * @PostConstruct public void init() { createAnimatedModels(); }
	 * 
	 * public EmergenciaService getEmergenciaService() { return
	 * emergenciaService; }
	 * 
	 * public void setEmergenciaService(EmergenciaService emergenciaService) {
	 * this.emergenciaService = emergenciaService; }
	 * 
	 * public Emergencia getEmergencia() { return emergencia; }
	 * 
	 * public void setEmergencia(Emergencia emergencia) { this.emergencia =
	 * emergencia; }
	 * 
	 * public BarChartModel getReportePeligrosidad() { return
	 * reportePeligrosidad; }
	 * 
	 * public void setReportePeligrosidad(BarChartModel reportePeligrosidad) {
	 * this.reportePeligrosidad = reportePeligrosidad; }
	 * 
	 * private void createAnimatedModels() {
	 * 
	 * reportePeligrosidad = initBarModel(); reportePeligrosidad.setTitle(
	 * "Nivel Peligrosidad"); reportePeligrosidad.setAnimate(true);
	 * reportePeligrosidad.setLegendPosition("ne"); Axis yAxis =
	 * reportePeligrosidad.getAxis(AxisType.Y); yAxis.setMin(0);
	 * yAxis.setMax(200); }
	 * 
	 * private BarChartModel initBarModel() { BarChartModel model = new
	 * BarChartModel(); ChartSeries distritos = new ChartSeries();
	 * ArrayList<Emergencia> lista = (ArrayList<Emergencia>)
	 * emergenciaService.getEmergenciaRepository().findAll();
	 * 
	 * Long codigoDistrito = lista.get(0).getDistrito().getDisId(); Long suma =
	 * new Long(0); int cont=0; for(int i=0;i<lista.size();i++) { if(i!=0 &&
	 * codigoDistrito!=lista.get(i).getDistrito().getDisId()) { suma = suma +
	 * lista.get(i).getNivelEmergencia().getNemId(); cont++; } else {
	 * distritos.set(lista.get(i).getDistrito().getDisDescripcion(),
	 * (suma/cont)); cont=1; codigoDistrito =
	 * lista.get(i).getDistrito().getDisId(); suma=
	 * lista.get(i).getNivelEmergencia().getNemId(); } }
	 * 
	 * distritos.set(lista.get(lista.size()-1).getDistrito().getDisDescripcion()
	 * , suma);
	 * 
	 * 
	 * return model; }
	 * 
	 */
}
