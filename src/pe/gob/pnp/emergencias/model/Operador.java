package pe.gob.pnp.emergencias.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "OPERADOR")
public class Operador {

	@Id
	@Column(name = "OPE_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long opeId;

	// bi-directional many-to-one association to Comisaria
	@OneToMany(mappedBy = "operador", fetch = FetchType.EAGER)
	private List<Llamada> llamadas;

	@ManyToOne
	@JoinColumn(name = "TUR_ID")
	private Turno turno;

	@ManyToOne
	@JoinColumn(name = "PER_ID")
	private Persona persona;

	@Column(name = "ESTADO_REGISTRO")
	private boolean estadoRegistro;

	@Column(name = "FECHA_CREACION")
	@Temporal(value = TemporalType.DATE)
	private Date fechaCreacion;

	@Column(name = "FECHA_MODIFICACION")
	@Temporal(value = TemporalType.DATE)
	private Date fechaModificacion;

	public Operador() {
	}

	public Long getOpeId() {
		return opeId;
	}

	public void setOpeId(Long opeId) {
		this.opeId = opeId;
	}

	public List<Llamada> getLlamadas() {
		return llamadas;
	}

	public void setLlamadas(List<Llamada> llamadas) {
		this.llamadas = llamadas;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public boolean isEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(boolean estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

}
