package pe.gob.pnp.emergencias.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="EMERGENCIA")
@NamedQuery(name="Emergencia.findAll", query="SELECT e FROM Emergencia e")
public class Emergencia {
	
	@Id
	@Column(name="EME_ID")
	private int emeId;

}
