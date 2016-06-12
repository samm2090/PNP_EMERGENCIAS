package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the TIPO_PERSONAL database table.
 * 
 */
@Entity
@Table(name = "TIPO_PERSONAL")
@NamedQuery(name = "TipoPersonal.findAll", query = "SELECT t FROM TipoPersonal t")
public class TipoPersonal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "TPE_ID")
	private Long tpeId;

	@Column(name = "TPE_DESCRIPCION")
	private String tpeDescripcion;

	public TipoPersonal() {
	}

	public Long getTpeId() {
		return tpeId;
	}

	public void setTpeId(Long tpeId) {
		this.tpeId = tpeId;
	}

	public String getTpeDescripcion() {
		return tpeDescripcion;
	}

	public void setTpeDescripcion(String tpeDescripcion) {
		this.tpeDescripcion = tpeDescripcion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}