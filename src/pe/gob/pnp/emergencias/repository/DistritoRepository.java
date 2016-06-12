package pe.gob.pnp.emergencias.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.gob.pnp.emergencias.model.Distrito;

@Repository
public interface DistritoRepository extends CrudRepository<Distrito, Long>{

}
