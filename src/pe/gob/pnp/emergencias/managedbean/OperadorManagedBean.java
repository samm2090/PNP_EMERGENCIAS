package pe.gob.pnp.emergencias.managedbean;

import java.util.ArrayList;
import java.util.Iterator;
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

import pe.gob.pnp.emergencias.model.Operador;
import pe.gob.pnp.emergencias.service.OperadorService;

@ManagedBean
@SessionScoped
public class OperadorManagedBean {
	
	@ManagedProperty(value = "#{operadorService}")
	private OperadorService operadorService;
	
	private Operador operador = new Operador();
	private List<Operador> operadores = new ArrayList<Operador>();
	
	public OperadorService getOperadorService() {
		return operadorService;
	}

	public void setOperadorService(OperadorService operadorService) {
		this.operadorService = operadorService;
	}
		
	public Operador getOperador() {
		return operador;
	}

	public void setOperador(Operador operador) {
		this.operador = operador;
	}

	public List<Operador> getOperadores() {
		
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringData");
//		EntityManager manager = factory.createEntityManager();
//		
//		manager.
		
		
		Iterable<Operador> it = operadorService.getOperadorRepository().findAll2();
		Iterator<Operador> iterator = it.iterator();
	
		operadores.clear();
		
		while(iterator.hasNext()){
			operadores.add(iterator.next());
		}
		
		return operadores;
	}

	public void setOperadores(List<Operador> operadores) {
		this.operadores = operadores;
	}

	public String registrar()
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringData");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();

		try {
			tx.begin();

			Query q = manager.createNativeQuery("sp_registrarOperador ?,?,?,?,?,?,?,?,?,?,?,?,?,?")
					.setParameter(1, operador.getPersona().getPerNombre())
					.setParameter(2, operador.getPersona().getPerApellidoPaterno())
					.setParameter(3, operador.getPersona().getPerApellidoMaterno())
					.setParameter(4, operador.getPersona().getPerFechaNacimiento())
					.setParameter(5, operador.getPersona().getPerDni())
					.setParameter(6, operador.getPersona().getPerDireccion())
					.setParameter(7, operador.getPersona().getPerCorreo())
					.setParameter(8, operador.getPersona().getPerTelefono())
					.setParameter(9, operador.getPersona().getPerGenero())
					.setParameter(10, operador.getPersona().getPerEstadoCivil())
					.setParameter(11, operador.getPersona().getPerDni())
					.setParameter(12, "123456")
					.setParameter(13, operador.getPersona().getUsuId().getRol().getRolId())
					.setParameter(14, operador.getTurno().getTurId());

			int resultado = q.executeUpdate();
			tx.commit();
			manager.clear();
			manager.close();
			factory.close();
			
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Success",
					"Se guard� correctamente el empleado " + operador.getPersona().getPerNombre()+" "+operador.getPersona().getPerApellidoPaterno()));
			
			operador = new Operador();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
		return "mantenimientoOperador";
	}
	
	public String guardarEditar()
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringData");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();

		try {
			tx.begin();

			Query q = manager.createNativeQuery("sp_editarOperador ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?")
					.setParameter(1, operador.getOpeId())
					.setParameter(2, operador.getPersona().getPerId())
					.setParameter(3, operador.getPersona().getUsuId().getUsuId())
					.setParameter(4, operador.getPersona().getPerNombre())
					.setParameter(5, operador.getPersona().getPerApellidoPaterno())
					.setParameter(6, operador.getPersona().getPerApellidoMaterno())
					.setParameter(7, operador.getPersona().getPerFechaNacimiento())
					.setParameter(8, operador.getPersona().getPerDireccion())
					.setParameter(9, operador.getPersona().getPerCorreo())
					.setParameter(10, operador.getPersona().getPerTelefono())
					.setParameter(11, operador.getPersona().getPerGenero())
					.setParameter(12, operador.getPersona().getPerEstadoCivil())
					.setParameter(13, operador.getPersona().getUsuId().getUsuClave())
					.setParameter(14, operador.getPersona().getUsuId().getRol().getRolId())
					.setParameter(15, operador.getTurno().getTurId());

			int resultado = q.executeUpdate();
			tx.commit();
			
			//manager.flush();
			manager.clear();
			manager.close();
			factory.close();
			
			FacesContext context = FacesContext.getCurrentInstance();
			if(resultado == 0)
			{
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Success",
						"No se pudo actualizar operador"));
			}
			else
			{
			
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Success",
					"Se actualizo correctamente el operador " + operador.getPersona().getPerNombre()+" "+operador.getPersona().getPerApellidoPaterno()));
			}
			
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		//manager.clear();
				
		operador = new Operador();
		
		return "mantenimientoOperador?faces-redirect=true";
	}
	
	public String editar()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		Map params = context.getExternalContext().getRequestParameterMap();
		String id = (String) params.get("operadorID");
				
		operador = operadorService
				.getOperadorRepository()
				.findOne(new Long(id));
		
		return "editarOperador";
	}
	
	public String eliminar()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		Map params = context.getExternalContext().getRequestParameterMap();
		String id = (String) params.get("operadorID");
				
		operador = operadorService
				.getOperadorRepository()
				.findOne(new Long(id));
		
		context.addMessage(null, new FacesMessage("Success",
				"Se elimino correctamente el operador " + operador.getPersona().getPerNombre()+" "+operador.getPersona().getPerApellidoPaterno()));
		
		operadorService.getOperadorRepository().delete(new Long(id));
		operador = new Operador();
	
		
		return "mantenimientoOperador";
	}
	
	public String irPaginaOperador()
	{
		return "mantenimientoOperador?faces-redirect=true";
	}
	
	public String irPaginaInicio()
	{
		return "paginas/operador/inicio";
	}
}
