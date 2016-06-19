package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "TIPO_EMERGENCIA")
public class TipoEmergencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "TEM_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long temId;

	@Column(name = "TEM_DESCRIPCION")
	private String temDescripcion;

	// one to many emergencia
	@OneToMany(mappedBy = "tipoEmergencia", fetch = FetchType.EAGER)
	private List<Emergencia> emergencias;

	public TipoEmergencia() {
	}

	public Long getTemId() {
		return temId;
	}

	public void setTemId(Long temId) {
		this.temId = temId;
	}

	public String getTemDescripcion() {
		return temDescripcion;
	}

	public void setTemDescripcion(String temDescripcion) {
		this.temDescripcion = temDescripcion;
	}

	public List<Emergencia> getEmergencias() {
		return emergencias;
	}

	public void setEmergencias(List<Emergencia> emergencias) {
		this.emergencias = emergencias;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}