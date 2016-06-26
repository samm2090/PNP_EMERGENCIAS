package pe.gob.pnp.emergencias.managedbean;

import java.util.ArrayList;
import java.util.List;

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

	private Persona persona = new Persona();

	private Recurso recurso = new Recurso();

	private List<Recurso> recursos = new ArrayList<Recurso>();

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

	public List<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
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

			Query q = manager.createNativeQuery("sp_ingresoRecursoPorDia ?")
						.setParameter(1, persona.getPerDni());
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
}
