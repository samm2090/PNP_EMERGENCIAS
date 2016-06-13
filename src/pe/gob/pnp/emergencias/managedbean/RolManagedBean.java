package pe.gob.pnp.emergencias.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pe.gob.pnp.emergencias.service.RolService;

@ManagedBean
@SessionScoped
public class RolManagedBean {
	@ManagedProperty(value = "#{rolService}")
	private RolService rolService;

	public RolService getRolService() {
		return rolService;
	}

	public void setRolService(RolService rolService) {
		this.rolService = rolService;
	}
	
}
