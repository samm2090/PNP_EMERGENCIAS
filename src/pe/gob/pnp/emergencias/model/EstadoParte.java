package pe.gob.pnp.emergencias.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ESTADO_PARTE")
public class EstadoParte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "EPA_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long epaId;

	@Column(name = "EPA_DESCRIPCION")
	private String epaDescripcion;

	// bi-directional many-to-one association to Parte
	@OneToMany(mappedBy = "estadoParte", fetch = FetchType.EAGER)
	private List<Parte> partes;

	public EstadoParte() {
	}

	public Long getEpaId() {
		return epaId;
	}

	public void setEpaId(Long epaId) {
		this.epaId = epaId;
	}

	public String getEpaDescripcion() {
		return epaDescripcion;
	}

	public void setEpaDescripcion(String epaDescripcion) {
		this.epaDescripcion = epaDescripcion;
	}

	public List<Parte> getPartes() {
		return partes;
	}

	public void setPartes(List<Parte> partes) {
		this.partes = partes;
	}

}