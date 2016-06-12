package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TIPO_PERSONAL database table.
 * 
 */
@Entity
@Table(name="TIPO_PERSONAL")
@NamedQuery(name="TipoPersonal.findAll", query="SELECT t FROM TipoPersonal t")
public class TipoPersonal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TPE_ID")
	private int tpeId;

	@Column(name="TPE_DESCRIPCION")
	private Object tpeDescripcion;

	public TipoPersonal() {
	}

	public int getTpeId() {
		return this.tpeId;
	}

	public void setTpeId(int tpeId) {
		this.tpeId = tpeId;
	}

	public Object getTpeDescripcion() {
		return this.tpeDescripcion;
	}

	public void setTpeDescripcion(Object tpeDescripcion) {
		this.tpeDescripcion = tpeDescripcion;
	}

}