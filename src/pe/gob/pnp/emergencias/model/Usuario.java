package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the USUARIO database table.
 * 
 */
@Entity
@Table(name="USUARIO")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USU_ID")
	private int usuId;

	@Column(name="ESTADO_REGISTRO")
	private boolean estadoRegistro;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	@Column(name="FECHA_MODIFICACION")
	private Timestamp fechaModificacion;

	@Column(name="USU_CLAVE")
	private int usuClave;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="ROL_ID")
	private Rol rol;

	public Usuario() {
	}

	public int getUsuId() {
		return this.usuId;
	}

	public void setUsuId(int usuId) {
		this.usuId = usuId;
	}

	public boolean getEstadoRegistro() {
		return this.estadoRegistro;
	}

	public void setEstadoRegistro(boolean estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Timestamp getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public int getUsuClave() {
		return this.usuClave;
	}

	public void setUsuClave(int usuClave) {
		this.usuClave = usuClave;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}