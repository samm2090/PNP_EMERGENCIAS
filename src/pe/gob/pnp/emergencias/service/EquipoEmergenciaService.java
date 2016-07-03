package pe.gob.pnp.emergencias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.gob.pnp.emergencias.repository.EquipoEmergenciaRepository;

@Component
public class EquipoEmergenciaService {

	@Autowired
	private EquipoEmergenciaRepository equipoEmergenciaRepository;

	public EquipoEmergenciaRepository getEquipoEmergenciaRepository() {
		return equipoEmergenciaRepository;
	}

	public void setEquipoEmergenciaRepository(EquipoEmergenciaRepository equipoEmergenciaRepository) {
		this.equipoEmergenciaRepository = equipoEmergenciaRepository;
	}

}
