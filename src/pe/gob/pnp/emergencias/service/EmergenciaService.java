package pe.gob.pnp.emergencias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.gob.pnp.emergencias.repository.EmergenciaRepository;


@Component
public class EmergenciaService {
	@Autowired
	private EmergenciaRepository emergenciaRepository;

	public EmergenciaRepository getEmergenciaRepository() {
		return emergenciaRepository;
	}

	public void setEmergenciaRepository(EmergenciaRepository emergenciaRepository) {
		this.emergenciaRepository = emergenciaRepository;
	}
}
