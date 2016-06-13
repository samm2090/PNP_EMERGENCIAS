package pe.gob.pnp.emergencias.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pe.gob.pnp.emergencias.service.CivilService;

@ManagedBean
@SessionScoped
public class CivilManagedBean {
	
	@ManagedProperty(value = "#{civilService}")
	private CivilService civilService;

	public CivilService getCivilService() {
		return civilService;
	}

	public void setCivilService(CivilService civilService) {
		this.civilService = civilService;
	}
}
