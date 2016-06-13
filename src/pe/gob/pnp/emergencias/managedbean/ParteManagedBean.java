package pe.gob.pnp.emergencias.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pe.gob.pnp.emergencias.service.ParteService;

@ManagedBean
@SessionScoped
public class ParteManagedBean {
	@ManagedProperty(value = "#{parteService}")
	private ParteService parteService;

	public ParteService getParteService() {
		return parteService;
	}

	public void setParteService(ParteService parteService) {
		this.parteService = parteService;
	}
	
}
