package pe.gob.pnp.emergencias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.gob.pnp.emergencias.repository.EstadoParteRepository;


@Component
public class EstadoParteService {
	@Autowired
	private EstadoParteRepository estadoParteRepository;

	public EstadoParteRepository getEstadoParteRepository() {
		return estadoParteRepository;
	}

	public void setEstadoParteRepository(EstadoParteRepository estadoParteRepository) {
		this.estadoParteRepository = estadoParteRepository;
	}
}
