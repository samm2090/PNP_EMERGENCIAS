package pe.gob.pnp.emergencias.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "PERSONA")
public class Persona {

	@Id
	@Column(name = "PER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long perId;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "USU_ID")
	private Usuario usuId = new Usuario();

	@ManyToOne
	@JoinColumn(name = "TPE_ID")
	private TipoPersonal tpeId =new TipoPersonal();

	// bi-directional many-to-one association to Comisaria
	@OneToMany(mappedBy = "persona", fetch = FetchType.EAGER)
	private List<Operador> operadores;

	// bi-directional many-to-one association to Comisaria
	@OneToMany(mappedBy = "persona", fetch = FetchType.EAGER)
	private List<Recurso> recursos;
	

	@Column(name = "PER_NOMBRE")
	private String perNombre;

	@Column(name = "PER_APELLIDO_PATERNO")
	private String perApellidoPaterno;

	@Column(name = "PER_APELLIDO_MATERNO")
	private String perApellidoMaterno;

	@Column(name = "PER_FECHA_NACIMIENTO")
	@Temporal(value = TemporalType.DATE)
	private Date perFechaNacimiento;

	@Column(name = "PER_DNI")
	private String perDni;

	@Column(name = "PER_DIRECCION")
	private String perDireccion;

	@Column(name = "PER_CORREO")
	private String perCorreo;

	@Column(name = "PER_TELEFONO")
	private String perTelefono;

	@Column(name = "PER_GENERO")
	private String perGenero;

	@Column(name = "PER_ESTADO_CIVIL")
	private String perEstadoCivil;

	@Column(name = "ESTADO_REGISTRO")
	private boolean estadoRegistro;

	@Column(name = "FECHA_CREACION")
	@Temporal(value = TemporalType.DATE)
	private Date fechaCreacion;

	@Column(name = "FECHA_MODIFICACION")
	@Temporal(value = TemporalType.DATE)
	private Date fechaModificacion;

	public Persona() {
	}

	public Long getPerId() {
		return perId;
	}

	public void setPerId(Long perId) {
		this.perId = perId;
	}

	public Usuario getUsuId() {
		return usuId;
	}

	public void setUsuId(Usuario usuId) {
		this.usuId = usuId;
	}

	public TipoPersonal getTpeId() {
		return tpeId;
	}

	public void setTpeId(TipoPersonal tpeId) {
		this.tpeId = tpeId;
	}

	public List<Operador> getOperadores() {
		return operadores;
	}

	public void setOperadores(List<Operador> operadores) {
		this.operadores = operadores;
	}

	public List<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}

	public String getPerNombre() {
		return perNombre;
	}

	public void setPerNombre(String perNombre) {
		this.perNombre = perNombre;
	}

	public String getPerApellidoPaterno() {
		return perApellidoPaterno;
	}

	public void setPerApellidoPaterno(String perApellidoPaterno) {
		this.perApellidoPaterno = perApellidoPaterno;
	}

	public String getPerApellidoMaterno() {
		return perApellidoMaterno;
	}

	public void setPerApellidoMaterno(String perApellidoMaterno) {
		this.perApellidoMaterno = perApellidoMaterno;
	}

	public Date getPerFechaNacimiento() {
		return perFechaNacimiento;
	}

	public void setPerFechaNacimiento(Date perFechaNacimiento) {
		this.perFechaNacimiento = perFechaNacimiento;
	}

	public String getPerDni() {
		return perDni;
	}

	public void setPerDni(String perDni) {
		this.perDni = perDni;
	}

	public String getPerDireccion() {
		return perDireccion;
	}

	public void setPerDireccion(String perDireccion) {
		this.perDireccion = perDireccion;
	}

	public String getPerCorreo() {
		return perCorreo;
	}

	public void setPerCorreo(String perCorreo) {
		this.perCorreo = perCorreo;
	}

	public String getPerTelefono() {
		return perTelefono;
	}

	public void setPerTelefono(String perTelefono) {
		this.perTelefono = perTelefono;
	}

	public String getPerGenero() {
		return perGenero;
	}

	public void setPerGenero(String perGenero) {
		this.perGenero = perGenero;
	}

	public String getPerEstadoCivil() {
		return perEstadoCivil;
	}

	public void setPerEstadoCivil(String perEstadoCivil) {
		this.perEstadoCivil = perEstadoCivil;
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
