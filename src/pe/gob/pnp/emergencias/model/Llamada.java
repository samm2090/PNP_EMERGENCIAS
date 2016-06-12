package pe.gob.pnp.emergencias.model;

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

@Entity
@Table(name = "LLAMADA")
@NamedQuery(name = "Llamada", query = "SELECT lla FROM Llamada lla")
public class Llamada {

	@Id
	@Column(name = "LLA_ID")
	private int llaId;

	@ManyToOne
	@JoinColumn(name = "TTE_ID")
	private TipoTerminal tipoTerminal;

	@ManyToOne
	@JoinColumn(name = "CIV_ID")
	private Civil civil;

	@ManyToOne
	@JoinColumn(name = "OPE_ID")
	private Operador operador;

	@Column(name = "LLA_OBSERVACION")
	private String llaObservacion;

	@Column(name = "LLA_FECHA")
	@Temporal(value = TemporalType.DATE)
	private Date llaFecha;

	@Column(name = "LLA_ESTADO")
	private boolean llaEstado;

	@Column(name = "LLA_TELEFONO")
	private String llaTelefono;

	@Column(name = "LLA_HORA_INICIO")
	private String llaHoraInicio;

	@Column(name = "LLA_HORA_FIN")
	private String llaHoraFin;

	@Column(name = "ESTADO_REGISTRO")
	private boolean estadoRegistro;

	public Llamada() {
	}

	public int getLlaId() {
		return llaId;
	}

	public void setLlaId(int llaId) {
		this.llaId = llaId;
	}

	public TipoTerminal getTipoTerminal() {
		return tipoTerminal;
	}

	public void setTipoTerminal(TipoTerminal tipoTerminal) {
		this.tipoTerminal = tipoTerminal;
	}

	public Civil getCivil() {
		return civil;
	}

	public void setCivil(Civil civil) {
		this.civil = civil;
	}

	public Operador getOperador() {
		return operador;
	}

	public void setOperador(Operador operador) {
		this.operador = operador;
	}

	public String getLlaObservacion() {
		return llaObservacion;
	}

	public void setLlaObservacion(String llaObservacion) {
		this.llaObservacion = llaObservacion;
	}

	public Date getLlaFecha() {
		return llaFecha;
	}

	public void setLlaFecha(Date llaFecha) {
		this.llaFecha = llaFecha;
	}

	public boolean isLlaEstado() {
		return llaEstado;
	}

	public void setLlaEstado(boolean llaEstado) {
		this.llaEstado = llaEstado;
	}

	public String getLlaTelefono() {
		return llaTelefono;
	}

	public void setLlaTelefono(String llaTelefono) {
		this.llaTelefono = llaTelefono;
	}

	public String getLlaHoraInicio() {
		return llaHoraInicio;
	}

	public void setLlaHoraInicio(String llaHoraInicio) {
		this.llaHoraInicio = llaHoraInicio;
	}

	public String getLlaHoraFin() {
		return llaHoraFin;
	}

	public void setLlaHoraFin(String llaHoraFin) {
		this.llaHoraFin = llaHoraFin;
	}

	public boolean isEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(boolean estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

}
