package pe.gob.pnp.emergencias.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.gob.pnp.emergencias.model.Recurso;

@Repository
public interface RecursoRepository extends CrudRepository<Recurso, Long> {
<<<<<<< HEAD
	
	@Query(" SELECT re FROM Recurso re "
			+ "INNER JOIN re.persona pe "
			+ "INNER JOIN pe.usuId usu "
		+ "WHERE usu.usuNombre like :usuario and "
			  + "usu.usuClave like :contrasena ")
	public Recurso obtenerRecursoLogged(@Param("usuario") String usuario, @Param("contrasena") String contrasena);
=======
>>>>>>> origin/master

}
