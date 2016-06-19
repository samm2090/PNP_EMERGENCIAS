package pe.gob.pnp.emergencias.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.gob.pnp.emergencias.model.Civil;

@Repository
public interface CivilRepository extends CrudRepository<Civil, Long> {


}
