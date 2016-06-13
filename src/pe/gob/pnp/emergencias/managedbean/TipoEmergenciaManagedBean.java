package pe.gob.pnp.emergencias.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pe.gob.pnp.emergencias.service.TipoEmergenciaService;

@ManagedBean
@SessionScoped
public class TipoEmergenciaManagedBean {
	@ManagedProperty(value = "#{tipoEmergenciaService}")
	private TipoEmergenciaService tipoEmergenciaService;

	public TipoEmergenciaService getTipoEmergenciaService() {
		return tipoEmergenciaService;
	}

	public void setTipoEmergenciaService(TipoEmergenciaService tipoEmergenciaService) {
		this.tipoEmergenciaService = tipoEmergenciaService;
	}
}
