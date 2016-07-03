package pe.gob.pnp.emergencias.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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

<<<<<<< HEAD
	@ManagedProperty(value = "#{recursoService}")
	private RecursoService recursoService;

	private EquipoEmergencia equipoEmergencia = new EquipoEmergencia();

	List<Recurso> recursos = new ArrayList<Recurso>();
	private List<EquipoEmergencia> equipoEmergencias = new ArrayList<EquipoEmergencia>();

	public EquipoEmergenciaService getEquipoEmergenciaService() {
		return equipoEmergenciaService;
	}

	public void setEquipoEmergenciaService(EquipoEmergenciaService equipoEmergenciaService) {
		this.equipoEmergenciaService = equipoEmergenciaService;
	}

	public RecursoService getRecursoService() {
		return recursoService;
	}

	public void setRecursoService(RecursoService recursoService) {
		this.recursoService = recursoService;
	}
=======
	@ManagedProperty(value = "#{recursoEstadoService}")
	private RecursoEstadoService recursoEstadoService;

	EquipoEmergencia equipoEmergencia = new EquipoEmergencia();

	List<EquipoEmergencia> equiposEmergencia = new ArrayList<EquipoEmergencia>();
	List<RecursoEstado> recursosEstado = new ArrayList<RecursoEstado>();
>>>>>>> origin/master

	public EquipoEmergencia getEquipoEmergencia() {
		return equipoEmergencia;
	}

	public void setEquipoEmergencia(EquipoEmergencia equipoEmergencia) {
		this.equipoEmergencia = equipoEmergencia;
	}

<<<<<<< HEAD
	public List<Recurso> getRecursos() {
		recursos = Lists.newArrayList(recursoService.getRecursoRepository().findAll());
		return recursos;
=======
	public EquipoEmergenciaService getEquipoEmergenciaService() {
		return equipoEmergenciaService;
>>>>>>> origin/master
	}

	public void setEquipoEmergenciaService(EquipoEmergenciaService equipoEmergenciaService) {
		this.equipoEmergenciaService = equipoEmergenciaService;
	}

<<<<<<< HEAD
	public List<EquipoEmergencia> getEquipoEmergencias() {
		return equipoEmergencias;
	}

	public void setEquipoEmergencias(List<EquipoEmergencia> equipoEmergencias) {
		this.equipoEmergencias = equipoEmergencias;
	}

	public String registrarEquipoEmergencia() {

		return "registroLlamada";
	}

=======
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
		return equiposEmergencia;
	}

	public void setEquiposEmergencia(List<EquipoEmergencia> equiposEmergencia) {
		this.equiposEmergencia = equiposEmergencia;
	}

	public List<RecursoEstado> getRecursosEstado() {
		recursosEstado = Lists.newArrayList(recursoEstadoService.getRecursoEstadoRepository().recursosDisponibles(new Long(1)));
		return recursosEstado;
	}

	public void setRecursosEstado(List<RecursoEstado> recursosEstado) {
		this.recursosEstado = recursosEstado;
	}

	public String agregarRecursoEquipo() {

		Emergencia emergencia = (Emergencia) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("emergencia");

		String recId = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
				.get("recId");

		try {
			equipoEmergencia.setEmergencia(emergencia);
			equipoEmergencia.getRecurso().setRecId(new Long(recId));

			equipoEmergenciaService.getEmergenciaRepository().save(equipoEmergencia);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "registroEquipoEmergencia";

	}
>>>>>>> origin/master
}
