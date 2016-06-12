package pe.gob.pnp.emergencias.managedbean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pe.gob.pnp.emergencias.model.GradoRecurso;
import pe.gob.pnp.emergencias.service.GradoRecursoService;

@ManagedBean
@SessionScoped
public class GradoRecursoManagedBean {

	@ManagedProperty(value="#{gradoRecursoService}")
	private GradoRecursoService gradoRecursoService;
	
	private List<GradoRecurso> gradoRecursos = new ArrayList<GradoRecurso>();
	
	private GradoRecurso gradoRecurso = new GradoRecurso();

	public GradoRecursoService getGradoRecursoService() {
		return gradoRecursoService;
	}

	public void setGradoRecursoService(GradoRecursoService gradoRecursoService) {
		this.gradoRecursoService = gradoRecursoService;
	}

	public List<GradoRecurso> getGradoRecursos() {
		Iterable<GradoRecurso> it = gradoRecursoService.getGradoRecursoRepository().findAll();
		Iterator<GradoRecurso> iterator = it.iterator();
		
		gradoRecursos.clear();
		
		while(iterator.hasNext()){
			gradoRecursos.add(iterator.next());
		}
		
		return gradoRecursos;
	}

	public void setGradoRecursos(List<GradoRecurso> gradoRecursos) {
		this.gradoRecursos = gradoRecursos;
	}

	public GradoRecurso getGradoRecurso() {
		return gradoRecurso;
	}

	public void setGradoRecurso(GradoRecurso gradoRecurso) {
		this.gradoRecurso = gradoRecurso;
	}

}
