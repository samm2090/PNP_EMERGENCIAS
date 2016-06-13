package pe.gob.pnp.emergencias.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pe.gob.pnp.emergencias.service.ProvinciaService;

@ManagedBean
@SessionScoped
public class ProvinciaManagedBean {
	@ManagedProperty(value = "#{provinciaService}")
	private ProvinciaService provinciaService;

	public ProvinciaService getProvinciaService() {
		return provinciaService;
	}

	public void setProvinciaService(ProvinciaService provinciaService) {
		this.provinciaService = provinciaService;
	}
	
}
