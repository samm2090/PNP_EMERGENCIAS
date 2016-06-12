package pe.gob.pnp.emergencias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.gob.pnp.emergencias.repository.TurnoRepository;

@Component
public class TurnoService {
	@Autowired
	private TurnoRepository turnoRepository;

	public TurnoRepository getTurnoRepository() {
		return turnoRepository;
	}

	public void setTurnoRepository(TurnoRepository turnoRepository) {
		this.turnoRepository = turnoRepository;
	}
}
