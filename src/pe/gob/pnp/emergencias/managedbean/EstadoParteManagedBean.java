package pe.gob.pnp.emergencias.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pe.gob.pnp.emergencias.service.EstadoParteService;

@ManagedBean
@SessionScoped
public class EstadoParteManagedBean {
	@ManagedProperty(value = "#{estadoParteService}")
	private EstadoParteService estadoParteService;

	public EstadoParteService getEstadoParteService() {
		return estadoParteService;
	}

	public void setEstadoParteService(EstadoParteService estadoParteService) {
		this.estadoParteService = estadoParteService;
	}
	
}
