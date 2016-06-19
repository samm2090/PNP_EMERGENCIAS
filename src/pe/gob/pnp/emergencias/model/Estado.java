package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the ESTADO database table.
 * 
 */
@Entity
@Table(name = "ESTADO")
@NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "EST_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long estId;

	@Column(name = "EST_DESCRIPCION")
	private String estDescripcion;

	// bi-directional many-to-one association to RecursoEstado
	@OneToMany(mappedBy = "estado", fetch = FetchType.EAGER)
	private List<RecursoEstado> recursoEstados;

	public Estado() {
	}

	public Long getEstId() {
		return estId;
	}

	public void setEstId(Long estId) {
		this.estId = estId;
	}

	public String getEstDescripcion() {
		return estDescripcion;
	}

	public void setEstDescripcion(String estDescripcion) {
		this.estDescripcion = estDescripcion;
	}

	public List<RecursoEstado> getRecursoEstados() {
		return recursoEstados;
	}

	public void setRecursoEstados(List<RecursoEstado> recursoEstados) {
		this.recursoEstados = recursoEstados;
	}

}