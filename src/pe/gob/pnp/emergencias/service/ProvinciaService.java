package pe.gob.pnp.emergencias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.gob.pnp.emergencias.repository.ProvinciaRepository;

@Component
public class ProvinciaService {
	@Autowired
	private ProvinciaRepository provinciaRepository;

	public ProvinciaRepository getProvinciaRepository() {
		return provinciaRepository;
	}

	public void setProvinciaRepository(ProvinciaRepository provinciaRepository) {
		this.provinciaRepository = provinciaRepository;
	}
}
