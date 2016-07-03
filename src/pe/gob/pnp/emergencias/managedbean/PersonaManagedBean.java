package pe.gob.pnp.emergencias.managedbean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import pe.gob.pnp.emergencias.model.EquipoEmergencia;
import pe.gob.pnp.emergencias.model.Operador;
import pe.gob.pnp.emergencias.model.Persona;
import pe.gob.pnp.emergencias.model.Recurso;
import pe.gob.pnp.emergencias.model.Usuario;
import pe.gob.pnp.emergencias.service.EquipoEmergenciaService;
import pe.gob.pnp.emergencias.service.OperadorService;
import pe.gob.pnp.emergencias.service.PersonaService;
import pe.gob.pnp.emergencias.service.RecursoService;
import pe.gob.pnp.emergencias.service.UsuarioService;

@ManagedBean
@SessionScoped
public class PersonaManagedBean {

	@ManagedProperty(value = "#{personaService}")
	private PersonaService personaService;

	@ManagedProperty(value = "#{recursoService}")
	private RecursoService recursoService;

	@ManagedProperty(value = "#{operadorService}")
	private OperadorService operadorService;

	@ManagedProperty(value = "#{equipoEmergenciaService}")
	private EquipoEmergenciaService equipoEmergenciaService;

	@ManagedProperty(value = "#{usuarioService}")
	private UsuarioService usuarioService;

	private List<Persona> personas = new ArrayList<Persona>();
	private List<Recurso> recursos = new ArrayList<Recurso>();
	private List<Operador> operadores = new ArrayList<Operador>();
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private List<EquipoEmergencia> equipoEmergencias = new ArrayList<EquipoEmergencia>();

	private Persona persona = new Persona();
	private Recurso recurso = new Recurso();
	private Operador operador = new Operador();
	private Usuario usuario = new Usuario();
	private EquipoEmergencia equipoEmergencia = new EquipoEmergencia();

	public PersonaService getPersonaService() {
		return personaService;
	}

	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}

	public RecursoService getRecursoService() {
		return recursoService;
	}

	public void setRecursoService(RecursoService recursoService) {
		this.recursoService = recursoService;
	}

	public OperadorService getOperadorService() {
		return operadorService;
	}

	public void setOperadorService(OperadorService operadorService) {
		this.operadorService = operadorService;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public List<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}

	public List<Operador> getOperadores() {
		return operadores;
	}

	public void setOperadores(List<Operador> operadores) {
		this.operadores = operadores;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

	public Operador getOperador() {
		return operador;
	}

	public void setOperador(Operador operador) {
		this.operador = operador;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public EquipoEmergenciaService getEquipoEmergenciaService() {
		return equipoEmergenciaService;
	}

	public void setEquipoEmergenciaService(EquipoEmergenciaService equipoEmergenciaService) {
		this.equipoEmergenciaService = equipoEmergenciaService;
	}

	public List<EquipoEmergencia> getEquipoEmergencias() {
		return equipoEmergencias;
	}

	public void setEquipoEmergencias(List<EquipoEmergencia> equipoEmergencias) {
		this.equipoEmergencias = equipoEmergencias;
	}

	public EquipoEmergencia getEquipoEmergencia() {
		return equipoEmergencia;
	}

	public void setEquipoEmergencia(EquipoEmergencia equipoEmergencia) {
		this.equipoEmergencia = equipoEmergencia;
	}

	public String registrar() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringData");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();

		try {
			tx.begin();

			Query q = manager.createNativeQuery("sp_registrarRecurso ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?")
					.setParameter(1, persona.getPerNombre()).setParameter(2, persona.getPerApellidoPaterno())
					.setParameter(3, persona.getPerApellidoMaterno()).setParameter(4, persona.getPerFechaNacimiento())
					.setParameter(5, persona.getPerDni()).setParameter(6, persona.getPerDireccion())
					.setParameter(7, persona.getPerCorreo()).setParameter(8, persona.getPerTelefono())
					.setParameter(9, persona.getPerGenero()).setParameter(10, persona.getPerEstadoCivil())
					.setParameter(11, persona.getPerDni()).setParameter(12, "123456")
					.setParameter(13, persona.getUsuId().getRol().getRolId())
					.setParameter(14, recurso.getGradoRecurso().getGreId())
					.setParameter(15, recurso.getTurno().getTurId())
					.setParameter(16, recurso.getComisaria().getComId());

			@SuppressWarnings("unused")
			int resultado = q.executeUpdate();
			tx.commit();

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Success", "Se guardó correctamente el empleado "
					+ persona.getPerNombre() + " " + persona.getPerApellidoPaterno()));

			persona = new Persona();
			recurso = new Recurso();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		return "/paginas/administrador/mantenimientoRecurso";
	}

	public String autenticar() {

		usuario = usuarioService.getUsuarioRepository().obtenerUsuarioLogged(persona.getUsuId().getUsuNombre(),
				persona.getUsuId().getUsuClave());
		equipoEmergencia = equipoEmergenciaService.getEquipoEmergenciaRepository()
				.obtenerEquipoEmergenciaLogged(persona.getUsuId().getUsuNombre(), persona.getUsuId().getUsuClave());

		if (usuario != null || equipoEmergencia != null) {
			if (usuario.getRol().getRolId() == 1) {
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLogin", usuario);
				addMessageInfo("Confirmación: ", "Usuario autenticado correctamente");
				return "operador/registroLlamada?faces-redirect=true";
			} else {
				if (usuario.getRol().getRolId() == 2) {
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLogin", usuario);
					addMessageInfo("Confirmación: ", "Usuario autenticado correctamente");
					return "operador/registroLlamada?faces-redirect=true";
				} else if (usuario.getRol().getRolId() == 3) {
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLogin", usuario);
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("equipoLogin",
							equipoEmergencia);
					addMessageInfo("Confirmación: ", "Usuario autenticado correctamente");
					return "policia/ultimaEmergencia?faces-redirect=true";
				} else {
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLogin", usuario);
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("equipoLogin",
							equipoEmergencia);
					addMessageInfo("Confirmación: ", "Usuario autenticado correctamente");
					return "operador/registroLlamada?faces-redirect=true";
				}
			}
		} else {
			addMessageError("Error: ", "Usuario y/o contraseña ingresado son incorrectos");
			persona = new Persona();
			return "login";
		}
	}

	public void cerrarSesion() {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		try {
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			ec.redirect(ec.getRequestContextPath() + "/paginas/login.xhtml");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void addMessageInfo(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void addMessageError(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public String irPaginaInicioAdministrador()
	{
		return "/paginas/administrador/inicio";
	}
}
