package pe.gob.pnp.emergencias.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.gob.pnp.emergencias.model.TipoPersonal;

@Repository
public interface TipoPersonalRepository extends CrudRepository<TipoPersonal, Long>{

}
