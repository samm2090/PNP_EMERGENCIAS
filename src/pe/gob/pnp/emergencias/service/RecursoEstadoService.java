package pe.gob.pnp.emergencias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.gob.pnp.emergencias.repository.RecursoEstadoRepository;

@Component
public class RecursoEstadoService {
	
	@Autowired
	private RecursoEstadoRepository recursoEstadoRepository;

	public RecursoEstadoRepository getRecursoEstadoRepository() {
		return recursoEstadoRepository;
	}

	public void setRecursoEstadoRepository(RecursoEstadoRepository recursoEstadoRepository) {
		this.recursoEstadoRepository = recursoEstadoRepository;
	}
}
