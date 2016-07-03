package pe.gob.pnp.emergencias.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.gob.pnp.emergencias.model.Llamada;
import pe.gob.pnp.emergencias.model.Usuario;

@Repository
public interface LlamadaRepository extends CrudRepository<Llamada, Long>{
	
	@Query("select l from Llamada l where l.llaEstado = :estado")
	public ArrayList<Llamada> llamadasEstado(@Param("estado") boolean estado);
	
}
