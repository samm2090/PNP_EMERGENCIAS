package pe.gob.pnp.emergencias.managedbean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pe.gob.pnp.emergencias.model.Rol;
import pe.gob.pnp.emergencias.service.RolService;

@ManagedBean
@SessionScoped
public class RolManagedBean {
	@ManagedProperty(value = "#{rolService}")
	private RolService rolService;
	private Rol rol = new Rol();
	private List<Rol> roles = new ArrayList<Rol>();

	public RolService getRolService() {
		return rolService;
	}

	public void setRolService(RolService rolService) {
		this.rolService = rolService;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public List<Rol> getRoles() {
		Iterable<Rol> it = rolService.getRolRepository().findAll();
		Iterator<Rol> iterator = it.iterator();
				
		roles.clear();
				
		while(iterator.hasNext()){
			roles.add(iterator.next());
		}
		
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

}
