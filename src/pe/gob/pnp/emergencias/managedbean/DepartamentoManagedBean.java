package pe.gob.pnp.emergencias.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pe.gob.pnp.emergencias.service.DepartamentoService;

@ManagedBean
@SessionScoped
public class DepartamentoManagedBean {

	@ManagedProperty(value = "#{departamentoService}")
	private DepartamentoService departamentoService;

	public DepartamentoService getDepartamentoService() {
		return departamentoService;
	}

	public void setDepartamentoService(DepartamentoService departamentoService) {
		this.departamentoService = departamentoService;
	}
}
