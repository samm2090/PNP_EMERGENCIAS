package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the CIVIL database table.
 * 
 */
@Entity
@Table(name="CIVIL")
@NamedQuery(name="Civil.findAll", query="SELECT c FROM Civil c")
public class Civil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CIV_ID", unique=true, nullable=false)
	private int civId;

	@Column(name="CIV_APELLIDO_MATERNO", nullable=false)
	private Object civApellidoMaterno;

	@Column(name="CIV_APELLIDO_PATERNO", nullable=false)
	private Object civApellidoPaterno;

	@Column(name="CIV_DIRECCION", nullable=false)
	private Object civDireccion;

	@Column(name="CIV_NOMBRE", nullable=false)
	private Object civNombre;

	@Column(name="CIV_TELEFONO", nullable=false)
	private Object civTelefono;

	@Column(name="ESTADO_REGISTRO", nullable=false)
	private boolean estadoRegistro;

	@Column(name="FECHA_MODIFICACION", nullable=false)
	private Timestamp fechaModificacion;

	@Column(name="FECHA_REGISTRO", nullable=false)
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

	public Object getCivDireccion() {
		return this.civDireccion;
	}

	public void setCivDireccion(Object civDireccion) {
		this.civDireccion = civDireccion;
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

}