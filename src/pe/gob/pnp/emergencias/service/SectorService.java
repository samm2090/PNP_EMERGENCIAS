package pe.gob.pnp.emergencias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.gob.pnp.emergencias.repository.SectorRepository;

@Component
public class SectorService {
	@Autowired
	private SectorRepository sectorRepository;

	public SectorRepository getSectorRepository() {
		return sectorRepository;
	}

	public void setSectorRepository(SectorRepository sectorRepository) {
		this.sectorRepository = sectorRepository;
	}
	
}
