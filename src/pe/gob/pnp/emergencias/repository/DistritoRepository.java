package pe.gob.pnp.emergencias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.gob.pnp.emergencias.model.Distrito;

@Repository
public interface DistritoRepository extends CrudRepository<Distrito, Long> {
	
	@Query("select dis from Distrito dis where dis.provincia.proId = ?1")
	List<Distrito> distritosLima(Long codigo);
	
}

