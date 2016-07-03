package pe.gob.pnp.emergencias.managedbean;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
=======
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
>>>>>>> origin/master

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import pe.gob.pnp.emergencias.model.Emergencia;
<<<<<<< HEAD
import pe.gob.pnp.emergencias.model.EquipoEmergencia;
import pe.gob.pnp.emergencias.model.EstadoParte;
import pe.gob.pnp.emergencias.model.Llamada;
import pe.gob.pnp.emergencias.model.NivelEmergencia;
import pe.gob.pnp.emergencias.model.Parte;
import pe.gob.pnp.emergencias.model.Recurso;
import pe.gob.pnp.emergencias.model.TipoEmergencia;
import pe.gob.pnp.emergencias.service.CivilService;
import pe.gob.pnp.emergencias.service.DistritoService;
import pe.gob.pnp.emergencias.service.EmergenciaService;
import pe.gob.pnp.emergencias.service.EquipoEmergenciaService;
import pe.gob.pnp.emergencias.service.EstadoParteService;
import pe.gob.pnp.emergencias.service.LlamadaService;
import pe.gob.pnp.emergencias.service.NivelEmergenciaService;
import pe.gob.pnp.emergencias.service.ParteService;
import pe.gob.pnp.emergencias.service.RecursoService;
import pe.gob.pnp.emergencias.service.TipoEmergenciaService;
=======
import pe.gob.pnp.emergencias.service.EmergenciaService;
>>>>>>> origin/master

@ManagedBean
@SessionScoped
public class EmergenciaManagedBean {
	@ManagedProperty(value = "#{emergenciaService}")
	private EmergenciaService emergenciaService;

<<<<<<< HEAD
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

	@ManagedProperty(value = "#{recursoService}")
	private RecursoService recursoService;

	@ManagedProperty(value = "#{equipoEmergenciaService}")
	private EquipoEmergenciaService equipoEmergenciaService;

	@ManagedProperty(value = "#{estadoParteService}")
	private EstadoParteService estadoParteService;

	@ManagedProperty(value = "#{parteService}")
	private ParteService parteService;

	private Recurso recurso = new Recurso();
	private Emergencia emergencia = new Emergencia();
	private Civil civil = new Civil();
	private Llamada llamada = new Llamada();
	private EquipoEmergencia equipoEmergencia = new EquipoEmergencia();
	private EstadoParte estadoParte = new EstadoParte();
	private Parte parte = new Parte();

	private List<Distrito> distritos = new ArrayList<Distrito>();
	private List<TipoEmergencia> tiposEmergencia = new ArrayList<TipoEmergencia>();
	private List<NivelEmergencia> nivelesEmergencia = new ArrayList<NivelEmergencia>();
	private List<EquipoEmergencia> equipoEmergencias = new ArrayList<EquipoEmergencia>();
	private List<Emergencia> emergencias = new ArrayList<Emergencia>();
	private List<EstadoParte> estadoPartes = new ArrayList<EstadoParte>();
	private List<Parte> partes = new ArrayList<Parte>();

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
=======
	private Emergencia emergencia = new Emergencia();
>>>>>>> origin/master

	public Emergencia getEmergencia() {
		return emergencia;
	}

	public void setEmergencia(Emergencia emergencia) {
		this.emergencia = emergencia;
	}

	public EmergenciaService getEmergenciaService() {
		return emergenciaService;
	}

	public void setEmergenciaService(EmergenciaService emergenciaService) {
		this.emergenciaService = emergenciaService;
	}

