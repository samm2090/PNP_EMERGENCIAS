package pe.gob.pnp.emergencias.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pe.gob.pnp.emergencias.service.EmergenciaService;

@ManagedBean
@SessionScoped
public class EmergenciaManagedBean {
	@ManagedProperty(value = "#{emergenciaService}")
	private EmergenciaService emergenciaService;

	public EmergenciaService getEmergenciaService() {
		return emergenciaService;
	}

	public void setEmergenciaService(EmergenciaService emergenciaService) {
		this.emergenciaService = emergenciaService;
	}
}
