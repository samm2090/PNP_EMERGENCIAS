package pe.gob.pnp.emergencias.managedbean;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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

import pe.gob.pnp.emergencias.model.Persona;
import pe.gob.pnp.emergencias.model.Recurso;
import pe.gob.pnp.emergencias.service.RecursoService;

@ManagedBean
@SessionScoped
public class RecursoManagedBean {
	@ManagedProperty(value = "#{recursoService}")
	private RecursoService recursoService;
	
	private Recurso recurso = new Recurso();
	private List<Recurso> recursos = new ArrayList<Recurso>();
	
	
	
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

	public RecursoService getRecursoService() {
		return recursoService;
	}

	public void setRecursoService(RecursoService recursoService) {
		this.recursoService = recursoService;
	}
	
	public String eliminar()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		Map params = context.getExternalContext().getRequestParameterMap();
		String id = (String) params.get("recursoID");
				
		recurso = recursoService
				.getRecursoRepository()
				.findOne(new Long(id));
		
		context.addMessage(null, new FacesMessage("Success",
				"Se elimino correctamente el empleado " + recurso.getPersona().getPerNombre()+" "+recurso.getPersona().getPerApellidoPaterno()));
		
		recursoService.getRecursoRepository().delete(new Long(id));
		recurso = new Recurso();
	
		
		return "mantenimientoRecurso";
	}
	
	public String editar()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		Map params = context.getExternalContext().getRequestParameterMap();
		String id = (String) params.get("recursoID");
				
		recurso = recursoService
				.getRecursoRepository()
				.findOne(new Long(id));
		
		return "mantenimientoRecurso";
	}
	
	public String registrar()
	{
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
					.setParameter(11, recurso.getPersona().getPerDni())
					.setParameter(12, "123456")
					.setParameter(13, recurso.getPersona().getUsuId().getRol().getRolId())
					.setParameter(14, recurso.getGradoRecurso().getGreId())
					.setParameter(15, recurso.getTurno().getTurId())
					.setParameter(16, recurso.getComisaria().getComId());

			int resultado = q.executeUpdate();
			tx.commit();
			
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Success",
					"Se guardó correctamente el empleado " + recurso.getPersona().getPerNombre()+" "+recurso.getPersona().getPerApellidoPaterno()));
			
			recurso = new Recurso();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		return "/paginas/administrador/mantenimientoRecurso";
	}
	
	public String guardarEditar()
	{
		recursoService.getRecursoRepository().save(recurso);
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Success",
				"Se actualizo correctamente el empleado " + recurso.getPersona().getPerNombre()+" "+recurso.getPersona().getPerApellidoPaterno()));
		
		recurso = new Recurso();
		
		return "/paginas/administrador/mantenimientoRecurso";
	}
	
	public String irPaginaRecurso()
	{
		return "mantenimientoRecurso";
	}
}