	public String contestarLlamada() {

		Random random = new Random();
		Calendar ahora = Calendar.getInstance();

		int terminalAleatorio = random.nextInt((2 - 1) + 1) + 1;

		if (terminalAleatorio == 1) {
			int numeroFijo = random.nextInt((9999999 - 1000000) + 1) + 1000000;
			emergencia.getLlamada().getTipoTerminal().setTteId(new Long(1));
			emergencia.getLlamada().setLlaTelefono("01" + numeroFijo);
		} else {
			int numeroCelular = random.nextInt((99999999 - 10000000) + 1) + 10000000;
			emergencia.getLlamada().getTipoTerminal().setTteId(new Long(2));
			emergencia.getLlamada().setLlaTelefono("9" + numeroCelular);
		}

		emergencia.getLlamada().setLlaHoraInicio(ahora.get(Calendar.HOUR_OF_DAY) + ":" + ahora.get(Calendar.MINUTE));

<<<<<<< HEAD
	public void setLlamada(Llamada llamada) {
		this.llamada = llamada;
	}

	public RecursoService getRecursoService() {
		return recursoService;
	}

	public void setRecursoService(RecursoService recursoService) {
		this.recursoService = recursoService;
	}

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

	public EquipoEmergenciaService getEquipoEmergenciaService() {
		return equipoEmergenciaService;
	}

	public void setEquipoEmergenciaService(EquipoEmergenciaService equipoEmergenciaService) {
		this.equipoEmergenciaService = equipoEmergenciaService;
	}

	public EquipoEmergencia getEquipoEmergencia() {
		return equipoEmergencia;
	}

	public void setEquipoEmergencia(EquipoEmergencia equipoEmergencia) {
		this.equipoEmergencia = equipoEmergencia;
	}

	public List<EquipoEmergencia> getEquipoEmergencias() {
		return equipoEmergencias;
	}

	public void setEquipoEmergencias(List<EquipoEmergencia> equipoEmergencias) {
		this.equipoEmergencias = equipoEmergencias;
	}

	public String contestarLlamada() {

=======
>>>>>>> origin/master
		return "registroLlamada";
	}

	public List<Emergencia> getEmergencias() {
		emergencias = Lists.newArrayList(emergenciaService.getEmergenciaRepository().findAll());
		return emergencias;
	}

	public void setEmergencias(List<Emergencia> emergencias) {
		this.emergencias = emergencias;
	}

	public EstadoParteService getEstadoParteService() {
		return estadoParteService;
	}

	public void setEstadoParteService(EstadoParteService estadoParteService) {
		this.estadoParteService = estadoParteService;
	}

	public ParteService getParteService() {
		return parteService;
	}

	public void setParteService(ParteService parteService) {
		this.parteService = parteService;
	}

	public EstadoParte getEstadoParte() {
		return estadoParte;
	}

	public void setEstadoParte(EstadoParte estadoParte) {
		this.estadoParte = estadoParte;
	}

	public Parte getParte() {
		return parte;
	}

	public void setParte(Parte parte) {
		this.parte = parte;
	}

	public List<EstadoParte> getEstadoPartes() {
		return estadoPartes;
	}

	public void setEstadoPartes(List<EstadoParte> estadoPartes) {
		this.estadoPartes = estadoPartes;
	}

	public List<Parte> getPartes() {
		return partes;
	}

	public void setPartes(List<Parte> partes) {
		this.partes = partes;
	}

	public String registrarEmergencia() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringData");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
	
		try {
<<<<<<< HEAD

=======
			Date hoy = new Date();
			Calendar ahora = Calendar.getInstance();
			
			emergencia.getLlamada().getCivil().setFechaRegistro(hoy);
			emergencia.getLlamada().setLlaFecha(hoy);
			emergencia.setEmeFecha(hoy);
			emergencia.getLlamada().setLlaHoraFin(ahora.get(Calendar.HOUR_OF_DAY) + ":" + ahora.get(Calendar.MINUTE));
			emergencia.getLlamada().getOperador().setOpeId(new Long(1));;
>>>>>>> origin/master
			tx.begin();

			Query q = manager
					.createNativeQuery("EXEC USP_REGISTRAR_EMERGENCIA ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?")
					.setParameter(1, emergencia.getLlamada().getCivil().getCivDocumento())
					.setParameter(2, emergencia.getLlamada().getCivil().getCivNombre())
					.setParameter(3, emergencia.getLlamada().getCivil().getCivApellidoPaterno())
					.setParameter(4, emergencia.getLlamada().getCivil().getCivApellidoMaterno())
					.setParameter(5, emergencia.getLlamada().getCivil().getCivTelefono())
					.setParameter(6, emergencia.getLlamada().getCivil().getFechaRegistro())
					.setParameter(7, emergencia.getLlamada().getLlaFecha())
					.setParameter(8, emergencia.getLlamada().getLlaObservacion())
					.setParameter(9, emergencia.getLlamada().getLlaTelefono())
					.setParameter(10, emergencia.getLlamada().getTipoTerminal().getTteId())
					.setParameter(11, emergencia.getLlamada().getOperador().getOpeId())
					.setParameter(12, emergencia.getLlamada().getLlaHoraInicio())
					.setParameter(13, emergencia.getLlamada().getLlaHoraFin())
					.setParameter(14, emergencia.getNivelEmergencia().getNemId())
					.setParameter(15, emergencia.getTipoEmergencia().getTemId())
					.setParameter(16, emergencia.getDistrito().getDisId()).setParameter(17, emergencia.getEmeDir())
					.setParameter(18, emergencia.getEmeObservacion()).setParameter(19, emergencia.getEmeFecha())
					.setParameter(20, emergencia.getEmeHoraInicio()).setParameter(21, emergencia.getEmeHoraFin())
					.setParameter(22, emergencia.getLatitud()).setParameter(23, emergencia.getLongitud());

			q.executeUpdate();

			tx.commit();
			
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("emergencia", emergencia);

			emergencia = new Emergencia();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		return "registroEquipoEmergencia";
	}
	
	public String registrarLlamadaFalsa(){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringData");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		
		try {
			Date hoy = new Date();
			Calendar ahora = Calendar.getInstance();
			
			emergencia.getLlamada().getCivil().setFechaRegistro(hoy);
			emergencia.getLlamada().setLlaFecha(hoy);
			emergencia.getLlamada().setLlaHoraFin(ahora.get(Calendar.HOUR_OF_DAY) + ":" + ahora.get(Calendar.MINUTE));
			emergencia.getLlamada().getOperador().setOpeId(new Long(1));;
			tx.begin();

			Query q = manager
					.createNativeQuery("EXEC USP_REGISTRAR_LLAMADA_FALSA ?,?,?,?,?,?,?,?,?,?,?,?,?")
					.setParameter(1, emergencia.getLlamada().getCivil().getCivDocumento())
					.setParameter(2, emergencia.getLlamada().getCivil().getCivNombre())
					.setParameter(3, emergencia.getLlamada().getCivil().getCivApellidoPaterno())
					.setParameter(4, emergencia.getLlamada().getCivil().getCivApellidoMaterno())
					.setParameter(5, emergencia.getLlamada().getCivil().getCivTelefono())
					.setParameter(6, emergencia.getLlamada().getCivil().getFechaRegistro())
					.setParameter(7, emergencia.getLlamada().getLlaFecha())
					.setParameter(8, emergencia.getLlamada().getLlaObservacion())
					.setParameter(9, emergencia.getLlamada().getLlaTelefono())
					.setParameter(10, emergencia.getLlamada().getTipoTerminal().getTteId())
					.setParameter(11, emergencia.getLlamada().getOperador().getOpeId())
					.setParameter(12, emergencia.getLlamada().getLlaHoraInicio())
					.setParameter(13, emergencia.getLlamada().getLlaHoraFin());
			
			q.executeUpdate();

			tx.commit();

<<<<<<< HEAD
	public String registrarParte() {
		FacesContext context = FacesContext.getCurrentInstance();
		@SuppressWarnings("rawtypes")
		Map params = context.getExternalContext().getSessionMap();
		EquipoEmergencia equipoEmergencia1 = (EquipoEmergencia) params.get("equipoLogin");

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringData");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();

		try {
			tx.begin();

			Query q = manager.createNativeQuery("EXEC sp_registrarParte ?,?,?,?")
					.setParameter(1, equipoEmergencia1.getEmergencia().getEmeId())
					.setParameter(2, estadoParte.getEpaId())
					.setParameter(3, equipoEmergencia1.getRecurso().getRecId())
					.setParameter(4, parte.getParObservacion());

			q.executeUpdate();

			tx.commit();

			equipoEmergencia = new EquipoEmergencia();
			estadoParte = new EstadoParte();
			parte = new Parte();
=======
			emergencia = new Emergencia();
>>>>>>> origin/master

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
<<<<<<< HEAD

		return "ultimaEmergencia";
	}

	public String obtenerUltimaEmergencia() {

		FacesContext context = FacesContext.getCurrentInstance();
		@SuppressWarnings("rawtypes")
		Map params = context.getExternalContext().getSessionMap();
		EquipoEmergencia equipoEmergencia1 = (EquipoEmergencia) params.get("equipoLogin");

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringData");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();

		try {
			tx.begin();

			Query q = manager.createNativeQuery("sp_obtenerUltimaEmergencia ?").setParameter(1,
					equipoEmergencia1.getRecurso().getRecId());
			int cant = q.getResultList().size();

			if (cant > 0) {
				int unaemergencia = (int) q.getResultList().get(0);
				equipoEmergencia = equipoEmergenciaService.getEquipoEmergenciaRepository().obtenerEquipoEmergenciaId(unaemergencia);
				return "ultimaEmergencia2?faces-redirect=true";
			} else {
				addMessageInfo("Confirmación","USTED NO TIENE EMERGENCIAS ASIGNADAS");
				return "ultimaEmergencia3?faces-redirect=true";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ultimaEmergencia2?faces-redirect=true";
	}
	
	public void addMessageInfo(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	public void addMessageError(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

=======
		return "registroLlamada";
	}
	
>>>>>>> origin/master
}
