package pe.gob.pnp.emergencias.managedbean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

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
	
	

}
