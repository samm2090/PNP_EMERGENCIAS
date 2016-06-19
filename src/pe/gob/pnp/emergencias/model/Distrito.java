package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DISTRITO")

public class Distrito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "DIS_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long disId;

	@Column(name = "DIS_DESCRIPCION")
	private String disDescripcion;

	// bi-directional many-to-one association to Comisaria
	@OneToMany(mappedBy = "distrito", fetch = FetchType.EAGER)
	private List<Comisaria> comisarias;

	// bi-directional many-to-one association to Provincia
	@ManyToOne
	@JoinColumn(name = "PRO_ID")
	private Provincia provincia;

	// bi-directional many-to-one association to Sector
	@OneToMany(mappedBy = "distrito", fetch = FetchType.EAGER)
	private List<Sector> sectors;

	// one to many emergencia

	public Distrito() {
	}

	public Long getDisId() {
		return disId;
	}

	public void setDisId(Long disId) {
		this.disId = disId;
	}

	public String getDisDescripcion() {
		return disDescripcion;
	}

	public void setDisDescripcion(String disDescripcion) {
		this.disDescripcion = disDescripcion;
	}

	public List<Comisaria> getComisarias() {
		return comisarias;
	}

	public void setComisarias(List<Comisaria> comisarias) {
		this.comisarias = comisarias;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public List<Sector> getSectors() {
		return sectors;
	}

	public void setSectors(List<Sector> sectors) {
		this.sectors = sectors;
	}

}