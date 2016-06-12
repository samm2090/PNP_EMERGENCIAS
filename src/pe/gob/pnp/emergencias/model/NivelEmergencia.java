package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the NIVEL_EMERGENCIA database table.
 * 
 */
@Entity
@Table(name = "NIVEL_EMERGENCIA")
@NamedQuery(name = "NivelEmergencia.findAll", query = "SELECT n FROM NivelEmergencia n")
public class NivelEmergencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NEM_ID")
	private int nemId;

	@Column(name = "NEM_DESCRIPCION")
	private Object nemDescripcion;

	// one to many emergencia
	@OneToMany(mappedBy = "nivelEmergencia", fetch = FetchType.EAGER)
	private List<Emergencia> emergencias;

	public NivelEmergencia() {
	}

	public List<Emergencia> getEmergencias() {
		return emergencias;
	}

	public void setEmergencias(List<Emergencia> emergencias) {
		this.emergencias = emergencias;
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