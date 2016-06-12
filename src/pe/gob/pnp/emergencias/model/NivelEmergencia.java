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
	private Long nemId;

	@Column(name = "NEM_DESCRIPCION")
	private String nemDescripcion;

	// one to many emergencia
	@OneToMany(mappedBy = "nivelEmergencia", fetch = FetchType.EAGER)
	private List<Emergencia> emergencias;

	public NivelEmergencia() {
	}

	public Long getNemId() {
		return nemId;
	}

	public void setNemId(Long nemId) {
		this.nemId = nemId;
	}

	public String getNemDescripcion() {
		return nemDescripcion;
	}

	public void setNemDescripcion(String nemDescripcion) {
		this.nemDescripcion = nemDescripcion;
	}

	public List<Emergencia> getEmergencias() {
		return emergencias;
	}

	public void setEmergencias(List<Emergencia> emergencias) {
		this.emergencias = emergencias;
	}

}