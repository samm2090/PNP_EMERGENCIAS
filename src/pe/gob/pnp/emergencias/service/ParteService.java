package pe.gob.pnp.emergencias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.gob.pnp.emergencias.repository.ParteRepository;

@Component
public class ParteService {
	@Autowired
	private ParteRepository parteRepository;

	public ParteRepository getParteRepository() {
		return parteRepository;
	}

	public void setParteRepository(ParteRepository parteRepository) {
		this.parteRepository = parteRepository;
	}

}
