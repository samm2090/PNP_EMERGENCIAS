package pe.gob.pnp.emergencias.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.google.common.collect.Lists;

import pe.gob.pnp.emergencias.model.EstadoParte;
import pe.gob.pnp.emergencias.service.EstadoParteService;

@ManagedBean
@SessionScoped
public class EstadoParteManagedBean {
	@ManagedProperty(value = "#{estadoParteService}")
	private EstadoParteService estadoParteService;

	private EstadoParte estadoParte = new EstadoParte();

	private List<EstadoParte> estadoPartes = new ArrayList<EstadoParte>();

	public EstadoParteService getEstadoParteService() {
		return estadoParteService;
	}

	public void setEstadoParteService(EstadoParteService estadoParteService) {
		this.estadoParteService = estadoParteService;
	}

	public EstadoParte getEstadoParte() {
		return estadoParte;
	}

	public void setEstadoParte(EstadoParte estadoParte) {
		this.estadoParte = estadoParte;
	}

	public List<EstadoParte> getEstadoPartes() {
		estadoPartes = Lists.newArrayList(estadoParteService.getEstadoParteRepository().findAll());
		return estadoPartes;
	}

	public void setEstadoPartes(List<EstadoParte> estadoPartes) {
		this.estadoPartes = estadoPartes;
	}

}
