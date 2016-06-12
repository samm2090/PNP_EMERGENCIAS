package pe.gob.pnp.emergencias.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="LLAMADA")
@NamedQuery(name="Llamada", query="SELECT l FROM Llamada l")
public class Llamada {
	
	@Id
	@Column(name="LLA_ID")
	private int llaId;

}
