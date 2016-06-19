package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "TIPO_PERSONAL")
public class TipoPersonal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "TPE_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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