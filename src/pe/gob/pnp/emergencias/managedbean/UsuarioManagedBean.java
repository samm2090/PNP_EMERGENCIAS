package pe.gob.pnp.emergencias.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.sql.DataSource;

import pe.gob.pnp.emergencias.model.Usuario;
import pe.gob.pnp.emergencias.service.UsuarioService;

@ManagedBean
@SessionScoped
public class UsuarioManagedBean {

	@ManagedProperty(value = "#{usuarioService}")
	private UsuarioService usuarioService;
	
	private DataSource dataSource;

	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private Usuario usuario = new Usuario();
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Usuario> getUsuarios() {
//		Iterable<Usuario> it = usuarioService.getUsuarioRepository().findAll();
//		Iterator<Usuario> iterator = it.iterator();
//		
//		usuarios.clear();
//		
//		while(iterator.hasNext()){
//			usuarios.add(iterator.next());
//		}
//		
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public String ingresar() {
			
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringData");
//		EntityManager manager = factory.createEntityManager();
//		EntityTransaction tx = manager.getTransaction();
//		
//		Query q = manager.createNativeQuery("insert into CIVIL(CIV_NOMBRE,CIV_DOCUMENTO) values (?,?);")
//				.setParameter(1, "Prueba3").setParameter(2, "666666");
//		
//		tx.begin();
//		q.executeUpdate();
//		tx.commit();
//		
		return "operador/registroLlamada";

	}

	public String cerrarSesion() {

		return "login";

	}

}
