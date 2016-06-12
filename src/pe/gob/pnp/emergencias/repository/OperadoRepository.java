package pe.gob.pnp.emergencias.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.gob.pnp.emergencias.model.Operador;

@Repository
public interface OperadoRepository extends CrudRepository<Operador, Long>{

}
