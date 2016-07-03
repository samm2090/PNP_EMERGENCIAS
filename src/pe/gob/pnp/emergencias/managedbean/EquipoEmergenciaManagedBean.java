package pe.gob.pnp.emergencias.managedbean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import pe.gob.pnp.emergencias.service.EquipoEmergenciaService;
import pe.gob.pnp.emergencias.service.RecursoEstadoService;

@ManagedBean
@SessionScoped
public class EquipoEmergenciaManagedBean {

	@ManagedProperty(value = "#{equipoEmergenciaService}")
	private EquipoEmergenciaService equipoEmergenciaService;

	@ManagedProperty(value = "#{recursoEstadoService}")
	private RecursoEstadoService recursoEstadoService;

	EquipoEmergencia equipoEmergencia = new EquipoEmergencia();

	Emergencia emergencia = (Emergencia) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
			.get("emergencia");

	List<EquipoEmergencia> equiposEmergencia = new ArrayList<EquipoEmergencia>();
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

	public String registrarEquipoEmergencia() {
		return "registroLlamada";
	}

	public List<EquipoEmergencia> getEquiposEmergencia() {
		equiposEmergencia = Lists.newArrayList(
				equipoEmergenciaService.getEmergenciaRepository().equipoXEmergencia(emergencia.getEmeId()));
		return equiposEmergencia;
	}

	public void setEquiposEmergencia(List<EquipoEmergencia> equiposEmergencia) {
		this.equiposEmergencia = equiposEmergencia;
	}

	public List<RecursoEstado> getRecursosEstado() {
		recursosEstado = Lists
				.newArrayList(recursoEstadoService.getRecursoEstadoRepository().recursosDisponibles(new Long(1)));
		return recursosEstado;
	}

	public void setRecursosEstado(List<RecursoEstado> recursosEstado) {
		this.recursosEstado = recursosEstado;
	}

	public String agregarRecursoEquipo() {

		String recId = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
				.get("recId");

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringData");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();

		try {
			tx.begin();

			Query q = manager
					.createNativeQuery("EXEC USP_AGREGAR_RECURSO_EQUIPO ?,?")
					.setParameter(1, recId)
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

		// String recId = (String)
		// FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
		// .get("recId");
		//
		// try {
		// equipoEmergencia.setEmergencia(emergencia);
		// equipoEmergencia.getRecurso().setRecId(new Long(recId));
		//
		// equipoEmergenciaService.getEmergenciaRepository().save(equipoEmergencia);
		//
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		return "registroEquipoEmergencia";
	}
}
