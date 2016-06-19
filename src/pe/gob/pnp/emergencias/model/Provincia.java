package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the PROVINCIA database table.
 * 
 */
@Entity
@Table(name = "PROVINCIA")
@NamedQuery(name = "Provincia.findAll", query = "SELECT p FROM Provincia p")
public class Provincia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PRO_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long proId;

	@Column(name = "PRO_DESCRIPCION")
	private String proDescripcion;

	// bi-directional many-to-one association to Distrito
	@OneToMany(mappedBy = "provincia", fetch = FetchType.EAGER)
	private List<Distrito> distritos;

	// bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name = "DEP_ID")
	private Departamento departamento;

	public Provincia() {
	}

	public Long getProId() {
		return proId;
	}

	public void setProId(Long proId) {
		this.proId = proId;
	}

	public String getProDescripcion() {
		return proDescripcion;
	}

	public void setProDescripcion(String proDescripcion) {
		this.proDescripcion = proDescripcion;
	}

	public List<Distrito> getDistritos() {
		return distritos;
	}

	public void setDistritos(List<Distrito> distritos) {
		this.distritos = distritos;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

}