package pe.gob.pnp.emergencias.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pe.gob.pnp.emergencias.service.OperadorService;

@ManagedBean
@SessionScoped
public class OperadorManagedBean {
	@ManagedProperty(value = "#{operadorService}")
	private OperadorService operadorService;

	public OperadorService getOperadorService() {
		return operadorService;
	}

	public void setOperadorService(OperadorService operadorService) {
		this.operadorService = operadorService;
	}
	
}
