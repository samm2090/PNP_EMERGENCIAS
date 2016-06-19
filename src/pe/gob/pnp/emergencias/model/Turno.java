package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the TURNO database table.
 * 
 */
@Entity
@Table(name = "TURNO")
public class Turno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "TUR_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long turId;

	@Column(name = "ESTADO_REGISTRO")
	private boolean estadoRegistro;

	@Column(name = "TUR_DESCRIPCION")
	private String turDescripcion;

	@Column(name = "TUR_HORA_FINAL")
	private String turHoraFinal;

	@Column(name = "TUR_HORA_INICIAL")
	private String turHoraInicial;

	@Column(name = "TUR_RANGO")
	private String turRango;

	@OneToMany(mappedBy = "turno", fetch = FetchType.EAGER)
	private List<Recurso> recursos;

	public Turno() {
	}

	public Long getTurId() {
		return turId;
	}

	public void setTurId(Long turId) {
		this.turId = turId;
	}

	public boolean isEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(boolean estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public String getTurDescripcion() {
		return turDescripcion;
	}

	public void setTurDescripcion(String turDescripcion) {
		this.turDescripcion = turDescripcion;
	}

	public String getTurHoraFinal() {
		return turHoraFinal;
	}

	public void setTurHoraFinal(String turHoraFinal) {
		this.turHoraFinal = turHoraFinal;
	}

	public String getTurHoraInicial() {
		return turHoraInicial;
	}

	public void setTurHoraInicial(String turHoraInicial) {
		this.turHoraInicial = turHoraInicial;
	}

	public String getTurRango() {
		return turRango;
	}

	public void setTurRango(String turRango) {
		this.turRango = turRango;
	}

	public List<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}