package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the PARTE database table.
 * 
 */
@Entity
@Table(name="PARTE")
@NamedQuery(name="Parte.findAll", query="SELECT p FROM Parte p")
public class Parte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PAR_ID")
	private int parId;

	@Column(name="PAR_FECHA")
	private Timestamp parFecha;

	@Column(name="PAR_OBSERVACION")
	private Object parObservacion;

	//bi-directional many-to-one association to EstadoParte
	@ManyToOne
	@JoinColumn(name="EPA_ID")
	private EstadoParte estadoParte;

	//bi-directional many-to-one association to Recurso
	@ManyToOne
	@JoinColumn(name="REC_ID")
	private Recurso recurso;

	public Parte() {
	}

	public int getParId() {
		return this.parId;
	}

	public void setParId(int parId) {
		this.parId = parId;
	}

	public Timestamp getParFecha() {
		return this.parFecha;
	}

	public void setParFecha(Timestamp parFecha) {
		this.parFecha = parFecha;
	}

	public Object getParObservacion() {
		return this.parObservacion;
	}

	public void setParObservacion(Object parObservacion) {
		this.parObservacion = parObservacion;
	}

	public EstadoParte getEstadoParte() {
		return this.estadoParte;
	}

	public void setEstadoParte(EstadoParte estadoParte) {
		this.estadoParte = estadoParte;
	}

	public Recurso getRecurso() {
		return this.recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

}