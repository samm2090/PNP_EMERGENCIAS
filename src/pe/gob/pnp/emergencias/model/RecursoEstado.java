package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the RECURSO_ESTADO database table.
 * 
 */
@Entity
@Table(name="RECURSO_ESTADO")
@NamedQuery(name="RecursoEstado.findAll", query="SELECT r FROM RecursoEstado r")
public class RecursoEstado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="REE_ID")
	private int reeId;

	@Column(name="REE_FECHA")
	private Timestamp reeFecha;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="EST_ID")
	private Estado estado;

	//bi-directional many-to-one association to Recurso
	@ManyToOne
	@JoinColumn(name="REC_ID")
	private Recurso recurso;

	public RecursoEstado() {
	}

	public int getReeId() {
		return this.reeId;
	}

	public void setReeId(int reeId) {
		this.reeId = reeId;
	}

	public Timestamp getReeFecha() {
		return this.reeFecha;
	}

	public void setReeFecha(Timestamp reeFecha) {
		this.reeFecha = reeFecha;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Recurso getRecurso() {
		return this.recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

}