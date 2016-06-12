import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import pe.gob.pnp.emergencias.managedbean.GradoRecursoManagedBean;
import pe.gob.pnp.emergencias.model.GradoRecurso;

public class Test1 {

	@Test
	public void test() {
		GradoRecursoManagedBean grado = new GradoRecursoManagedBean();
		ArrayList<GradoRecurso> grados = (ArrayList<GradoRecurso>) grado.getGradoRecursos();
		assertNotNull(grados);
	}

}
