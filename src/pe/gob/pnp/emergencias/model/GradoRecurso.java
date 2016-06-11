package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GRADO_RECURSO database table.
 * 
 */
@Entity
@Table(name="GRADO_RECURSO")
@NamedQuery(name="GradoRecurso.findAll", query="SELECT g FROM GradoRecurso g")
public class GradoRecurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="GRE_ID")
	private int greId;

	@Column(name="GRE_DESCRIPCION")
	private Object greDescripcion;

	@Column(name="GRE_JERARQUIA")
	private int greJerarquia;

	public GradoRecurso() {
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