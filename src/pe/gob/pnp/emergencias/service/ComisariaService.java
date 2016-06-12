package pe.gob.pnp.emergencias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.gob.pnp.emergencias.repository.ComisariaRepository;


@Component
public class ComisariaService {
	@Autowired
	private ComisariaRepository comisariaRepository;

	public ComisariaRepository getComisariaRepository() {
		return comisariaRepository;
	}

	public void setComisariaRepository(ComisariaRepository comisariaRepository) {
		this.comisariaRepository = comisariaRepository;
	}
}
