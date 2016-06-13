package pe.gob.pnp.emergencias.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pe.gob.pnp.emergencias.service.RecursoEstadoService;

@ManagedBean
@SessionScoped
public class RecursoEstadoManagedBean {
	@ManagedProperty(value = "#{recursoEstadoService}")
	private RecursoEstadoService recursoEstadoService;

	public RecursoEstadoService getRecursoEstadoService() {
		return recursoEstadoService;
	}

	public void setRecursoEstadoService(RecursoEstadoService recursoEstadoService) {
		this.recursoEstadoService = recursoEstadoService;
	}
	
	
}
