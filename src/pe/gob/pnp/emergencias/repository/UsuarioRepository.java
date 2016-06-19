package pe.gob.pnp.emergencias.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.gob.pnp.emergencias.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	// public Usuario findByUsuarioAndClave(String nombre, String clave);

	@Query("select c from Usuario c" + " where c.usuNombre like :usuario and c.usuClave like :contrasena")
	public Usuario obtenerUsuarioLogged(@Param("usuario") String usuario, @Param("contrasena") String contrasena);

}
