package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TIPO_TERMINAL database table.
 * 
 */
@Entity
@Table(name="TIPO_TERMINAL")
@NamedQuery(name="TipoTerminal.findAll", query="SELECT t FROM TipoTerminal t")
public class TipoTerminal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TTE_ID")
	private int tteId;

	@Column(name="ESTADO_REGISTRO")
	private boolean estadoRegistro;

	@Column(name="TTE_DESCRIPCION")
	private String tteDescripcion;

	public TipoTerminal() {
	}

	public int getTteId() {
		return this.tteId;
	}

	public void setTteId(int tteId) {
		this.tteId = tteId;
	}

	public boolean getEstadoRegistro() {
		return this.estadoRegistro;
	}

	public void setEstadoRegistro(boolean estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public String getTteDescripcion() {
		return this.tteDescripcion;
	}

	public void setTteDescripcion(String tteDescripcion) {
		this.tteDescripcion = tteDescripcion;
	}

}