package pe.gob.pnp.emergencias.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pe.gob.pnp.emergencias.model.TipoPersonal;

@ManagedBean
@SessionScoped
public class TipoPersonalManagedBean {
	@ManagedProperty(value = "#{tipoPersonal}")
	private TipoPersonal tipoPersonal;

	public TipoPersonal getTipoPersonal() {
		return tipoPersonal;
	}

	public void setTipoPersonal(TipoPersonal tipoPersonal) {
		this.tipoPersonal = tipoPersonal;
	}
	
}
