package pe.gob.pnp.emergencias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.gob.pnp.emergencias.repository.DistritoRepository;
import pe.gob.pnp.emergencias.repository.RolRepository;

@Component
public class RolService {
	@Autowired
	private RolRepository rolRepository;

	public RolRepository getRolRepository() {
		return rolRepository;
	}

	public void setRolRepository(RolRepository rolRepository) {
		this.rolRepository = rolRepository;
	}
}
