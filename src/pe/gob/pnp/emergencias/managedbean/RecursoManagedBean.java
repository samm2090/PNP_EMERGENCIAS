package pe.gob.pnp.emergencias.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pe.gob.pnp.emergencias.service.RecursoService;

@ManagedBean
@SessionScoped
public class RecursoManagedBean {
	@ManagedProperty(value = "#{recursoService}")
	private RecursoService recursoService;

	public RecursoService getRecursoService() {
		return recursoService;
	}

	public void setRecursoService(RecursoService recursoService) {
		this.recursoService = recursoService;
	}
}
