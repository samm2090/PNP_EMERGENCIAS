package pe.gob.pnp.emergencias.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import pe.gob.pnp.emergencias.model.Emergencia;
import pe.gob.pnp.emergencias.service.EmergenciaService;

@ManagedBean
@SessionScoped
public class EmergenciaManagedBean {
	@ManagedProperty(value = "#{emergenciaService}")
	private EmergenciaService emergenciaService;

	private Emergencia emergencia = new Emergencia();

	public Emergencia getEmergencia() {
		return emergencia;
	}

	public void setEmergencia(Emergencia emergencia) {
		this.emergencia = emergencia;
	}

	public EmergenciaService getEmergenciaService() {
		return emergenciaService;
	}

	public void setEmergenciaService(EmergenciaService emergenciaService) {
		this.emergenciaService = emergenciaService;
	}
	
	public String contestarLlamada(){
		
		return "registroLlamada";
	}

	public String registrarEmergencia() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringData");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();

		try {
			
			

			tx.begin();

			Query q = manager
					.createNativeQuery("EXEC USP_REGISTRAR_EMERGENCIA ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?")
					.setParameter(1, emergencia.getLlamada().getCivil().getCivDocumento()).setParameter(2, emergencia.getLlamada().getCivil().getCivNombre())
					.setParameter(3, emergencia.getLlamada().getCivil().getCivApellidoPaterno()).setParameter(4, emergencia.getLlamada().getCivil().getCivApellidoMaterno())
					.setParameter(5, emergencia.getLlamada().getCivil().getCivTelefono()).setParameter(6, emergencia.getLlamada().getCivil().getFechaRegistro())
					.setParameter(7, emergencia.getLlamada().getLlaFecha()).setParameter(8, emergencia.getLlamada().getLlaObservacion())
					.setParameter(9, emergencia.getLlamada().getLlaTelefono()).setParameter(10, emergencia.getLlamada().getTipoTerminal().getTteId())
					.setParameter(11, emergencia.getLlamada().getOperador()).setParameter(12, emergencia.getLlamada().getLlaHoraInicio())
					.setParameter(13, emergencia.getLlamada().getLlaHoraFin())
					.setParameter(14, emergencia.getNivelEmergencia().getNemId())
					.setParameter(15, emergencia.getTipoEmergencia().getTemId())
					.setParameter(16, emergencia.getDistrito().getDisId()).setParameter(17, emergencia.getEmeDir())
					.setParameter(18, emergencia.getEmeObservacion()).setParameter(19, emergencia.getEmeFecha())
					.setParameter(20, emergencia.getEmeHoraInicio()).setParameter(21, emergencia.getEmeHoraFin());
			
			q.executeUpdate();

			tx.commit();

			emergencia = new Emergencia();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		return "registroRecursosEmergencia";
	}

}
