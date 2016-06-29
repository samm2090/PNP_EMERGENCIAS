package pe.gob.pnp.emergencias.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.google.common.collect.Lists;

import pe.gob.pnp.emergencias.model.Distrito;
import pe.gob.pnp.emergencias.service.DistritoService;

@ManagedBean
@SessionScoped
public class DistritoManagedBean {

	@ManagedProperty(value = "#{distritoService}")
	private DistritoService distritoService;
	
	private List<Distrito> distritos = new ArrayList<Distrito>();
	

	public List<Distrito> getDistritos() {
		distritos = Lists.newArrayList(distritoService.getDistritoRepository().findAll());
		return distritos;
	}
	
	public List<Distrito> getDistritosLima() {
		distritos = Lists.newArrayList(distritoService.getDistritoRepository().distritosLima(new Long(136)));
		return distritos;
	}

	public void setDistritos(List<Distrito> distritos) {
		this.distritos = distritos;
	}

	public DistritoService getDistritoService() {
		return distritoService;
	}

	public void setDistritoService(DistritoService distritoService) {
		this.distritoService = distritoService;
	}
	
}
