package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import pe.gob.pnp.emergencias.service.ParteService;

@Entity
@Table(name = "PARTE")
public class Parte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PAR_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long parId;

	@Column(name = "PAR_FECHA")
	@Temporal(value = TemporalType.DATE)
	private Date parFecha;

	@Column(name = "PAR_OBSERVACION")
	private String parObservacion;

	// bi-directional many-to-one association to EstadoParte
	@ManyToOne
	@JoinColumn(name = "EPA_ID")
	private EstadoParte estadoParte = new EstadoParte();

	// bi-directional many-to-one association to Recurso
	@ManyToOne
	@JoinColumn(name = "REC_ID")
	private Recurso recurso;
	
	@OneToOne
	@JoinColumn(name = "EME_ID")
	private Emergencia emergencia;

	public Parte() {
	}

	public Long getParId() {
		return parId;
	}

	public void setParId(Long parId) {
		this.parId = parId;
	}

	public Date getParFecha() {
		return parFecha;
	}

	public void setParFecha(Date parFecha) {
		this.parFecha = parFecha;
	}

	public String getParObservacion() {
		return parObservacion;
	}

	public void setParObservacion(String parObservacion) {
		this.parObservacion = parObservacion;
	}

	public EstadoParte getEstadoParte() {
		return estadoParte;
	}

	public void setEstadoParte(EstadoParte estadoParte) {
		this.estadoParte = estadoParte;
	}

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}
	


}