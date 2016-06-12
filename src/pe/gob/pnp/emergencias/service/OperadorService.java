package pe.gob.pnp.emergencias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.gob.pnp.emergencias.repository.OperadoRepository;


@Component
public class OperadorService {
	@Autowired
	private OperadoRepository operadorRepository;

	public OperadoRepository getOperadorRepository() {
		return operadorRepository;
	}

	public void setOperadorRepository(OperadoRepository operadorRepository) {
		this.operadorRepository = operadorRepository;
	}	
}
