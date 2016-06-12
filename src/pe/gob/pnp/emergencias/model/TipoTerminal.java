package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the TIPO_TERMINAL database table.
 * 
 */
@Entity
@Table(name = "TIPO_TERMINAL")
@NamedQuery(name = "TipoTerminal.findAll", query = "SELECT t FROM TipoTerminal t")
public class TipoTerminal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "TTE_ID")
	private Long tteId;

	@Column(name = "ESTADO_REGISTRO")
	private boolean estadoRegistro;

	@Column(name = "TTE_DESCRIPCION")
	private String tteDescripcion;

	// bi-directional many-to-one association to Comisaria
	@OneToMany(mappedBy = "tipoTerminal", fetch = FetchType.EAGER)
	private List<Llamada> llamadas;

	public TipoTerminal() {
	}

	public Long getTteId() {
		return tteId;
	}

	public void setTteId(Long tteId) {
		this.tteId = tteId;
	}

	public boolean isEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(boolean estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public String getTteDescripcion() {
		return tteDescripcion;
	}

	public void setTteDescripcion(String tteDescripcion) {
		this.tteDescripcion = tteDescripcion;
	}

	public List<Llamada> getLlamadas() {
		return llamadas;
	}

	public void setLlamadas(List<Llamada> llamadas) {
		this.llamadas = llamadas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}