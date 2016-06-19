package pe.gob.pnp.emergencias.managedbean;

import java.util.ArrayList;
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
	
	private GradoRecurso gradoRecurso = new GradoRecurso();
	private List<GradoRecurso> gradoRecursos = new ArrayList<GradoRecurso>();
	private List<GradoRecurso> gradoRecursosxId = new ArrayList<GradoRecurso>();
	

	public GradoRecursoService getGradoRecursoService() {
		return gradoRecursoService;
	}

	public void setGradoRecursoService(GradoRecursoService gradoRecursoService) {
		this.gradoRecursoService = gradoRecursoService;
	}

	public List<GradoRecurso> getGradoRecursosxId() {
		/*EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringData");
		EntityManager manager = factory.createEntityManager();
		
		StoredProcedureQuery q = manager.createNamedStoredProcedureQuery("sp_test");
		boolean result=  q.execute();
		
		gradoRecursosxId = q.getResultList();*/
		
		return gradoRecursosxId;
	}

	public void setGradoRecursosxId(List<GradoRecurso> gradoRecursosxId) {
		this.gradoRecursosxId = gradoRecursosxId;
	}

	public List<GradoRecurso> getGradoRecursos() {
//		Iterable<GradoRecurso> it = gradoRecursoService.getGradoRecursoRepository().findAll();
//		Iterator<GradoRecurso> iterator = it.iterator();
//		
//		gradoRecursos.clear();
//		
//		while(iterator.hasNext()){
//			gradoRecursos.add(iterator.next());
//		}
//		
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
