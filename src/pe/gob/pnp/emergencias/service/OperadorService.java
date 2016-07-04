package pe.gob.pnp.emergencias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.gob.pnp.emergencias.repository.OperadorRepository;


@Component
public class OperadorService {
	
	@Autowired
	private OperadorRepository operadorRepository;

	public OperadorRepository getOperadorRepository() {
		return operadorRepository;
	}

	public void setOperadorRepository(OperadorRepository operadorRepository) {
		this.operadorRepository = operadorRepository;
	}
}
