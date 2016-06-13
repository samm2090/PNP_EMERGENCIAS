package pe.gob.pnp.emergencias.service;

import pe.gob.pnp.emergencias.repository.RecursoEstadoRepository;

public class RecursoEstadoService {
	private RecursoEstadoRepository recursoEstadoRepository;

	public RecursoEstadoRepository getRecursoEstadoRepository() {
		return recursoEstadoRepository;
	}

	public void setRecursoEstadoRepository(RecursoEstadoRepository recursoEstadoRepository) {
		this.recursoEstadoRepository = recursoEstadoRepository;
	}
}
