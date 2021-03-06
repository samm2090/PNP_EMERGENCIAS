package pe.gob.pnp.emergencias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.gob.pnp.emergencias.model.Persona;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long> {
	
	@Query("select p from Persona p where p.usuId.usuId = ?1")
	List<Persona> personaXUsuario(Long codigo);

}
