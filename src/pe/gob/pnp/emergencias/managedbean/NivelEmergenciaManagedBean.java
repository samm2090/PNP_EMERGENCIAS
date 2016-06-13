package pe.gob.pnp.emergencias.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pe.gob.pnp.emergencias.service.NivelEmergenciaService;

@ManagedBean
@SessionScoped
public class NivelEmergenciaManagedBean {
	@ManagedProperty(value = "#{nivelEmergenciaManagedBean}")
	private NivelEmergenciaService nivelEmergenciaService;

	public NivelEmergenciaService getNivelEmergenciaService() {
		return nivelEmergenciaService;
	}

	public void setNivelEmergenciaService(NivelEmergenciaService nivelEmergenciaService) {
		this.nivelEmergenciaService = nivelEmergenciaService;
	}

}
