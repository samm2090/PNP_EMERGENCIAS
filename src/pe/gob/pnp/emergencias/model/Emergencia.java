package pe.gob.pnp.emergencias.model;

import java.math.BigDecimal;
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
@Table(name = "EMERGENCIA")
public class Emergencia {

	@Id
	@Column(name = "EME_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long emeId;

	@ManyToOne(cascade =CascadeType.PERSIST)
	@JoinColumn(name = "NEM_ID")
	private NivelEmergencia nivelEmergencia = new NivelEmergencia();

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "LLA_ID")
	private Llamada llamada = new Llamada();

	@ManyToOne(cascade =CascadeType.PERSIST)
	@JoinColumn(name = "TEM_ID")
	private TipoEmergencia tipoEmergencia = new TipoEmergencia();

	@ManyToOne
	@JoinColumn(name = "DIS_ID")
	private Distrito distrito = new Distrito();

	@Column(name = "EME_DIR")
	private String emeDir;

	@Column(name = "EME_OBSERVACION")
	private String emeObservacion;

	@Temporal(value = TemporalType.DATE)
	@Column(name = "EME_FECHA")
	private Date emeFecha;

	@Column(name = "EME_HORA_INICIO")
	private String emeHoraInicio;

	@Column(name = "EME_HORA_FIN")
	private String emeHoraFin;

	@Column(name="EME_LATITUD", precision=8, scale=6)
	private BigDecimal latitud;
	
	@Column(name="EME_LONGITUD", precision=8, scale=6)
	private BigDecimal longitud;
	
	public Emergencia() {
	}
	
	public Long getEmeId() {
		return emeId;
	}

	public void setEmeId(Long emeId) {
		this.emeId = emeId;
	}

	public NivelEmergencia getNivelEmergencia() {
		return nivelEmergencia;
	}

	public void setNivelEmergencia(NivelEmergencia nivelEmergencia) {
		this.nivelEmergencia = nivelEmergencia;
	}

	public Llamada getLlamada() {
		return llamada;
	}

	public void setLlamada(Llamada llamada) {
		this.llamada = llamada;
	}

	public TipoEmergencia getTipoEmergencia() {
		return tipoEmergencia;
	}

	public void setTipoEmergencia(TipoEmergencia tipoEmergencia) {
		this.tipoEmergencia = tipoEmergencia;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public String getEmeDir() {
		return emeDir;
	}

	public void setEmeDir(String emeDir) {
		this.emeDir = emeDir;
	}

	public String getEmeObservacion() {
		return emeObservacion;
	}

	public void setEmeObservacion(String emeObservacion) {
		this.emeObservacion = emeObservacion;
	}

	public Date getEmeFecha() {
		return emeFecha;
	}

	public void setEmeFecha(Date emeFecha) {
		this.emeFecha = emeFecha;
	}

	public String getEmeHoraInicio() {
		return emeHoraInicio;
	}

	public void setEmeHoraInicio(String emeHoraInicio) {
		this.emeHoraInicio = emeHoraInicio;
	}

	public String getEmeHoraFin() {
		return emeHoraFin;
	}

	public void setEmeHoraFin(String emeHoraFin) {
		this.emeHoraFin = emeHoraFin;
	}

	public BigDecimal getLatitud() {
		return latitud;
	}

	public void setLatitud(BigDecimal latitud) {
		this.latitud = latitud;
	}

	public BigDecimal getLongitud() {
		return longitud;
	}

	public void setLongitud(BigDecimal longitud) {
		this.longitud = longitud;
	}
}
