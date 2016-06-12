package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DISTRITO database table.
 * 
 */
@Entity
@Table(name="DISTRITO")
@NamedQuery(name="Distrito.findAll", query="SELECT d FROM Distrito d")
public class Distrito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DIS_ID")
	private int disId;

	@Column(name="DIS_DESCRIPCION")
	private Object disDescripcion;

	//bi-directional many-to-one association to Comisaria
	@OneToMany(mappedBy="distrito", fetch=FetchType.EAGER)
	private List<Comisaria> comisarias;

	//bi-directional many-to-one association to Provincia
	@ManyToOne
	@JoinColumn(name="PRO_ID")
	private Provincia provincia;

	//bi-directional many-to-one association to Sector
	@OneToMany(mappedBy="distrito", fetch=FetchType.EAGER)
	private List<Sector> sectors;

	// one to many emergencia
	
	public Distrito() {
	}

	public int getDisId() {
		return this.disId;
	}

	public void setDisId(int disId) {
		this.disId = disId;
	}

	public Object getDisDescripcion() {
		return this.disDescripcion;
	}

	public void setDisDescripcion(Object disDescripcion) {
		this.disDescripcion = disDescripcion;
	}

	public List<Comisaria> getComisarias() {
		return this.comisarias;
	}

	public void setComisarias(List<Comisaria> comisarias) {
		this.comisarias = comisarias;
	}

	public Comisaria addComisaria(Comisaria comisaria) {
		getComisarias().add(comisaria);
		comisaria.setDistrito(this);

		return comisaria;
	}

	public Comisaria removeComisaria(Comisaria comisaria) {
		getComisarias().remove(comisaria);
		comisaria.setDistrito(null);

		return comisaria;
	}

	public Provincia getProvincia() {
		return this.provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public List<Sector> getSectors() {
		return this.sectors;
	}

	public void setSectors(List<Sector> sectors) {
		this.sectors = sectors;
	}

	public Sector addSector(Sector sector) {
		getSectors().add(sector);
		sector.setDistrito(this);

		return sector;
	}

	public Sector removeSector(Sector sector) {
		getSectors().remove(sector);
		sector.setDistrito(null);

		return sector;
	}

}