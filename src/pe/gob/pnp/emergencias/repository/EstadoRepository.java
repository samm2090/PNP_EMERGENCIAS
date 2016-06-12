package pe.gob.pnp.emergencias.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.gob.pnp.emergencias.model.Estado;

@Repository
public interface EstadoRepository extends CrudRepository<Estado, Long>{

}
