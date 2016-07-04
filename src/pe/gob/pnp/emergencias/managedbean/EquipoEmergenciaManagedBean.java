package pe.gob.pnp.emergencias.managedbean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.google.common.collect.Lists;

import pe.gob.pnp.emergencias.model.Emergencia;
import pe.gob.pnp.emergencias.model.EquipoEmergencia;
import pe.gob.pnp.emergencias.model.RecursoEstado;
import pe.gob.pnp.emergencias.service.EmergenciaService;
import pe.gob.pnp.emergencias.service.EquipoEmergenciaService;
import pe.gob.pnp.emergencias.service.RecursoEstadoService;

@ManagedBean
@SessionScoped
public class EquipoEmergenciaManagedBean {

	@ManagedProperty(value = "#{equipoEmergenciaService}")
	private EquipoEmergenciaService equipoEmergenciaService;
	
	@ManagedProperty(value = "#{emergenciaService}")
	private EmergenciaService emergenciaService;

	@ManagedProperty(value = "#{recursoEstadoService}")
	private RecursoEstadoService recursoEstadoService;

	private EquipoEmergencia equipoEmergencia = new EquipoEmergencia();

	Emergencia emergencia = (Emergencia) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
			.get("emergencia");

	List<EquipoEmergencia> equiposEmergencia = new ArrayList<EquipoEmergencia>();
	List<EquipoEmergencia> equiposEmergenciaXRecurso = new ArrayList<EquipoEmergencia>();
	List<RecursoEstado> recursosEstado = new ArrayList<RecursoEstado>();

	public EquipoEmergencia getEquipoEmergencia() {
		return equipoEmergencia;
	}

	public void setEquipoEmergencia(EquipoEmergencia equipoEmergencia) {
		this.equipoEmergencia = equipoEmergencia;
	}

	public EquipoEmergenciaService getEquipoEmergenciaService() {
		return equipoEmergenciaService;
	}

	public void setEquipoEmergenciaService(EquipoEmergenciaService equipoEmergenciaService) {
		this.equipoEmergenciaService = equipoEmergenciaService;
	}

	public RecursoEstadoService getRecursoEstadoService() {
		return recursoEstadoService;
	}

	public void setRecursoEstadoService(RecursoEstadoService recursoEstadoService) {
		this.recursoEstadoService = recursoEstadoService;
	}
	
	public EmergenciaService getEmergenciaService() {
		return emergenciaService;
	}

	public void setEmergenciaService(EmergenciaService emergenciaService) {
		this.emergenciaService = emergenciaService;
	}

	public String registrarEquipoEmergencia() {
		return "registroLlamada";
	}

	public List<EquipoEmergencia> getEquiposEmergencia() {
		equiposEmergencia = Lists.newArrayList(
				equipoEmergenciaService.getEquipoEmergenciaRepository().equipoXEmergencia(emergencia.getEmeId()));

		return equiposEmergencia;
	}

	public void setEquiposEmergencia(List<EquipoEmergencia> equiposEmergencia) {
		this.equiposEmergencia = equiposEmergencia;
	}

	public List<RecursoEstado> getRecursosEstado() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringData");
		EntityManager manager = factory.createEntityManager();

		try {
			Query q = manager.createNativeQuery("USP_RECURSOS_DISPONIBLES", RecursoEstado.class);

			recursosEstado = q.getResultList();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return recursosEstado;
	}

	public void setRecursosEstado(List<RecursoEstado> recursosEstado) {
		this.recursosEstado = recursosEstado;
	}

	public Emergencia getEmergencia() {
		return emergencia;
	}

	public void setEmergencia(Emergencia emergencia) {
		this.emergencia = emergencia;
	}

	public List<EquipoEmergencia> getEquiposEmergenciaXRecurso() {
		FacesContext context = FacesContext.getCurrentInstance();
		@SuppressWarnings("rawtypes")
		Map params = context.getExternalContext().getSessionMap();
		EquipoEmergencia equipoEmergencia1 = (EquipoEmergencia) params.get("equipoLogin");

		equiposEmergenciaXRecurso = Lists.newArrayList(equipoEmergenciaService.getEquipoEmergenciaRepository()
				.equipoXEmergenciaRecurso(equipoEmergencia1.getRecurso().getRecId()));
		return equiposEmergenciaXRecurso;
	}

