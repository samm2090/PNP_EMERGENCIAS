package pe.gob.pnp.emergencias.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pe.gob.pnp.emergencias.service.TipoTerminalService;

@ManagedBean
@SessionScoped
public class TipoTerminalManagedBean {
	@ManagedProperty(value = "#{tipoTerminalService}")
	private TipoTerminalService tipoTerminalService;

	public TipoTerminalService getTipoTerminalService() {
		return tipoTerminalService;
	}

	public void setTipoTerminalService(TipoTerminalService tipoTerminalService) {
		this.tipoTerminalService = tipoTerminalService;
	}
	
}
