package pe.gob.pnp.emergencias.managedbean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pe.gob.pnp.emergencias.model.Turno;
import pe.gob.pnp.emergencias.service.TurnoService;

@ManagedBean
@SessionScoped
public class TurnoManagedBean {
	@ManagedProperty(value = "#{turnoService}")
	private TurnoService turnoService;
	private Turno turno = new Turno();
	private List<Turno> turnos = new ArrayList<Turno>();

	public TurnoService getTurnoService() {
		return turnoService;
	}

	public void setTurnoService(TurnoService turnoService) {
		this.turnoService = turnoService;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public List<Turno> getTurnos() {
		Iterable<Turno> it = turnoService.getTurnoRepository().findAll();
		Iterator<Turno> iterator = it.iterator();
	
		turnos.clear();
		
		while(iterator.hasNext()){
			turnos.add(iterator.next());
		}
		
		return turnos;
	}

	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}
	
	
	
}
