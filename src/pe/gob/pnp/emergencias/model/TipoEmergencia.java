package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TIPO_EMERGENCIA database table.
 * 
 */
@Entity
@Table(name="TIPO_EMERGENCIA")
@NamedQuery(name="TipoEmergencia.findAll", query="SELECT t FROM TipoEmergencia t")
public class TipoEmergencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TEM_ID")
	private int temId;

	@Column(name="TEM_DESCRIPCION")
	private Object temDescripcion;

	public TipoEmergencia() {
	}

	public int getTemId() {
		return this.temId;
	}

	public void setTemId(int temId) {
		this.temId = temId;
	}

	public Object getTemDescripcion() {
		return this.temDescripcion;
	}

	public void setTemDescripcion(Object temDescripcion) {
		this.temDescripcion = temDescripcion;
	}

}