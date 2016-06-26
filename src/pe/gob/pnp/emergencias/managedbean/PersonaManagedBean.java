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

import com.google.common.collect.Lists;

import pe.gob.pnp.emergencias.model.Persona;
import pe.gob.pnp.emergencias.model.Recurso;
import pe.gob.pnp.emergencias.model.Rol;
import pe.gob.pnp.emergencias.model.TipoPersonal;
import pe.gob.pnp.emergencias.model.Usuario;
import pe.gob.pnp.emergencias.service.PersonaService;
import pe.gob.pnp.emergencias.service.RolService;
import pe.gob.pnp.emergencias.service.TipoPersonalService;
import pe.gob.pnp.emergencias.service.UsuarioService;

@ManagedBean
@SessionScoped
public class PersonaManagedBean {

	@ManagedProperty(value = "#{personaService}")
	private PersonaService personaService;

	private List<Persona> personas = new ArrayList<Persona>();

	private Persona persona = new Persona();
	private Recurso recurso = new Recurso();

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

	public PersonaService getPersonaService() {
		return personaService;
	}

	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
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

			int resultado = q.executeUpdate();
			tx.commit();
			
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Success",
					"Se guardó correctamente el empleado " + persona.getPerNombre()+" "+persona.getPerApellidoPaterno()));
			
			persona = new Persona();
			recurso = new Recurso();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		return "/paginas/administrador/mantenimientoRecurso";
	}

}
