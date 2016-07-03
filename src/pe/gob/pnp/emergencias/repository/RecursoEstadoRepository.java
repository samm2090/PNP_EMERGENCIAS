package pe.gob.pnp.emergencias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.gob.pnp.emergencias.model.RecursoEstado;

@Repository
public interface RecursoEstadoRepository extends CrudRepository<RecursoEstado, Long>{
	
	@Query("select re from RecursoEstado re where re.estado.estId = ?1")
	List<RecursoEstado> recursosDisponibles(Long estado);

}
