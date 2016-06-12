package pe.gob.pnp.emergencias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.gob.pnp.emergencias.repository.RecursoRepository;


@Component
public class RecursoService {
	@Autowired
	private RecursoRepository recursoRepository;

	public RecursoRepository getRecursoRepository() {
		return recursoRepository;
	}

	public void setRecursoRepository(RecursoRepository recursoRepository) {
		this.recursoRepository = recursoRepository;
	}
}
