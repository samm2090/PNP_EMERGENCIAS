package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the CIVIL database table.
 * 
 */
@Entity
@Table(name = "CIVIL")
@NamedQuery(name = "Civil.findAll", query = "SELECT c FROM Civil c")
public class Civil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CIV_ID")
	private Long civId;

	// bi-directional many-to-one association to Comisaria
	@OneToMany(mappedBy = "civil", fetch = FetchType.EAGER)
	private List<Llamada> llamadas;

	@Column(name = "CIV_APELLIDO_MATERNO")
	private String civApellidoMaterno;

	@Column(name = "CIV_APELLIDO_PATERNO")
	private String civApellidoPaterno;

	@Column(name = "CIV_DOCUMENTO")
	private String civDocumento;

	@Column(name = "CIV_NOMBRE")
	private String civNombre;

	@Column(name = "CIV_TELEFONO")
	private String civTelefono;

	@Column(name = "ESTADO_REGISTRO")
	private boolean estadoRegistro;

	@Column(name = "FECHA_MODIFICACION")
	@Temporal(value = TemporalType.DATE)
	private Date fechaModificacion;

	@Column(name = "FECHA_REGISTRO")
	@Temporal(value = TemporalType.DATE)
	private Date fechaRegistro;

	public Civil() {
	}

	public Long getCivId() {
		return civId;
	}

	public void setCivId(Long civId) {
		this.civId = civId;
	}

	public List<Llamada> getLlamadas() {
		return llamadas;
	}

	public void setLlamadas(List<Llamada> llamadas) {
		this.llamadas = llamadas;
	}

	public String getCivApellidoMaterno() {
		return civApellidoMaterno;
	}

	public void setCivApellidoMaterno(String civApellidoMaterno) {
		this.civApellidoMaterno = civApellidoMaterno;
	}

	public String getCivApellidoPaterno() {
		return civApellidoPaterno;
	}

	public void setCivApellidoPaterno(String civApellidoPaterno) {
		this.civApellidoPaterno = civApellidoPaterno;
	}

	public String getCivDocumento() {
		return civDocumento;
	}

	public void setCivDocumento(String civDocumento) {
		this.civDocumento = civDocumento;
	}

	public String getCivNombre() {
		return civNombre;
	}

	public void setCivNombre(String civNombre) {
		this.civNombre = civNombre;
	}

	public String getCivTelefono() {
		return civTelefono;
	}

	public void setCivTelefono(String civTelefono) {
		this.civTelefono = civTelefono;
	}

	public boolean isEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(boolean estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}