package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the COMISARIA database table.
 * 
 */
@Entity
@Table(name="COMISARIA")
@NamedQuery(name="Comisaria.findAll", query="SELECT c FROM Comisaria c")
public class Comisaria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COM_ID")
	private int comId;

	@Column(name="COM_DIRECCION")
	private Object comDireccion;

	@Column(name="COM_NOMBRE")
	private Object comNombre;

	@Column(name="ESTADO_REGISTRO")
	private boolean estadoRegistro;

	//bi-directional many-to-one association to Distrito
	@ManyToOne
	@JoinColumn(name="DIS_ID")
	private Distrito distrito;

	//bi-directional many-to-one association to Sector
	@OneToMany(mappedBy="comisaria", fetch=FetchType.EAGER)
	private List<Sector> sectors;

	public Comisaria() {
	}

	public int getComId() {
		return this.comId;
	}

	public void setComId(int comId) {
		this.comId = comId;
	}

	public Object getComDireccion() {
		return this.comDireccion;
	}

	public void setComDireccion(Object comDireccion) {
		this.comDireccion = comDireccion;
	}

	public Object getComNombre() {
		return this.comNombre;
	}

	public void setComNombre(Object comNombre) {
		this.comNombre = comNombre;
	}

	public boolean getEstadoRegistro() {
		return this.estadoRegistro;
	}

	public void setEstadoRegistro(boolean estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public Distrito getDistrito() {
		return this.distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public List<Sector> getSectors() {
		return this.sectors;
	}

	public void setSectors(List<Sector> sectors) {
		this.sectors = sectors;
	}

	public Sector addSector(Sector sector) {
		getSectors().add(sector);
		sector.setComisaria(this);

		return sector;
	}

	public Sector removeSector(Sector sector) {
		getSectors().remove(sector);
		sector.setComisaria(null);

		return sector;
	}

}