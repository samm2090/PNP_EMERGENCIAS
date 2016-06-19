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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long greId;

	@Column(name = "GRE_DESCRIPCION")
	private String greDescripcion;

	@Column(name = "GRE_JERARQUIA")
	private int greJerarquia;

	@OneToMany(mappedBy = "gradoRecurso", fetch = FetchType.EAGER)
	private List<Recurso> recursos;

	public GradoRecurso() {
	}
	
	

	public Long getGreId() {
		return greId;
	}

	public void setGreId(Long greId) {
		this.greId = greId;
	}

	public String getGreDescripcion() {
		return greDescripcion;
	}

	public void setGreDescripcion(String greDescripcion) {
		this.greDescripcion = greDescripcion;
	}

	public int getGreJerarquia() {
		return greJerarquia;
	}

	public void setGreJerarquia(int greJerarquia) {
		this.greJerarquia = greJerarquia;
	}

	public List<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}

}