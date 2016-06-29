package pe.gob.pnp.emergencias.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.google.common.collect.Lists;

import pe.gob.pnp.emergencias.model.NivelEmergencia;
import pe.gob.pnp.emergencias.service.NivelEmergenciaService;

@ManagedBean
@SessionScoped
public class NivelEmergenciaManagedBean {
	
	@ManagedProperty(value = "#{nivelEmergenciaService}")
	private NivelEmergenciaService nivelEmergenciaService;

	private List<NivelEmergencia> nivelesEmergencia = new ArrayList<NivelEmergencia>();
	
	public NivelEmergenciaService getNivelEmergenciaService() {
		return nivelEmergenciaService;
	}

	public void setNivelEmergenciaService(NivelEmergenciaService nivelEmergenciaService) {
		this.nivelEmergenciaService = nivelEmergenciaService;
	}

	public List<NivelEmergencia> getNivelesEmergencia() {
		nivelesEmergencia = Lists.newArrayList(nivelEmergenciaService.getNivelEmergenciaRepository().findAll());
		return nivelesEmergencia;
	}

	public void setNivelesEmergencia(List<NivelEmergencia> nivelesEmergencia) {
		this.nivelesEmergencia = nivelesEmergencia;
	}
}
