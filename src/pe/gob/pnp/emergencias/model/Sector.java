package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="SECTOR")
public class Sector implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SEC_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long secId;

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

	public Long getSecId() {
		return secId;
	}

	public void setSecId(Long secId) {
		this.secId = secId;
	}

	public boolean isEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(boolean estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public byte[] getSecCordenadaX() {
		return secCordenadaX;
	}

	public void setSecCordenadaX(byte[] secCordenadaX) {
		this.secCordenadaX = secCordenadaX;
	}

	public byte[] getSecCordenadaY() {
		return secCordenadaY;
	}

	public void setSecCordenadaY(byte[] secCordenadaY) {
		this.secCordenadaY = secCordenadaY;
	}

	public Comisaria getComisaria() {
		return comisaria;
	}

	public void setComisaria(Comisaria comisaria) {
		this.comisaria = comisaria;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	

}