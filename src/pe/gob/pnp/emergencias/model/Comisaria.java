package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "COMISARIA")
public class Comisaria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "COM_ID")
	private Long comId;

	@Column(name = "COM_DIRECCION")
	private String comDireccion;

	@Column(name = "COM_NOMBRE")
	private String comNombre;

	@Column(name = "ESTADO_REGISTRO")
	private boolean estadoRegistro;

	// bi-directional many-to-one association to Distrito
	@ManyToOne(cascade =CascadeType.PERSIST)
	@JoinColumn(name = "DIS_ID")
	private Distrito distrito=new Distrito();

	// bi-directional many-to-one association to Sector
	@OneToMany(mappedBy = "comisaria", fetch = FetchType.EAGER)
	private List<Sector> sectors;

	@OneToMany(mappedBy = "comisaria", fetch = FetchType.EAGER)
	private List<Recurso> recursos;

	public Comisaria() {
	}

	public Long getComId() {
		return comId;
	}

	public void setComId(Long comId) {
		this.comId = comId;
	}

	public String getComDireccion() {
		return comDireccion;
	}

	public void setComDireccion(String comDireccion) {
		this.comDireccion = comDireccion;
	}

	public String getComNombre() {
		return comNombre;
	}

	public void setComNombre(String comNombre) {
		this.comNombre = comNombre;
	}

	public boolean isEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(boolean estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public List<Sector> getSectors() {
		return sectors;
	}

	public void setSectors(List<Sector> sectors) {
		this.sectors = sectors;
	}

	public List<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}

}