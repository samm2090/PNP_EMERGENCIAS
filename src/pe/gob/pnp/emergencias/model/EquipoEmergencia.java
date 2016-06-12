package pe.gob.pnp.emergencias.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="EQUIPOEMERGENCIA")
@NamedQuery(name="EquipoEmergencia", query="SELECT eem FROM EquipoEmergencia eem")
public class EquipoEmergencia {
	
	@Id
	@Column(name="EEM")
	private int eemId;

}
