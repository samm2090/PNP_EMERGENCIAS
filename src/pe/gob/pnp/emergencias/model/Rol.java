package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the ROL database table.
 * 
 */
@Entity
@Table(name = "ROL")
@NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROL_ID")
	private Long rolId;

	@Column(name = "ESTADO_REGISTRO")
	private boolean estadoRegistro;

	@Column(name = "ROL_DESCRIPCION")
	private String rolDescripcion;

	// bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy = "rol", fetch = FetchType.EAGER)
	private List<Usuario> usuarios;

	public Rol() {
	}
	
	
	
	public Rol(String rolDescripcion,boolean estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
		this.rolDescripcion = rolDescripcion;
	}



	public Long getRolId() {
		return rolId;
	}

	public void setRolId(Long rolId) {
		this.rolId = rolId;
	}

	public boolean isEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(boolean estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public String getRolDescripcion() {
		return rolDescripcion;
	}

	public void setRolDescripcion(String rolDescripcion) {
		this.rolDescripcion = rolDescripcion;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}