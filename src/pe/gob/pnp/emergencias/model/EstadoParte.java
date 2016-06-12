package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	@Column(name="EPA_ID")
	private int epaId;

	@Column(name="EPA_DESCRIPCION")
	private Object epaDescripcion;

	//bi-directional many-to-one association to Parte
	@OneToMany(mappedBy="estadoParte", fetch=FetchType.EAGER)
	private List<Parte> partes;

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

	public List<Parte> getPartes() {
		return this.partes;
	}

	public void setPartes(List<Parte> partes) {
		this.partes = partes;
	}

	public Parte addParte(Parte parte) {
		getPartes().add(parte);
		parte.setEstadoParte(this);

		return parte;
	}

	public Parte removeParte(Parte parte) {
		getPartes().remove(parte);
		parte.setEstadoParte(null);

		return parte;
	}

}