package pe.gob.pnp.emergencias.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pe.gob.pnp.emergencias.service.TurnoService;

@ManagedBean
@SessionScoped
public class TurnoManagedBean {
	@ManagedProperty(value = "#{turnoService}")
	private TurnoService turnoService;

	public TurnoService getTurnoService() {
		return turnoService;
	}

	public void setTurnoService(TurnoService turnoService) {
		this.turnoService = turnoService;
	}
	
}
