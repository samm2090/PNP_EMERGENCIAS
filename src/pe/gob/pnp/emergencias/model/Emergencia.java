package pe.gob.pnp.emergencias.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "EMERGENCIA")
@NamedQuery(name = "Emergencia.findAll", query = "SELECT e FROM Emergencia e")
public class Emergencia {

	@Id
	@Column(name = "EME_ID")
	private int emeId;

	@ManyToOne
	@JoinColumn(name = "NEM_ID")
	private NivelEmergencia nivelEmergencia;

	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "LLA_ID")
	private Llamada llamada;

	@ManyToOne
	@JoinColumn(name = "TEM_ID")
	private TipoEmergencia tipoEmergencia;

	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "PAR_ID")
	private Parte parte;

	@ManyToOne
	@JoinColumn(name = "DIS_ID")
	private Distrito distrito;

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

	public Emergencia(){}
	
	public int getEmeId() {
		return emeId;
	}

	public void setEmeId(int emeId) {
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

	public Parte getParte() {
		return parte;
	}

	public void setParte(Parte parte) {
		this.parte = parte;
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

}
