package pe.gob.pnp.emergencias.model;

import java.util.Date;

import javax.persistence.CascadeType;
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

@Entity
@Table(name = "RECURSO")
public class Recurso {

	@Id
	@Column(name = "REC_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long recId;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "PER_ID")
	private Persona persona = new Persona();

	@ManyToOne
	@JoinColumn(name = "GRE_ID")
	private GradoRecurso gradoRecurso = new GradoRecurso();

	@ManyToOne
	@JoinColumn(name = "TUR_ID")
	private Turno turno = new Turno();

	@ManyToOne
	@JoinColumn(name = "COM_ID")
	private Comisaria comisaria = new Comisaria();

	@Column(name = "ESTADO_REGISTRO")
	private boolean estadoRegistro;

	@Column(name = "FECHA_CREACION")
	@Temporal(value = TemporalType.DATE)
	private Date fechaCreacion;

	@Column(name = "FECHA_MODIFICACION")
	@Temporal(value = TemporalType.DATE)
	private Date fechaMoficacion;

	public Recurso() {
	}

	public Long getRecId() {
		return recId;
	}

	public void setRecId(Long recId) {
		this.recId = recId;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public GradoRecurso getGradoRecurso() {
		return gradoRecurso;
	}

	public void setGradoRecurso(GradoRecurso gradoRecurso) {
		this.gradoRecurso = gradoRecurso;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Comisaria getComisaria() {
		return comisaria;
	}

	public void setComisaria(Comisaria comisaria) {
		this.comisaria = comisaria;
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

	public Date getFechaMoficacion() {
		return fechaMoficacion;
	}

	public void setFechaMoficacion(Date fechaMoficacion) {
		this.fechaMoficacion = fechaMoficacion;
	}

}
