package pe.gob.pnp.emergencias.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="EQUIPO_EMERGENCIA")
@NamedQuery(name="EquipoEmergencia", query="SELECT eem FROM EquipoEmergencia eem")
public class EquipoEmergencia {
	
	@Id
	@Column(name="EEM_ID")
	private int eemId;

	@ManyToOne
	@JoinColumn(name = "REC_ID")
	private Recurso recurso;
	
	@ManyToOne
	@JoinColumn(name = "EME_ID")
	private Emergencia emergencia;
	
	public EquipoEmergencia(){}
	
	public int getEemId() {
		return eemId;
	}

	public void setEemId(int eemId) {
		this.eemId = eemId;
	}

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

	public Emergencia getEmergencia() {
		return emergencia;
	}

	public void setEmergencia(Emergencia emergencia) {
		this.emergencia = emergencia;
	}
	
	

}
