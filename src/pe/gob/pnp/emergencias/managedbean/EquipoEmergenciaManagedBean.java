package pe.gob.pnp.emergencias.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.google.common.collect.Lists;

import pe.gob.pnp.emergencias.model.EquipoEmergencia;
import pe.gob.pnp.emergencias.model.Recurso;
import pe.gob.pnp.emergencias.service.EquipoEmergenciaService;
import pe.gob.pnp.emergencias.service.RecursoService;

@ManagedBean
@SessionScoped
public class EquipoEmergenciaManagedBean {

	@ManagedProperty(value = "#{equipoEmergenciaService}")
	private EquipoEmergenciaService equipoEmergenciaService;

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

	public EquipoEmergencia getEquipoEmergencia() {
		return equipoEmergencia;
	}

	public void setEquipoEmergencia(EquipoEmergencia equipoEmergencia) {
		this.equipoEmergencia = equipoEmergencia;
	}

	public List<Recurso> getRecursos() {
		recursos = Lists.newArrayList(recursoService.getRecursoRepository().findAll());
		return recursos;
	}

	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}

	public List<EquipoEmergencia> getEquipoEmergencias() {
		return equipoEmergencias;
	}

	public void setEquipoEmergencias(List<EquipoEmergencia> equipoEmergencias) {
		this.equipoEmergencias = equipoEmergencias;
	}

	public String registrarEquipoEmergencia() {

		return "registroLlamada";
	}

}
