package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DEPARTAMENTO database table.
 * 
 */
@Entity
@Table(name="DEPARTAMENTO")
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DEP_ID")
	private int depId;

	@Column(name="DEP_DESCRIPCION")
	private Object depDescripcion;

	//bi-directional many-to-one association to Provincia
	@OneToMany(mappedBy="departamento", fetch=FetchType.EAGER)
	private List<Provincia> provincias;

	public Departamento() {
	}

	public int getDepId() {
		return this.depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	public Object getDepDescripcion() {
		return this.depDescripcion;
	}

	public void setDepDescripcion(Object depDescripcion) {
		this.depDescripcion = depDescripcion;
	}

	public List<Provincia> getProvincias() {
		return this.provincias;
	}

	public void setProvincias(List<Provincia> provincias) {
		this.provincias = provincias;
	}

	public Provincia addProvincia(Provincia provincia) {
		getProvincias().add(provincia);
		provincia.setDepartamento(this);

		return provincia;
	}

	public Provincia removeProvincia(Provincia provincia) {
		getProvincias().remove(provincia);
		provincia.setDepartamento(null);

		return provincia;
	}

}