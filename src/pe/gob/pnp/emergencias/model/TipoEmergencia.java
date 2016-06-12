package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import java.util.List;

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

	// one to many emergencia
	@OneToMany(mappedBy="tipoEmergencia", fetch=FetchType.EAGER)
	private List<Emergencia> emergencias;
	
	public TipoEmergencia() {
	}

	public List<Emergencia> getEmergencias() {
		return emergencias;
	}

	public void setEmergencias(List<Emergencia> emergencias) {
		this.emergencias = emergencias;
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