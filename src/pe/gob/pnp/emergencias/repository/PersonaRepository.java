package pe.gob.pnp.emergencias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.gob.pnp.emergencias.model.Persona;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long>{
	
	@Query("SELECT p.perDni FROM Persona p where d.perDni = :perDni")
	Persona findByEmail(@Param("perDni") String perDni);
	
	@Query("SELECT p.perDni FROM Persona p where d.perDni = :perDni")
	public List<Persona> obtenerDepartamentoPorId(@Param("perDni") String perDni);


}
