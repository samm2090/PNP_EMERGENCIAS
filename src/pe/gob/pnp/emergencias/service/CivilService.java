package pe.gob.pnp.emergencias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.gob.pnp.emergencias.repository.CivilRepository;

@Component
public class CivilService {
	@Autowired
	private CivilRepository civilRepository;

	public CivilRepository getCivilRepository() {
		return civilRepository;
	}

	public void setCivilRepository(CivilRepository civilRepository) {
		this.civilRepository = civilRepository;
	}
}
