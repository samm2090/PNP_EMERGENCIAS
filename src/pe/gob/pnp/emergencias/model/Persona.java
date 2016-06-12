package pe.gob.pnp.emergencias.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="PERSONA")
@NamedQuery(name="Persona", query="SELECT p FROM Persona p")
public class Persona {
	
	@Id
	@Column(name="PER_ID")
	private int perId;

}
