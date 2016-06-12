package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ESTADO database table.
 * 
 */
@Entity
@Table(name="ESTADO")
@NamedQuery(name="Estado.findAll", query="SELECT e FROM Estado e")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="EST_ID")
	private int estId;

	@Column(name="EST_DESCRIPCION")
	private Object estDescripcion;

	//bi-directional many-to-one association to RecursoEstado
	@OneToMany(mappedBy="estado", fetch=FetchType.EAGER)
	private List<RecursoEstado> recursoEstados;

	public Estado() {
	}

	public int getEstId() {
		return this.estId;
	}

	public void setEstId(int estId) {
		this.estId = estId;
	}

	public Object getEstDescripcion() {
		return this.estDescripcion;
	}

	public void setEstDescripcion(Object estDescripcion) {
		this.estDescripcion = estDescripcion;
	}

	public List<RecursoEstado> getRecursoEstados() {
		return this.recursoEstados;
	}

	public void setRecursoEstados(List<RecursoEstado> recursoEstados) {
		this.recursoEstados = recursoEstados;
	}

	public RecursoEstado addRecursoEstado(RecursoEstado recursoEstado) {
		getRecursoEstados().add(recursoEstado);
		recursoEstado.setEstado(this);

		return recursoEstado;
	}

	public RecursoEstado removeRecursoEstado(RecursoEstado recursoEstado) {
		getRecursoEstados().remove(recursoEstado);
		recursoEstado.setEstado(null);

		return recursoEstado;
	}

}