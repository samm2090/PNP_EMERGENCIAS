package pe.gob.pnp.emergencias.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pe.gob.pnp.emergencias.service.DistritoService;

@ManagedBean
@SessionScoped
public class DistritoManagedBean {

	@ManagedProperty(value = "#{distritoService}")
	private DistritoService distritoService;

	public DistritoService getDistritoService() {
		return distritoService;
	}

	public void setDistritoService(DistritoService distritoService) {
		this.distritoService = distritoService;
	}
	
}
