package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ROL")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ROL_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long rolId;

	@Column(name = "ESTADO_REGISTRO")
	private boolean estadoRegistro;

	@Column(name = "ROL_DESCRIPCION")
	private String rolDescripcion;

	// bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy = "rol", cascade = CascadeType.PERSIST)
	private List<Usuario> usuarios = new ArrayList<Usuario>();

	public Rol() {
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