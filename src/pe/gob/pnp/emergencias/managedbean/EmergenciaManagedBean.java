package pe.gob.pnp.emergencias.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.google.common.collect.Lists;

import pe.gob.pnp.emergencias.model.Distrito;
import pe.gob.pnp.emergencias.model.Emergencia;
import pe.gob.pnp.emergencias.model.NivelEmergencia;
import pe.gob.pnp.emergencias.model.TipoEmergencia;
import pe.gob.pnp.emergencias.service.DistritoService;
import pe.gob.pnp.emergencias.service.EmergenciaService;
import pe.gob.pnp.emergencias.service.NivelEmergenciaService;
import pe.gob.pnp.emergencias.service.TipoEmergenciaService;

@ManagedBean
@SessionScoped
public class EmergenciaManagedBean {
	@ManagedProperty(value = "#{emergenciaService}")
	private EmergenciaService emergenciaService;
	
	@ManagedProperty(value = "#{distritoService}")
	private DistritoService distritoService;
	
	@ManagedProperty(value = "#{tipoEmergenciaService}")
	private TipoEmergenciaService tipoEmergenciaService;
	
	@ManagedProperty(value = "#{nivelEmergenciaService}")
	private NivelEmergenciaService nivelEmergenciaService;
	
	private Emergencia emergencia = new Emergencia();
	private List<Distrito> distritos = new ArrayList<Distrito>();
	private List<TipoEmergencia> tiposEmergencia = new ArrayList<TipoEmergencia>();
	private List<NivelEmergencia> nivelesEmergencia = new ArrayList<NivelEmergencia>();
	
	public TipoEmergenciaService getTipoEmergenciaService() {
		return tipoEmergenciaService;
	}

	public void setTipoEmergenciaService(TipoEmergenciaService tipoEmergenciaService) {
		this.tipoEmergenciaService = tipoEmergenciaService;
	}

	public NivelEmergenciaService getNivelEmergenciaService() {
		return nivelEmergenciaService;
	}

	public void setNivelEmergenciaService(NivelEmergenciaService nivelEmergenciaService) {
		this.nivelEmergenciaService = nivelEmergenciaService;
	}

	public List<TipoEmergencia> getTiposEmergencia() {
		tiposEmergencia = Lists.newArrayList(tipoEmergenciaService.getTipoEmergenciaRepository().findAll());
		return tiposEmergencia;
	}

	public void setTiposEmergencia(List<TipoEmergencia> tiposEmergencia) {
		this.tiposEmergencia = tiposEmergencia;
	}


	public List<NivelEmergencia> getNivelesEmergencia() {
		nivelesEmergencia = Lists.newArrayList(nivelEmergenciaService.getNivelEmergenciaRepository().findAll());
		return nivelesEmergencia;
	}

	public void setNivelesEmergencia(List<NivelEmergencia> nivelesEmergencia) {
		this.nivelesEmergencia = nivelesEmergencia;
	}

	public Emergencia getEmergencia() {
		return emergencia;
	}

	public void setEmergencia(Emergencia emergencia) {
		this.emergencia = emergencia;
	}

	public DistritoService getDistritoService() {
		return distritoService;
	}

	public void setDistritoService(DistritoService distritoService) {
		this.distritoService = distritoService;
	}

	public List<Distrito> getDistritos() {
		
		distritos = Lists.newArrayList(distritoService.getDistritoRepository().distritosLima(new Long(136)));
		return distritos;
	}
	
	public void setDistritos(List<Distrito> distritos) {
		this.distritos = distritos;
	}

	public EmergenciaService getEmergenciaService() {
		return emergenciaService;
	}

	public void setEmergenciaService(EmergenciaService emergenciaService) {
		this.emergenciaService = emergenciaService;
	}
	
	public String registrarEmergencia(){
		return "registroRecursosEmergencia";
	}
}
