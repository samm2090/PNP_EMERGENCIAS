package pe.gob.pnp.emergencias.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "RECURSO")
@NamedQuery(name = "Recurso.findAll", query = "SELECT r FROM Recurso r")
public class Recurso {

	@Id
	@Column(name = "REC_ID")
	private Long recId;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "PER_ID")
	private Persona persona;

	@ManyToOne
	@JoinColumn(name = "GRE_ID")
	private GradoRecurso gradoRecurso;

	@ManyToOne
	@JoinColumn(name = "TUR_ID")
	private Turno turno;

	@ManyToOne
	@JoinColumn(name = "COM_ID")
	private Comisaria comisaria;

	@Column(name = "ESTADO_REGISTRO")
	private boolean estadoRegistro;

	@Column(name = "FECHA_CREACION")
	@Temporal(value = TemporalType.DATE)
	private Date fechaCreacion;

	@Column(name = "FECHA_MODIFICACION")
	@Temporal(value = TemporalType.DATE)
	private Date fechaMoficacion;

	@ManyToMany(mappedBy = "recursos")
	private List<Emergencia> emergencias;

	public Recurso() {
	}

	public List<Emergencia> getEmergencias() {
		return emergencias;
	}

	public void setEmergencias(List<Emergencia> emergencias) {
		this.emergencias = emergencias;
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
