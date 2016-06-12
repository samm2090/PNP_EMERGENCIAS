package pe.gob.pnp.emergencias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.gob.pnp.emergencias.repository.NivelEmergenciaRepository;


@Component
public class NivelEmergenciaService {
	@Autowired
	private NivelEmergenciaRepository nivelEmergenciaRepository;

	public NivelEmergenciaRepository getNivelEmergenciaRepository() {
		return nivelEmergenciaRepository;
	}

	public void setNivelEmergenciaRepository(NivelEmergenciaRepository nivelEmergenciaRepository) {
		this.nivelEmergenciaRepository = nivelEmergenciaRepository;
	}
}
