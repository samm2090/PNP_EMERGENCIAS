package pe.gob.pnp.emergencias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.gob.pnp.emergencias.model.EquipoEmergencia;

@Repository
public interface EquipoEmergenciaRepository extends CrudRepository<EquipoEmergencia, Long> {
	
	@Query("select ee from EquipoEmergencia ee where ee.emergencia.emeId = ?1")
	List<EquipoEmergencia> equipoXEmergencia(Long emeId);

}
