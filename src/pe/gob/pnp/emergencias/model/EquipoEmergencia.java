package pe.gob.pnp.emergencias.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EQUIPO_EMERGENCIA")
public class EquipoEmergencia {

	@Id
	@Column(name = "EEM_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long eemId;

	// bi-directional many-to-one association to Emergencia
	@ManyToOne(cascade =CascadeType.PERSIST)
	@JoinColumn(name = "EME_ID")
	private Emergencia emergencia = new Emergencia();

	// bi-directional many-to-one association to Recurso
	@ManyToOne(cascade =CascadeType.PERSIST)
	@JoinColumn(name = "REC_ID")
	private Recurso recurso = new Recurso();

	public Long getEemId() {
		return eemId;
	}

	public void setEemId(Long eemId) {
		this.eemId = eemId;
	}

	public Emergencia getEmergencia() {
		return emergencia;
	}

	public void setEmergencia(Emergencia emergencia) {
		this.emergencia = emergencia;
	}

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

}
