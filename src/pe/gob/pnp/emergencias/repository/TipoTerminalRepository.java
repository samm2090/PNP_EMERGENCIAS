package pe.gob.pnp.emergencias.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.gob.pnp.emergencias.model.TipoTerminal;

@Repository
public interface TipoTerminalRepository extends CrudRepository<TipoTerminal, Long>{

}
