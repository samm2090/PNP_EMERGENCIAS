package pe.gob.pnp.emergencias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.gob.pnp.emergencias.repository.TipoTerminalRepository;


@Component
public class TipoTerminalService {
	@Autowired
	private TipoTerminalRepository tipoTerminalRepository;

	public TipoTerminalRepository getTipoTerminalRepository() {
		return tipoTerminalRepository;
	}

	public void setTipoTerminalRepository(TipoTerminalRepository tipoTerminalRepository) {
		this.tipoTerminalRepository = tipoTerminalRepository;
	}
}
