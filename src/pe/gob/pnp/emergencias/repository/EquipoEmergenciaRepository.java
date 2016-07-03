package pe.gob.pnp.emergencias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.gob.pnp.emergencias.model.EquipoEmergencia;

@Repository
public interface EquipoEmergenciaRepository extends CrudRepository<EquipoEmergencia, Long> {
	
	@Query("select ee from EquipoEmergencia ee where ee.emergencia.emeId = ?1")
	public List<EquipoEmergencia> equipoXEmergencia(Long emeId);

	@Query(" SELECT em FROM EquipoEmergencia em "
			+ "INNER JOIN em.recurso re "
			+ "INNER JOIN re.persona pe "
			+ "INNER JOIN pe.usuId usu "
		+ " WHERE usu.usuNombre like :usuario and "
			  + "usu.usuClave like :contrasena ")
	public EquipoEmergencia obtenerEquipoEmergenciaLogged(@Param("usuario") String usuario, @Param("contrasena") String contrasena);
	
	@Query(" SELECT em FROM EquipoEmergencia em "
			+ " WHERE em.recurso.recId =:recurso "
			+ " ORDER BY em.eemId desc")
	public EquipoEmergencia obtenerEquipoEmergenciaId(@Param("recurso") int recurso);
	
	
}
