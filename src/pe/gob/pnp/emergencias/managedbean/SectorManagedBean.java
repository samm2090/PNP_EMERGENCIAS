package pe.gob.pnp.emergencias.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pe.gob.pnp.emergencias.service.SectorService;

@ManagedBean
@SessionScoped
public class SectorManagedBean {
	@ManagedProperty(value = "#{sectorService}")
	private SectorService sectorService;

	public SectorService getSectorService() {
		return sectorService;
	}

	public void setSectorService(SectorService sectorService) {
		this.sectorService = sectorService;
	}
}
