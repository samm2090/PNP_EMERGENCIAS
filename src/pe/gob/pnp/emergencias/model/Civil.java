package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

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
	@Column(name = "CIV_ID")
	private int civId;

	// bi-directional many-to-one association to Comisaria
	@OneToMany(mappedBy = "civil", fetch = FetchType.EAGER)
	private List<Llamada> llamadas;

	@Column(name = "CIV_APELLIDO_MATERNO")
	private Object civApellidoMaterno;

	@Column(name = "CIV_APELLIDO_PATERNO")
	private Object civApellidoPaterno;

	@Column(name = "CIV_DOCUMENTO")
	private Object civDocumento;

	@Column(name = "CIV_NOMBRE")
	private Object civNombre;

	@Column(name = "CIV_TELEFONO")
	private Object civTelefono;

	@Column(name = "ESTADO_REGISTRO")
	private boolean estadoRegistro;

	@Column(name = "FECHA_MODIFICACION")
	private Timestamp fechaModificacion;

	@Column(name = "FECHA_REGISTRO")
	private Timestamp fechaRegistro;

	public Civil() {
	}

	public int getCivId() {
		return this.civId;
	}

	public void setCivId(int civId) {
		this.civId = civId;
	}

	public Object getCivApellidoMaterno() {
		return this.civApellidoMaterno;
	}

	public void setCivApellidoMaterno(Object civApellidoMaterno) {
		this.civApellidoMaterno = civApellidoMaterno;
	}

	public Object getCivApellidoPaterno() {
		return this.civApellidoPaterno;
	}

	public void setCivApellidoPaterno(Object civApellidoPaterno) {
		this.civApellidoPaterno = civApellidoPaterno;
	}

	public Object getCivDocumento() {
		return this.civDocumento;
	}

	public void setCivDocumento(Object civDocumento) {
		this.civDocumento = civDocumento;
	}

	public Object getCivNombre() {
		return this.civNombre;
	}

	public void setCivNombre(Object civNombre) {
		this.civNombre = civNombre;
	}

	public Object getCivTelefono() {
		return this.civTelefono;
	}

	public void setCivTelefono(Object civTelefono) {
		this.civTelefono = civTelefono;
	}

	public boolean getEstadoRegistro() {
		return this.estadoRegistro;
	}

	public void setEstadoRegistro(boolean estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public Timestamp getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Timestamp getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public List<Llamada> getLlamadas() {
		return llamadas;
	}

	public void setLlamadas(List<Llamada> llamadas) {
		this.llamadas = llamadas;
	}
	
	

}