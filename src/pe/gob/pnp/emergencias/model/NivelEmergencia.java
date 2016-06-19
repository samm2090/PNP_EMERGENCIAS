package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "NIVEL_EMERGENCIA")
public class NivelEmergencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NEM_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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