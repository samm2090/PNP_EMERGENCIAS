package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TURNO database table.
 * 
 */
@Entity
@Table(name="TURNO")
@NamedQuery(name="Turno.findAll", query="SELECT t FROM Turno t")
public class Turno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TUR_ID")
	private int turId;

	@Column(name="ESTADO_REGISTRO")
	private boolean estadoRegistro;

	@Column(name="TUR_DESCRIPCION")
	private Object turDescripcion;

	@Column(name="TUR_HORA_FINAL")
	private String turHoraFinal;

	@Column(name="TUR_HORA_INICIAL")
	private String turHoraInicial;

	@Column(name="TUR_RANGO")
	private Object turRango;

	public Turno() {
	}

	public int getTurId() {
		return this.turId;
	}

	public void setTurId(int turId) {
		this.turId = turId;
	}

	public boolean getEstadoRegistro() {
		return this.estadoRegistro;
	}

	public void setEstadoRegistro(boolean estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public Object getTurDescripcion() {
		return this.turDescripcion;
	}

	public void setTurDescripcion(Object turDescripcion) {
		this.turDescripcion = turDescripcion;
	}

	public String getTurHoraFinal() {
		return this.turHoraFinal;
	}

	public void setTurHoraFinal(String turHoraFinal) {
		this.turHoraFinal = turHoraFinal;
	}

	public String getTurHoraInicial() {
		return this.turHoraInicial;
	}

	public void setTurHoraInicial(String turHoraInicial) {
		this.turHoraInicial = turHoraInicial;
	}

	public Object getTurRango() {
		return this.turRango;
	}

	public void setTurRango(Object turRango) {
		this.turRango = turRango;
	}

}