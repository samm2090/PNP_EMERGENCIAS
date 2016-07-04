package pe.gob.pnp.emergencias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.gob.pnp.emergencias.model.Operador;

@Repository
public interface OperadorRepository extends CrudRepository<Operador, Long>{
	
	@Query("select o from Operador o where o.persona.perId = ?1")
	List<Operador> operadorXPersona(Long codigo);

}
