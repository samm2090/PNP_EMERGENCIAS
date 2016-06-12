package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ROL database table.
 * 
 */
@Entity
@Table(name="ROL")
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ROL_ID")
	private int rolId;

	@Column(name="ESTADO_REGISTRO")
	private boolean estadoRegistro;

	@Column(name="ROL_DESCRIPCION")
	private String rolDescripcion;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="rol", fetch=FetchType.EAGER)
	private List<Usuario> usuarios;

	public Rol() {
	}

	public int getRolId() {
		return this.rolId;
	}

	public void setRolId(int rolId) {
		this.rolId = rolId;
	}

	public boolean getEstadoRegistro() {
		return this.estadoRegistro;
	}

	public void setEstadoRegistro(boolean estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public String getRolDescripcion() {
		return this.rolDescripcion;
	}

	public void setRolDescripcion(String rolDescripcion) {
		this.rolDescripcion = rolDescripcion;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setRol(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setRol(null);

		return usuario;
	}

}