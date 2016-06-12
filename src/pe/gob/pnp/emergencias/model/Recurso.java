package pe.gob.pnp.emergencias.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="RECURSO")
@NamedQuery(name="Recurso.findAll", query="SELECT r FROM Recurso r")
public class Recurso {
	
	@Id
	@Column(name="REC_ID")
	private int recId;

}
