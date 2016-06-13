package pe.gob.pnp.emergencias.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pe.gob.pnp.emergencias.service.EstadoService;

@ManagedBean
@SessionScoped
public class EstadoManagedBean {

	@ManagedProperty(value = "#{estadoService}")
	private EstadoService estadoService;

	public EstadoService getEstadoService() {
		return estadoService;
	}

	public void setEstadoService(EstadoService estadoService) {
		this.estadoService = estadoService;
	}
}
