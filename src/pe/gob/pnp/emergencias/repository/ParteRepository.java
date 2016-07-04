package pe.gob.pnp.emergencias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.gob.pnp.emergencias.model.Parte;

@Repository
public interface ParteRepository extends CrudRepository<Parte, Long>{
	
	@Query("select p from Parte p where p.estadoParte.epaId = ?1")
	public List<Parte> partesExitosas(Long codigoEstado);
		
}
