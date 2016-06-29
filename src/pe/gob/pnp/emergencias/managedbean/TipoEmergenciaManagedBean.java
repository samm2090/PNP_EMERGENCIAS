package pe.gob.pnp.emergencias.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.google.common.collect.Lists;

import pe.gob.pnp.emergencias.model.TipoEmergencia;
import pe.gob.pnp.emergencias.service.TipoEmergenciaService;

@ManagedBean
@SessionScoped
public class TipoEmergenciaManagedBean {
	@ManagedProperty(value = "#{tipoEmergenciaService}")
	private TipoEmergenciaService tipoEmergenciaService;
	
	private List<TipoEmergencia> tiposEmergencia = new ArrayList<TipoEmergencia>();

	public TipoEmergenciaService getTipoEmergenciaService() {
		return tipoEmergenciaService;
	}

	public void setTipoEmergenciaService(TipoEmergenciaService tipoEmergenciaService) {
		this.tipoEmergenciaService = tipoEmergenciaService;
	}

	public List<TipoEmergencia> getTiposEmergencia() {
		tiposEmergencia = Lists.newArrayList(tipoEmergenciaService.getTipoEmergenciaRepository().findAll());
		
		return tiposEmergencia;
	}

	public void setTiposEmergencia(List<TipoEmergencia> tiposEmergencia) {
		this.tiposEmergencia = tiposEmergencia;
	}
}
