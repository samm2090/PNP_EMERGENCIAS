package pe.gob.pnp.emergencias.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pe.gob.pnp.emergencias.service.ComisariaService;

@ManagedBean
@SessionScoped
public class ComisariaManagedBean {
	
	@ManagedProperty(value = "#{comisariaService}")
	private ComisariaService comisariaService;

	public ComisariaService getComisariaService() {
		return comisariaService;
	}

	public void setComisariaService(ComisariaService comisariaService) {
		this.comisariaService = comisariaService;
	}

}
