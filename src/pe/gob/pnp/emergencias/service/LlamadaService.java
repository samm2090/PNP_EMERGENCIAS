package pe.gob.pnp.emergencias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.gob.pnp.emergencias.repository.LlamadaRepository;


@Component
public class LlamadaService {

	@Autowired
	private LlamadaRepository llamadaRepository;

	public LlamadaRepository getLlamadaRepository() {
		return llamadaRepository;
	}

	public void setLlamadaRepository(LlamadaRepository llamadaRepository) {
		this.llamadaRepository = llamadaRepository;
	}
}
