package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ESTADO_PARTE database table.
 * 
 */
@Entity
@Table(name="ESTADO_PARTE")
@NamedQuery(name="EstadoParte.findAll", query="SELECT e FROM EstadoParte e")
public class EstadoParte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EPA_ID")
	private int epaId;

	@Column(name="EPA_DESCRIPCION")
	private Object epaDescripcion;

	public EstadoParte() {
	}

	public int getEpaId() {
		return this.epaId;
	}

	public void setEpaId(int epaId) {
		this.epaId = epaId;
	}

	public Object getEpaDescripcion() {
		return this.epaDescripcion;
	}

	public void setEpaDescripcion(Object epaDescripcion) {
		this.epaDescripcion = epaDescripcion;
	}

}