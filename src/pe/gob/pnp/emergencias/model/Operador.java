package pe.gob.pnp.emergencias.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="OPERADOR")
@NamedQuery(name="Operador", query="SELECT o FROM Operador o")
public class Operador {
	
	@Id
	@Column(name="OPE_ID")
	private int opeId;

}
