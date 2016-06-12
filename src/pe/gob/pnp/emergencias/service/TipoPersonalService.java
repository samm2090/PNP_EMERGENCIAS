package pe.gob.pnp.emergencias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.gob.pnp.emergencias.repository.TipoPersonalRepository;

@Component
public class TipoPersonalService {
	@Autowired
	private TipoPersonalRepository tipoPersonalRepository;

	public TipoPersonalRepository getTipoPersonalRepository() {
		return tipoPersonalRepository;
	}

	public void setTipoPersonalRepository(TipoPersonalRepository tipoPersonalRepository) {
		this.tipoPersonalRepository = tipoPersonalRepository;
	}
}
