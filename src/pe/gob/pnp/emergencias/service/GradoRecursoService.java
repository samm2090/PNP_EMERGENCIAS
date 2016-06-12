package pe.gob.pnp.emergencias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.gob.pnp.emergencias.repository.GradoRecursoRepository;


@Component
public class GradoRecursoService {
	@Autowired
	private GradoRecursoRepository gradoRecursoRepository;

	public GradoRecursoRepository getGradoRecursoRepository() {
		return gradoRecursoRepository;
	}

	public void setGradoRecursoRepository(GradoRecursoRepository gradoRecursoRepository) {
		this.gradoRecursoRepository = gradoRecursoRepository;
	}
}
