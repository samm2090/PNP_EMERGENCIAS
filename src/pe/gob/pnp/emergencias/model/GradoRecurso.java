package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the GRADO_RECURSO database table.
 * 
 */
@Entity
@Table(name = "GRADO_RECURSO")
@NamedQuery(name = "GradoRecurso.findAll", query = "SELECT g FROM GradoRecurso g")
public class GradoRecurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "GRE_ID")
	private int greId;

	@Column(name = "GRE_DESCRIPCION")
	private Object greDescripcion;

	@Column(name = "GRE_JERARQUIA")
	private int greJerarquia;

	@OneToMany(mappedBy = "gradoRecurso", fetch = FetchType.EAGER)
	private List<Recurso> recursos;

	public GradoRecurso() {
	}

	public List<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}

	public int getGreId() {
		return this.greId;
	}

	public void setGreId(int greId) {
		this.greId = greId;
	}

	public Object getGreDescripcion() {
		return this.greDescripcion;
	}

	public void setGreDescripcion(Object greDescripcion) {
		this.greDescripcion = greDescripcion;
	}

	public int getGreJerarquia() {
		return this.greJerarquia;
	}

	public void setGreJerarquia(int greJerarquia) {
		this.greJerarquia = greJerarquia;
	}

}