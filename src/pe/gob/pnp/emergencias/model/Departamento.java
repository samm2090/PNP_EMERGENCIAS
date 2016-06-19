package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTAMENTO")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "DEP_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long depId;

	@Column(name = "DEP_DESCRIPCION")
	private String depDescripcion;

	// bi-directional many-to-one association to Provincia
	@OneToMany(mappedBy = "departamento", fetch = FetchType.EAGER)
	private List<Provincia> provincias;

	public Departamento() {
	}

	public Long getDepId() {
		return depId;
	}

	public void setDepId(Long depId) {
		this.depId = depId;
	}

	public String getDepDescripcion() {
		return depDescripcion;
	}

	public void setDepDescripcion(String depDescripcion) {
		this.depDescripcion = depDescripcion;
	}

	public List<Provincia> getProvincias() {
		return provincias;
	}

	public void setProvincias(List<Provincia> provincias) {
		this.provincias = provincias;
	}

}