package pe.gob.pnp.emergencias.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the SECTOR database table.
 * 
 */
@Entity
@Table(name="SECTOR")
@NamedQuery(name="Sector.findAll", query="SELECT s FROM Sector s")
public class Sector implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SEC_ID")
	private int secId;

	@Column(name="ESTADO_REGISTRO")
	private boolean estadoRegistro;

	@Column(name="SEC_CORDENADA_X")
	private byte[] secCordenadaX;

	@Column(name="SEC_CORDENADA_Y")
	private byte[] secCordenadaY;

	//bi-directional many-to-one association to Comisaria
	@ManyToOne
	@JoinColumn(name="COM_ID")
	private Comisaria comisaria;

	//bi-directional many-to-one association to Distrito
	@ManyToOne
	@JoinColumn(name="DIS_ID")
	private Distrito distrito;

	public Sector() {
	}

	public int getSecId() {
		return this.secId;
	}

	public void setSecId(int secId) {
		this.secId = secId;
	}

	public boolean getEstadoRegistro() {
		return this.estadoRegistro;
	}

	public void setEstadoRegistro(boolean estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public byte[] getSecCordenadaX() {
		return this.secCordenadaX;
	}

	public void setSecCordenadaX(byte[] secCordenadaX) {
		this.secCordenadaX = secCordenadaX;
	}

	public byte[] getSecCordenadaY() {
		return this.secCordenadaY;
	}

	public void setSecCordenadaY(byte[] secCordenadaY) {
		this.secCordenadaY = secCordenadaY;
	}

	public Comisaria getComisaria() {
		return this.comisaria;
	}

	public void setComisaria(Comisaria comisaria) {
		this.comisaria = comisaria;
	}

	public Distrito getDistrito() {
		return this.distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

}