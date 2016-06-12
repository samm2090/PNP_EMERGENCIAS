package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the NIVEL_EMERGENCIA database table.
 * 
 */
@Entity
@Table(name="NIVEL_EMERGENCIA")
@NamedQuery(name="NivelEmergencia.findAll", query="SELECT n FROM NivelEmergencia n")
public class NivelEmergencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NEM_ID")
	private int nemId;

	@Column(name="NEM_DESCRIPCION")
	private Object nemDescripcion;

	public NivelEmergencia() {
	}

	public int getNemId() {
		return this.nemId;
	}

	public void setNemId(int nemId) {
		this.nemId = nemId;
	}

	public Object getNemDescripcion() {
		return this.nemDescripcion;
	}

	public void setNemDescripcion(Object nemDescripcion) {
		this.nemDescripcion = nemDescripcion;
	}

}