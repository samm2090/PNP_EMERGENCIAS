package pe.gob.pnp.emergencias.managedbean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import pe.gob.pnp.emergencias.model.Usuario;
import pe.gob.pnp.emergencias.service.UsuarioService;

@ManagedBean
@SessionScoped
public class UsuarioManagedBean {

	@ManagedProperty(value = "#{usuarioService}")
	private UsuarioService usuarioService;

	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private Usuario userAutentic = new Usuario();

	public List<Usuario> getUsuarios() {
		// Iterable<Usuario> it =
		// usuarioService.getUsuarioRepository().findAll();
		// Iterator<Usuario> iterator = it.iterator();
		//
		// usuarios.clear();
		//
		// while(iterator.hasNext()){
		// usuarios.add(iterator.next());
		// }
		//
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUserAutentic() {
		return userAutentic;
	}

	public void setUserAutentic(Usuario userAutentic) {
		this.userAutentic = userAutentic;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public String autenticar() {
		userAutentic = usuarioService.getUsuarioRepository().obtenerUsuarioLogged(userAutentic.getUsuNombre(),
				userAutentic.getUsuClave());
		if (userAutentic != null) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ingreso",
					"Usuario autenticado correctamente");

			FacesContext.getCurrentInstance().addMessage(null, message);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", userAutentic);
			
			return "operador/registroLlamada?faces-redirect=true";
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
					"El usuario no existe o la contrasena no coincide con nuestra base de datos");
			FacesContext.getCurrentInstance().addMessage(null, message);
			userAutentic = new Usuario();
			System.out.println("no ingreso");
			return "";
		}
	}

	public void cerrarSesion() {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		try {
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			ec.redirect(ec.getRequestContextPath() + "/paginas/login.xhtml");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
