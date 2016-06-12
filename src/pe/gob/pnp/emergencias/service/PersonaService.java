package pe.gob.pnp.emergencias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.gob.pnp.emergencias.repository.PersonaRepository;

@Component
public class PersonaService {
	@Autowired
	private PersonaRepository personaRepository;

	public PersonaRepository getPersonaRepository() {
		return personaRepository;
	}

	public void setPersonaRepository(PersonaRepository personaRepository) {
		this.personaRepository = personaRepository;
	}
}
