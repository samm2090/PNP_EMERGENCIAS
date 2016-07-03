package pe.gob.pnp.emergencias.managedbean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import org.primefaces.context.RequestContext;

import pe.gob.pnp.emergencias.model.Persona;
import pe.gob.pnp.emergencias.model.Recurso;
import pe.gob.pnp.emergencias.model.RecursoEstado;
import pe.gob.pnp.emergencias.service.PersonaService;
import pe.gob.pnp.emergencias.service.RecursoEstadoService;
import pe.gob.pnp.emergencias.service.RecursoService;

@ManagedBean
@SessionScoped
public class RecursoManagedBean {
	@ManagedProperty(value = "#{recursoService}")
	private RecursoService recursoService;

	@ManagedProperty(value = "#{personaService}")
	private PersonaService personaService;

	@ManagedProperty(value = "#{recursoEstadoService}")
	private RecursoEstadoService recursoEstadoService;

	private Recurso recurso = new Recurso();

	private List<Recurso> recursos = new ArrayList<Recurso>();

	private Persona persona = new Persona();

	private List<RecursoEstado> recursoEstados = new ArrayList<RecursoEstado>();

	public RecursoService getRecursoService() {
		return recursoService;
	}

	public void setRecursoService(RecursoService recursoService) {
		this.recursoService = recursoService;
	}

	public PersonaService getPersonaService() {
		return personaService;
	}

	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

	public List<Recurso> getRecursos() {
		recursos = (List<Recurso>) recursoService.getRecursoRepository().findAll();
		return recursos;
	}

	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public RecursoEstadoService getRecursoEstadoService() {
		return recursoEstadoService;
	}

	public void setRecursoEstadoService(RecursoEstadoService recursoEstadoService) {
		this.recursoEstadoService = recursoEstadoService;
	}

	public List<RecursoEstado> getRecursoEstados() {
		return recursoEstados;
	}

	public void setRecursoEstados(List<RecursoEstado> recursoEstados) {
		this.recursoEstados = recursoEstados;
	}

	public String registrarAsistencia() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringData");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();

		try {
			tx.begin();

			Query q = manager.createNativeQuery("sp_ingresoRecursoPorDia ?").setParameter(1, persona.getPerDni());
			int resultado = q.executeUpdate();

			tx.commit();

			if (resultado > 0) {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Confirmación",
						"El ingreso fue satisfactorio");
				FacesContext.getCurrentInstance().addMessage(null, message);
			} else {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
						"El recurso ingresado es incorrecto o pertenece a otro turno");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}

			persona = new Persona();
			manager.close();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		return "controlAsistenciaRecurso";
	}

	public String eliminar() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map params = context.getExternalContext().getRequestParameterMap();
		String id = (String) params.get("recursoID");

		recurso = recursoService.getRecursoRepository().findOne(new Long(id));

		context.addMessage(null, new FacesMessage("Success", "Se elimino correctamente el empleado "
				+ recurso.getPersona().getPerNombre() + " " + recurso.getPersona().getPerApellidoPaterno()));

		recursoService.getRecursoRepository().delete(new Long(id));
		recurso = new Recurso();

		return "mantenimientoRecurso";
	}

	public String editar() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map params = context.getExternalContext().getRequestParameterMap();
		String id = (String) params.get("recursoID");

		recurso = recursoService.getRecursoRepository().findOne(new Long(id));

		return "editarRecurso";
	}

	public String registrar() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringData");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();

		try {
			tx.begin();
			Query q = manager.createNativeQuery("sp_registrarRecurso ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?")
					.setParameter(1, recurso.getPersona().getPerNombre())
					.setParameter(2, recurso.getPersona().getPerApellidoPaterno())
					.setParameter(3, recurso.getPersona().getPerApellidoMaterno())
					.setParameter(4, recurso.getPersona().getPerFechaNacimiento())
					.setParameter(5, recurso.getPersona().getPerDni())
					.setParameter(6, recurso.getPersona().getPerDireccion())
					.setParameter(7, recurso.getPersona().getPerCorreo())
					.setParameter(8, recurso.getPersona().getPerTelefono())
					.setParameter(9, recurso.getPersona().getPerGenero())
					.setParameter(10, recurso.getPersona().getPerEstadoCivil())
					.setParameter(11, recurso.getPersona().getPerDni()).setParameter(12, "123456")
					.setParameter(13, recurso.getPersona().getUsuId().getRol().getRolId())
					.setParameter(14, recurso.getGradoRecurso().getGreId())
					.setParameter(15, recurso.getTurno().getTurId())
					.setParameter(16, recurso.getComisaria().getComId());

			int resultado = q.executeUpdate();
			tx.commit();

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Success", "Se guardó correctamente el empleado "
					+ recurso.getPersona().getPerNombre() + " " + recurso.getPersona().getPerApellidoPaterno()));

			recurso = new Recurso();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return "/paginas/administrador/mantenimientoRecurso";
	}

	public String guardarEditar() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringData");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();

		try {
			tx.begin();
			Query q = manager.createNativeQuery("sp_editarRecurso ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?")
					.setParameter(1, recurso.getRecId()).setParameter(2, recurso.getPersona().getPerId())
					.setParameter(3, recurso.getPersona().getUsuId().getUsuId())
					.setParameter(4, recurso.getPersona().getPerNombre())
					.setParameter(5, recurso.getPersona().getPerApellidoPaterno())
					.setParameter(6, recurso.getPersona().getPerApellidoMaterno())
					.setParameter(7, recurso.getPersona().getPerFechaNacimiento())
					.setParameter(8, recurso.getPersona().getPerDireccion())
					.setParameter(9, recurso.getPersona().getPerCorreo())
					.setParameter(10, recurso.getPersona().getPerTelefono())
					.setParameter(11, recurso.getPersona().getPerGenero())
					.setParameter(12, recurso.getPersona().getPerEstadoCivil())
					.setParameter(13, recurso.getPersona().getUsuId().getUsuNombre())
					.setParameter(14, recurso.getPersona().getUsuId().getUsuClave())
					.setParameter(15, recurso.getPersona().getUsuId().getRol().getRolId())
					.setParameter(16, recurso.getGradoRecurso().getGreId())
					.setParameter(17, recurso.getTurno().getTurId())
					.setParameter(18, recurso.getComisaria().getComId());

			int resultado = q.executeUpdate();
			tx.commit();

			recurso = new Recurso();

			FacesContext context = FacesContext.getCurrentInstance();
			if (resultado == 0) {
				context.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Success", "No se pudo registrar el recurso"));
			} else {
				context.addMessage(null, new FacesMessage("Success", "Se guardï¿½ correctamente el recurso "
						+ recurso.getPersona().getPerNombre() + " " + recurso.getPersona().getPerApellidoPaterno()));
			}
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		return "mantenimientoRecurso";
	}

	public String irPaginaRecurso() {
		return "mantenimientoRecurso?faces-redirect=true";
	}

	public void viewRecursos() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("modal", true);
		options.put("width", 640);
		options.put("height", 340);
		options.put("contentWidth", "100%");
		options.put("contentHeight", "100%");
		options.put("headerElement", "customheader");
		RequestContext.getCurrentInstance().openDialog("verRecursos", options, null);
	}

}
