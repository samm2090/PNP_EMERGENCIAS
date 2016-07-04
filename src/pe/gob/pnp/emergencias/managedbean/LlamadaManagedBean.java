package pe.gob.pnp.emergencias.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import pe.gob.pnp.emergencias.model.Civil;
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

	private Llamada llamada = new Llamada();

	private Civil civil = new Civil();

	public Llamada getLlamada() {
		return llamada;
	}

	public void setLlamada(Llamada llamada) {
		this.llamada = llamada;
	}

	public CivilService getCivilService() {
		return civilService;
	}

	public void setCivilService(CivilService civilService) {
		this.civilService = civilService;
	}

	public Civil getCivil() {
		return civil;
	}

	public void setCivil(Civil civil) {
		this.civil = civil;
	}

	public LlamadaService getLlamadaService() {
		return llamadaService;
	}

	public void setLlamadaService(LlamadaService llamadaService) {
		this.llamadaService = llamadaService;
	}

	public String falsaAlarma() {
		return null;
	}

	public List<Llamada> llamadasFalsas() {
		return llamadaService.getLlamadaRepository().llamadasEstado(false);
	}

	public List<Llamada> llamadasAtendidas() {
		return llamadaService.getLlamadaRepository().llamadasEstado(true);
	}

	public int totalMinutos() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringData");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createNativeQuery("SP_MINUTOSLLAMADAS");

		int resultado = (int) q.getResultList().get(0);

		return resultado;
	}

	public String irPaginaLlamada() {

		return "registroLlamada?faces-redirect=true";
	}

	public String irPaginaLogLlamada() {

		return "logLlamada?faces-redirect=true";
	}

}
