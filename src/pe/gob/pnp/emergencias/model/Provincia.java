package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PROVINCIA database table.
 * 
 */
@Entity
@Table(name="PROVINCIA")
@NamedQuery(name="Provincia.findAll", query="SELECT p FROM Provincia p")
public class Provincia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PRO_ID")
	private int proId;

	@Column(name="PRO_DESCRIPCION")
	private Object proDescripcion;

	//bi-directional many-to-one association to Distrito
	@OneToMany(mappedBy="provincia", fetch=FetchType.EAGER)
	private List<Distrito> distritos;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="DEP_ID")
	private Departamento departamento;

	public Provincia() {
	}

	public int getProId() {
		return this.proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public Object getProDescripcion() {
		return this.proDescripcion;
	}

	public void setProDescripcion(Object proDescripcion) {
		this.proDescripcion = proDescripcion;
	}

	public List<Distrito> getDistritos() {
		return this.distritos;
	}

	public void setDistritos(List<Distrito> distritos) {
		this.distritos = distritos;
	}

	public Distrito addDistrito(Distrito distrito) {
		getDistritos().add(distrito);
		distrito.setProvincia(this);

		return distrito;
	}

	public Distrito removeDistrito(Distrito distrito) {
		getDistritos().remove(distrito);
		distrito.setProvincia(null);

		return distrito;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

}