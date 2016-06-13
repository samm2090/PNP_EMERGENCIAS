package pe.gob.pnp.emergencias.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class NivelEmergenciaManagedBean {
	@ManagedProperty(value = "#{nivelEmergenciaManagedBean}")
	private NivelEmergenciaManagedBean nivelEmergenciaManagedBean;

	public NivelEmergenciaManagedBean getNivelEmergenciaManagedBean() {
		return nivelEmergenciaManagedBean;
	}

	public void setNivelEmergenciaManagedBean(NivelEmergenciaManagedBean nivelEmergenciaManagedBean) {
		this.nivelEmergenciaManagedBean = nivelEmergenciaManagedBean;
	}
}
