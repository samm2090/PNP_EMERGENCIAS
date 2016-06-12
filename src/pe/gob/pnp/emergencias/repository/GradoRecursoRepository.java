package pe.gob.pnp.emergencias.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.gob.pnp.emergencias.model.GradoRecurso;

@Repository
public interface GradoRecursoRepository extends CrudRepository<GradoRecurso, Long>{

}
