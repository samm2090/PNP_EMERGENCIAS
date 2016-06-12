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
 * The persistent class for the RECURSO_ESTADO database table.
 * 
 */
@Entity
@Table(name = "RECURSO_ESTADO")
@NamedQuery(name = "RecursoEstado.findAll", query = "SELECT r FROM RecursoEstado r")
public class RecursoEstado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "REE_ID")
	private Long reeId;

	@Column(name = "REE_FECHA")
	@Temporal(value = TemporalType.DATE)
	private Date reeFecha;

	// bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name = "EST_ID")
	private Estado estado;

	// bi-directional many-to-one association to Recurso
	@ManyToOne
	@JoinColumn(name = "REC_ID")
	private Recurso recurso;

	public RecursoEstado() {
	}

	public Long getReeId() {
		return reeId;
	}

	public void setReeId(Long reeId) {
		this.reeId = reeId;
	}

	public Date getReeFecha() {
		return reeFecha;
	}

	public void setReeFecha(Date reeFecha) {
		this.reeFecha = reeFecha;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

}