	public void setEquiposEmergenciaXRecurso(List<EquipoEmergencia> equiposEmergenciaXRecurso) {
		this.equiposEmergenciaXRecurso = equiposEmergenciaXRecurso;
	}

	public String agregarRecursoEquipo() {

		String recId = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
				.get("recId");

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringData");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();

		try {
			tx.begin();

			Query q = manager.createNativeQuery("EXEC USP_AGREGAR_RECURSO_EQUIPO ?,?").setParameter(1, recId)
					.setParameter(2, emergencia.getEmeId());

			q.executeUpdate();

			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		return "registroEquipoEmergencia";
	}

	public String quitarRecursoEquipo() {

		String recId = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
				.get("recId");

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringData");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();

		try {
			tx.begin();

			Query q = manager.createNativeQuery("EXEC USP_QUITAR_RECURSO_EQUIPO ?,?").setParameter(1, recId)
					.setParameter(2, emergencia.getEmeId());

			q.executeUpdate();

			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		return "registroEquipoEmergencia";
	}

	public String enviarEquipo() {

		Calendar ahora = Calendar.getInstance();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringData");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		emergencia.setEmeHoraInicio(ahora.get(Calendar.HOUR_OF_DAY) + ":" + ahora.get(Calendar.MINUTE));

		try {
			tx.begin();

			Query q = manager.createNativeQuery("EXEC USP_ENVIAR_EQUIPO ?,?").setParameter(1, emergencia.getEmeId())
					.setParameter(2, emergencia.getEmeHoraInicio());

			q.executeUpdate();

			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		emergencia = new Emergencia();

		return "registroLlamada?faces-redirect=true";

	}

	public String editarRecursoEquipo(){
		
		String emeId = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
				.get("emeId");
		
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("emergencia");
		FacesContext.getCurrentInstance().getExternalContext().
		getSessionMap().put("emergencia",emergenciaService.getEmergenciaRepository().findOne(new Long(emeId)));
		
		return "editarEquipoRecurso";
		
	}

	public String obtenerUltimaEmergencia() {

		FacesContext context = FacesContext.getCurrentInstance();
		@SuppressWarnings("rawtypes")
		Map params = context.getExternalContext().getSessionMap();
		EquipoEmergencia equipoEmergencia1 = (EquipoEmergencia) params.get("equipoLogin");

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringData");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();

		try {
			tx.begin();

			if (equipoEmergencia1 == null) {
				return "emergenciaNoEncontrada?faces-redirect=true";
			} else {
				Query q = manager.createNativeQuery("sp_obtenerUltimaEmergencia ?").setParameter(1,
						equipoEmergencia1.getRecurso().getRecId());
				int cant = q.getResultList().size();

				if (cant > 0) {
					int unaemergencia = (int) q.getResultList().get(0);
					equipoEmergencia = equipoEmergenciaService.getEquipoEmergenciaRepository()
							.obtenerEquipoEmergenciaId(unaemergencia);
					return "emergenciaEncontrada?faces-redirect=true";
				} else {
					addMessageInfo("Confirmación", "USTED NO TIENE EMERGENCIAS ASIGNADAS");
					return "emergenciaNoEncontrada?faces-redirect=true";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "emergenciaEncontrada?faces-redirect=true";
	}

	public String irReporteEmergenciaPorRecurso() {
		FacesContext context = FacesContext.getCurrentInstance();
		@SuppressWarnings("rawtypes")
		Map params = context.getExternalContext().getSessionMap();
		EquipoEmergencia equipoEmergencia1 = (EquipoEmergencia) params.get("equipoLogin");

		if (equipoEmergencia1 == null) {
			return "inicio?faces-redirect=true";
		} else {
			return "reporteEmergenciaPorRecurso?faces-redirect=true";
		}

	}

	public void addMessageInfo(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void addMessageError(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
