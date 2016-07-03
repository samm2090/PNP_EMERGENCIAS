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

import pe.gob.pnp.emergencias.model.Comisaria;
import pe.gob.pnp.emergencias.service.ComisariaService;

@ManagedBean
@SessionScoped
public class ComisariaManagedBean {
	
	@ManagedProperty(value = "#{comisariaService}")
	private ComisariaService comisariaService;
	
	private Comisaria comisaria = new Comisaria();
	private List<Comisaria> comisarias = new ArrayList<Comisaria>();

	public ComisariaService getComisariaService() {
		return comisariaService;
	}

	public void setComisariaService(ComisariaService comisariaService) {
		this.comisariaService = comisariaService;
	}

	public Comisaria getComisaria() {
		return comisaria;
	}

	public void setComisaria(Comisaria comisaria) {
		this.comisaria = comisaria;
	}

	public List<Comisaria> getComisarias() {
		Iterable<Comisaria> it = comisariaService.getComisariaRepository().findAll();
		Iterator<Comisaria> iterator = it.iterator();
	
		comisarias.clear();
		
		while(iterator.hasNext()){
			comisarias.add(iterator.next());
		}
		
		return comisarias;
	}

	public void setComisarias(List<Comisaria> comisarias) {
		this.comisarias = comisarias;
	}
	
	public String registrar()
	{
		Comisaria aux = comisariaService.getComisariaRepository().save(comisaria);
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		
		if(aux == null)
		{
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Success",
					"No se pudo registrar la comisaria"));
		}
		else
		{
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Success",
					"Se registro la comisaria "+ comisaria.getComNombre()+" exitosamente"));
		}
		
		
		return "mantenimientoComisaria";
	}
	
	public String editar()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		Map params = context.getExternalContext().getRequestParameterMap();
		String id = (String) params.get("comisariaID");
				
		comisaria = comisariaService
				.getComisariaRepository()
				.findOne(new Long(id));
		
		comisaria = new Comisaria();
		return "editarComisaria";
	}
	
	public String eliminar()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		Map params = context.getExternalContext().getRequestParameterMap();
		String id = (String) params.get("comisariaID");
				
		comisaria = comisariaService
				.getComisariaRepository()
				.findOne(new Long(id));
		
		comisariaService.getComisariaRepository().delete(comisaria);
		
		return "mantenimientoComisaria";
	}
	
	public String editarEditar()
	{
		Comisaria aux = comisariaService.getComisariaRepository().save(comisaria);
		
		FacesContext context = FacesContext.getCurrentInstance();
		if(aux==null)
		{
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Success",
					"No se pudo registrar la comisaria"));
		}
		else
		{
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Success",
					"Se actualizo correctamente la comisaria " + comisaria.getComNombre()));
		}
		
		return "mantenimientoComisaria";
	}
	
	public String irPaginaComisaria()
	{
		return "mantenimientoComisaria?faces-redirect=true";
	}
	
	
	

}
