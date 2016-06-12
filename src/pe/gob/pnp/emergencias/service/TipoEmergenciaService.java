package pe.gob.pnp.emergencias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.gob.pnp.emergencias.repository.TipoEmergenciaRepository;


@Component
public class TipoEmergenciaService {
	@Autowired
	private TipoEmergenciaRepository tipoEmergenciaRepository;

	public TipoEmergenciaRepository getTipoEmergenciaRepository() {
		return tipoEmergenciaRepository;
	}

	public void setTipoEmergenciaRepository(TipoEmergenciaRepository tipoEmergenciaRepository) {
		this.tipoEmergenciaRepository = tipoEmergenciaRepository;
	}
}
