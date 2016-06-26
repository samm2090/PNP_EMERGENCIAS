package pe.gob.pnp.emergencias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import pe.gob.pnp.emergencias.model.Recurso;

@Repository
public interface RecursoRepository extends CrudRepository<Recurso, Long>{
	

	
}
