package pe.gob.pnp.emergencias.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pe.gob.pnp.emergencias.model.Llamada;
import pe.gob.pnp.emergencias.service.CivilService;
import pe.gob.pnp.emergencias.service.LlamadaService;

@ManagedBean
@SessionScoped
public class LlamadaManagedBean {
	
	@ManagedProperty(value = "#{llamadaService}")
	private LlamadaService llamadaService;
	
	@ManagedProperty(value = "#{civilService}")
	private CivilService civilService;
	
	Llamada llamada = new Llamada();

	public Llamada getLlamada() {
		return llamada;
	}

	public void setLlamada(Llamada llamada) {
		this.llamada = llamada;
	}

	public LlamadaService getLlamadaService() {
		return llamadaService;
	}

	public void setLlamadaService(LlamadaService llamadaService) {
		this.llamadaService = llamadaService;
	}
	
	public String registrarLlamada(){
		
		llamadaService.getLlamadaRepository().save(llamada);
		llamada = new Llamada();
		
		return "paginas/operador/registroEmergencia";
	}
	
	public String falsaAlarma(){
		return null;
	}

}
