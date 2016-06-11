package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ESTADO database table.
 * 
 */
@Entity
@Table(name="ESTADO")
@NamedQuery(name="Estado.findAll", query="SELECT e FROM Estado e")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EST_ID")
	private int estId;

	@Column(name="EST_DESCRIPCION")
	private Object estDescripcion;

	public Estado() {
	}

	public int getEstId() {
		return this.estId;
	}

	public void setEstId(int estId) {
		this.estId = estId;
	}

	public Object getEstDescripcion() {
		return this.estDescripcion;
	}

	public void setEstDescripcion(Object estDescripcion) {
		this.estDescripcion = estDescripcion;
	}

}