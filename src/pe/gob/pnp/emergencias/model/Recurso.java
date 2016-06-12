package pe.gob.pnp.emergencias.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="RECURSO")
@NamedQuery(name="Recurso.findAll", query="SELECT r FROM Recurso r")
public class Recurso {
	
	@Id
	@Column(name="REC_ID")
	private int recId;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "PER_ID")
	private Persona persona;
	
	@ManyToOne
	@JoinColumn(name = "GRE_ID")
	private GradoRecurso gradoRecurso;
	
	@ManyToOne
	@JoinColumn(name = "TUR_ID")
	private Turno turno;
	
	@ManyToOne
	@JoinColumn(name = "COM_ID")
	private Comisaria comisaria;
	
	@Column(name = "ESTADO_REGISTRO")
	private boolean estadoRegistro;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name = "FECHA_CREACION")
	private Date fechaCreacion;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name = "FECHA_MODIFICACION")
	private Date fechaMoficacion;
}
