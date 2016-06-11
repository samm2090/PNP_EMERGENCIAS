package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import javax.persistence.*;


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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DEP_ID")
	private int depId;

	@Column(name="DEP_DESCRIPCION")
	private Object depDescripcion;

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

}