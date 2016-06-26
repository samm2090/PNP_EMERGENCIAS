package pe.gob.pnp.emergencias.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.google.common.collect.Lists;

import pe.gob.pnp.emergencias.model.Civil;
import pe.gob.pnp.emergencias.model.Distrito;
import pe.gob.pnp.emergencias.model.Emergencia;
import pe.gob.pnp.emergencias.model.Llamada;
import pe.gob.pnp.emergencias.model.NivelEmergencia;
import pe.gob.pnp.emergencias.model.TipoEmergencia;
import pe.gob.pnp.emergencias.service.CivilService;
import pe.gob.pnp.emergencias.service.DistritoService;
import pe.gob.pnp.emergencias.service.EmergenciaService;
import pe.gob.pnp.emergencias.service.LlamadaService;
import pe.gob.pnp.emergencias.service.NivelEmergenciaService;
import pe.gob.pnp.emergencias.service.TipoEmergenciaService;

@ManagedBean
@SessionScoped
public class EmergenciaManagedBean {
	@ManagedProperty(value = "#{emergenciaService}")
	private EmergenciaService emergenciaService;

	@ManagedProperty(value = "#{distritoService}")
	private DistritoService distritoService;

	@ManagedProperty(value = "#{civilService}")
	private CivilService civilService;

	@ManagedProperty(value = "#{llamadaService}")
	private LlamadaService llamadaService;

	@ManagedProperty(value = "#{tipoEmergenciaService}")
	private TipoEmergenciaService tipoEmergenciaService;

	@ManagedProperty(value = "#{nivelEmergenciaService}")
	private NivelEmergenciaService nivelEmergenciaService;

	private Emergencia emergencia = new Emergencia();
	private Civil civil = new Civil();
	private Llamada llamada = new Llamada();
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

	public CivilService getCivilService() {
		return civilService;
	}

	public void setCivilService(CivilService civilService) {
		this.civilService = civilService;
	}

	public LlamadaService getLlamadaService() {
		return llamadaService;
	}

	public void setLlamadaService(LlamadaService llamadaService) {
		this.llamadaService = llamadaService;
	}

	public Civil getCivil() {
		return civil;
	}

	public void setCivil(Civil civil) {
		this.civil = civil;
	}

	public Llamada getLlamada() {
		return llamada;
	}

	public void setLlamada(Llamada llamada) {
		this.llamada = llamada;
	}
	
	public String contestarLlamada(){
		
		return "registroLlamada";
	}

	public String registrarEmergencia() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringData");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();

		try {
			
			

			tx.begin();

			Query q = manager
					.createNativeQuery("EXEC USP_REGISTRAR_EMERGENCIA ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?")
					.setParameter(1, civil.getCivDocumento()).setParameter(2, civil.getCivNombre())
					.setParameter(3, civil.getCivApellidoPaterno()).setParameter(4, civil.getCivApellidoMaterno())
					.setParameter(5, civil.getCivTelefono()).setParameter(6, civil.getFechaRegistro())
					.setParameter(7, llamada.getLlaFecha()).setParameter(8, llamada.getLlaObservacion())
					.setParameter(9, llamada.getLlaTelefono()).setParameter(10, llamada.getTipoTerminal().getTteId())
					.setParameter(11, llamada.getOperador()).setParameter(12, llamada.getLlaHoraInicio())
					.setParameter(13, llamada.getLlaHoraFin())
					.setParameter(14, emergencia.getNivelEmergencia().getNemId())
					.setParameter(15, emergencia.getTipoEmergencia().getTemId())
					.setParameter(16, emergencia.getDistrito().getDisId()).setParameter(17, emergencia.getEmeDir())
					.setParameter(18, emergencia.getEmeObservacion()).setParameter(19, emergencia.getEmeFecha())
					.setParameter(20, emergencia.getEmeHoraInicio()).setParameter(21, emergencia.getEmeHoraFin());
			
			q.executeUpdate();

			tx.commit();

			civil = new Civil();
			llamada = new Llamada();
			emergencia = new Emergencia();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		return "registroRecursosEmergencia";
	}

}
