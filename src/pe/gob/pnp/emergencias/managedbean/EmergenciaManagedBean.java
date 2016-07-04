package pe.gob.pnp.emergencias.managedbean;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import pe.gob.pnp.emergencias.model.Emergencia;
import pe.gob.pnp.emergencias.service.EmergenciaService;

@ManagedBean
@SessionScoped
public class EmergenciaManagedBean {
	@ManagedProperty(value = "#{emergenciaService}")
	private EmergenciaService emergenciaService;

	private Emergencia emergencia = new Emergencia();

	public Emergencia getEmergencia() {
		return emergencia;
	}

	public void setEmergencia(Emergencia emergencia) {
		this.emergencia = emergencia;
	}

	public EmergenciaService getEmergenciaService() {
		return emergenciaService;
	}

	public void setEmergenciaService(EmergenciaService emergenciaService) {
		this.emergenciaService = emergenciaService;
	}

	public String contestarLlamada() {

		Random random = new Random();
		Calendar ahora = Calendar.getInstance();

		int terminalAleatorio = random.nextInt((2 - 1) + 1) + 1;

		if (terminalAleatorio == 1) {
			int numeroFijo = random.nextInt((9999999 - 1000000) + 1) + 1000000;
			emergencia.getLlamada().getTipoTerminal().setTteId(new Long(1));
			emergencia.getLlamada().setLlaTelefono("01" + numeroFijo);
		} else {
			int numeroCelular = random.nextInt((99999999 - 10000000) + 1) + 10000000;
			emergencia.getLlamada().getTipoTerminal().setTteId(new Long(2));
			emergencia.getLlamada().setLlaTelefono("9" + numeroCelular);
		}

		emergencia.getLlamada().setLlaHoraInicio(ahora.get(Calendar.HOUR_OF_DAY) + ":" + ahora.get(Calendar.MINUTE));

		return "registroLlamada";
	}

	public String registrarEmergencia() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringData");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();

		try {
			Date hoy = new Date();
			Calendar ahora = Calendar.getInstance();

			emergencia.getLlamada().getCivil().setFechaRegistro(hoy);
			emergencia.getLlamada().setLlaFecha(hoy);
			emergencia.setEmeFecha(hoy);
			emergencia.getLlamada().setLlaHoraFin(ahora.get(Calendar.HOUR_OF_DAY) + ":" + ahora.get(Calendar.MINUTE));
			emergencia.getLlamada().getOperador().setOpeId(new Long(1));
			;
			tx.begin();

			Query q = manager
					.createNativeQuery("EXEC USP_REGISTRAR_EMERGENCIA ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?")
					.setParameter(1, emergencia.getLlamada().getCivil().getCivDocumento())
					.setParameter(2, emergencia.getLlamada().getCivil().getCivNombre())
					.setParameter(3, emergencia.getLlamada().getCivil().getCivApellidoPaterno())
					.setParameter(4, emergencia.getLlamada().getCivil().getCivApellidoMaterno())
					.setParameter(5, emergencia.getLlamada().getCivil().getCivTelefono())
					.setParameter(6, emergencia.getLlamada().getCivil().getFechaRegistro())
					.setParameter(7, emergencia.getLlamada().getLlaFecha())
					.setParameter(8, emergencia.getLlamada().getLlaObservacion())
					.setParameter(9, emergencia.getLlamada().getLlaTelefono())
					.setParameter(10, emergencia.getLlamada().getTipoTerminal().getTteId())
					.setParameter(11, emergencia.getLlamada().getOperador().getOpeId())
					.setParameter(12, emergencia.getLlamada().getLlaHoraInicio())
					.setParameter(13, emergencia.getLlamada().getLlaHoraFin())
					.setParameter(14, emergencia.getNivelEmergencia().getNemId())
					.setParameter(15, emergencia.getTipoEmergencia().getTemId())
					.setParameter(16, emergencia.getDistrito().getDisId()).setParameter(17, emergencia.getEmeDir())
					.setParameter(18, emergencia.getEmeObservacion()).setParameter(19, emergencia.getEmeFecha())
					.setParameter(20, emergencia.getEmeHoraInicio()).setParameter(21, emergencia.getEmeHoraFin())
					.setParameter(22, emergencia.getLatitud()).setParameter(23, emergencia.getLongitud());

			q.executeUpdate();

			tx.commit();

			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("emergencia",
					emergenciaService.getEmergenciaRepository().ultimaEmergenciaInsertada().get(0));

			emergencia = new Emergencia();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		return "registroEquipoEmergencia";
	}

	public String registrarLlamadaFalsa() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringData");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();

		try {
			Date hoy = new Date();
			Calendar ahora = Calendar.getInstance();

			emergencia.getLlamada().getCivil().setFechaRegistro(hoy);
			emergencia.getLlamada().setLlaFecha(hoy);
			emergencia.getLlamada().setLlaHoraFin(ahora.get(Calendar.HOUR_OF_DAY) + ":" + ahora.get(Calendar.MINUTE));
			emergencia.getLlamada().getOperador().setOpeId(new Long(1));
			;
			tx.begin();

			Query q = manager.createNativeQuery("EXEC USP_REGISTRAR_LLAMADA_FALSA ?,?,?,?,?,?,?,?,?,?,?,?,?")
					.setParameter(1, emergencia.getLlamada().getCivil().getCivDocumento())
					.setParameter(2, emergencia.getLlamada().getCivil().getCivNombre())
					.setParameter(3, emergencia.getLlamada().getCivil().getCivApellidoPaterno())
					.setParameter(4, emergencia.getLlamada().getCivil().getCivApellidoMaterno())
					.setParameter(5, emergencia.getLlamada().getCivil().getCivTelefono())
					.setParameter(6, emergencia.getLlamada().getCivil().getFechaRegistro())
					.setParameter(7, emergencia.getLlamada().getLlaFecha())
					.setParameter(8, emergencia.getLlamada().getLlaObservacion())
					.setParameter(9, emergencia.getLlamada().getLlaTelefono())
					.setParameter(10, emergencia.getLlamada().getTipoTerminal().getTteId())
					.setParameter(11, emergencia.getLlamada().getOperador().getOpeId())
					.setParameter(12, emergencia.getLlamada().getLlaHoraInicio())
					.setParameter(13, emergencia.getLlamada().getLlaHoraFin());

			q.executeUpdate();

			tx.commit();

			emergencia = new Emergencia();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return "registroLlamada";
	}
	
	public String irPaginaChart()
	{
		return "ejemploChart";
	}
	
	public String irPaginaReporteEmergencia()
	{
		return "reporteEmergencia?faces-redirect=true";
	}
	
	public String irPaginaReporteNivelEmergencia()
	{
		return "reporteNivelEmergencia?faces-redirect=true";
	}
	
}
