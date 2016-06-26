package pe.gob.pnp.emergencias.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.gob.pnp.emergencias.model.Recurso;

@Repository
public interface RecursoRepository extends CrudRepository<Recurso, Long>{
	

	
}
