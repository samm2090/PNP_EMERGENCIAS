package pe.gob.pnp.emergencias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.gob.pnp.emergencias.repository.EquipoEmergenciaRepository;

@Component
public class EquipoEmergenciaService {

	@Autowired
	private EquipoEmergenciaRepository emergenciaRepository;

	public EquipoEmergenciaRepository getEmergenciaRepository() {
		return emergenciaRepository;
	}

	public void setEmergenciaRepository(EquipoEmergenciaRepository emergenciaRepository) {
		this.emergenciaRepository = emergenciaRepository;
	}
}
