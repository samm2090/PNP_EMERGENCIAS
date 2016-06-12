package pe.gob.pnp.emergencias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EquipoEmergenciaService {
	@Autowired
	private EquipoEmergenciaService equipoEmergenciaRepository;

	public EquipoEmergenciaService getEquipoEmergenciaRepository() {
		return equipoEmergenciaRepository;
	}

	public void setEquipoEmergenciaRepository(EquipoEmergenciaService equipoEmergenciaRepository) {
		this.equipoEmergenciaRepository = equipoEmergenciaRepository;
	}
}
