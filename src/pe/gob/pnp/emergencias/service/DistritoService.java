package pe.gob.pnp.emergencias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.gob.pnp.emergencias.repository.DistritoRepository;


@Component
public class DistritoService {
	@Autowired
	private DistritoRepository distritoRepository;

	public DistritoRepository getDistritoRepository() {
		return distritoRepository;
	}

	public void setDistritoRepository(DistritoRepository distritoRepository) {
		this.distritoRepository = distritoRepository;
	}
}
