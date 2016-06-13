package pe.gob.pnp.emergencias.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedProperty;

import pe.gob.pnp.emergencias.model.EquipoEmergencia;
import pe.gob.pnp.emergencias.model.Recurso;
import pe.gob.pnp.emergencias.service.EquipoEmergenciaService;
import pe.gob.pnp.emergencias.service.RecursoService;

public class EquipoEmergenciaManagedBean{
	
	@ManagedProperty(value="#{equipoEmergenciaService}")
	private EquipoEmergenciaService equipoEmergenciaService;
	
	@ManagedProperty(value = "#{recursoService}")
	private RecursoService recursoService;
	
	EquipoEmergencia equipoEmergencia = new EquipoEmergencia();
	
	List<Recurso> recursos = new ArrayList<Recurso>();
	
	public EquipoEmergencia getEquipoEmergencia() {
		return equipoEmergencia;
	}

	public void setEquipoEmergencia(EquipoEmergencia equipoEmergencia) {
		this.equipoEmergencia = equipoEmergencia;
	}

	public List<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}

	public RecursoService getRecursoService() {
		return recursoService;
	}

	public void setRecursoService(RecursoService recursoService) {
		this.recursoService = recursoService;
	}

	public EquipoEmergenciaService getEquipoEmergenciaService() {
		return equipoEmergenciaService;
	}

	public void setEquipoEmergenciaService(EquipoEmergenciaService equipoEmergenciaService) {
		this.equipoEmergenciaService = equipoEmergenciaService;
	}
	
	public String registrarEquipoEmergencia(){
		
		return "paginas/operador/registroLlamada";
	}
	
}
