package pe.gob.pnp.emergencias.repository;

<<<<<<< HEAD
=======

>>>>>>> 4131abf4a499388f57a7b7f20d162a68ca7c5a98
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.gob.pnp.emergencias.model.Emergencia;


@Repository
public interface EmergenciaRepository extends CrudRepository<Emergencia, Long>{
	
	@Query("SELECT e FROM Emergencia e "
			+ "ORDER BY e.emeId desc")
	public List<Emergencia> ultimaEmergenciaInsertada();

	@Query("select e from Emergencia e order by e.distrito.disId DESC")
	public List<Emergencia> emergenciaOrdenadaxDistrito();
	
}
