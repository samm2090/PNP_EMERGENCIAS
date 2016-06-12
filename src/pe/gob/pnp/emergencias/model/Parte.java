package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the PARTE database table.
 * 
 */
@Entity
@Table(name = "PARTE")
@NamedQuery(name = "Parte.findAll", query = "SELECT p FROM Parte p")
public class Parte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PAR_ID")
	private Long parId;

	@Column(name = "PAR_FECHA")
	@Temporal(value = TemporalType.DATE)
	private Date parFecha;

	@Column(name = "PAR_OBSERVACION")
	private String parObservacion;

	// bi-directional many-to-one association to EstadoParte
	@ManyToOne
	@JoinColumn(name = "EPA_ID")
	private EstadoParte estadoParte;

	// bi-directional many-to-one association to Recurso
	@ManyToOne
	@JoinColumn(name = "REC_ID")
	private Recurso recurso;

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