package pe.gob.pnp.emergencias.managedbean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.google.common.collect.Lists;

import pe.gob.pnp.emergencias.model.Emergencia;
import pe.gob.pnp.emergencias.model.EquipoEmergencia;
import pe.gob.pnp.emergencias.model.EstadoParte;
import pe.gob.pnp.emergencias.model.Parte;
import pe.gob.pnp.emergencias.service.ParteService;

@ManagedBean
@SessionScoped
public class ParteManagedBean {
	@ManagedProperty(value = "#{parteService}")
	private ParteService parteService;

	private Parte parte = new Parte();
	private Emergencia emergencia = new Emergencia();
	private EstadoParte estadoParte = new EstadoParte();
	private EquipoEmergencia equipoEmergencia = new EquipoEmergencia();

	public ParteService getParteService() {
		return parteService;
	}

	public void setParteService(ParteService parteService) {
		this.parteService = parteService;
	}

	public Parte getParte() {
		return parte;
	}

	public void setParte(Parte parte) {
		this.parte = parte;
	}

	public Emergencia getEmergencia() {
		return emergencia;
	}

	public void setEmergencia(Emergencia emergencia) {
		this.emergencia = emergencia;
	}

	public EstadoParte getEstadoParte() {
		return estadoParte;
	}

	public void setEstadoParte(EstadoParte estadoParte) {
		this.estadoParte = estadoParte;
	}

	public EquipoEmergencia getEquipoEmergencia() {
		return equipoEmergencia;
	}

	public void setEquipoEmergencia(EquipoEmergencia equipoEmergencia) {
		this.equipoEmergencia = equipoEmergencia;
	}

	public String registrarParte() {
		FacesContext context = FacesContext.getCurrentInstance();
		@SuppressWarnings("rawtypes")
		Map params = context.getExternalContext().getSessionMap();
		EquipoEmergencia equipoEmergencia1 = (EquipoEmergencia) params.get("equipoLogin");

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringData");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();

		try {
			tx.begin();

			if (equipoEmergencia1 == null) {
				return "emergenciaNoEncontrada?faces-redirect=true";
			} else {
				Query q = manager.createNativeQuery("EXEC sp_registrarParte ?,?,?,?")
						.setParameter(1, equipoEmergencia1.getEmergencia().getEmeId())
						.setParameter(2, estadoParte.getEpaId())
						.setParameter(3, equipoEmergencia1.getRecurso().getRecId())
						.setParameter(4, parte.getParObservacion());

				q.executeUpdate();

				tx.commit();

				equipoEmergencia = new EquipoEmergencia();
				estadoParte = new EstadoParte();
				parte = new Parte();
				emergencia = new Emergencia();
			}

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		return "emergenciaNoEncontrada?faces-redirect=true";
	}

	public ArrayList<Parte> partesExistosas()
	{
		return Lists.newArrayList(parteService.getParteRepository().partesExitosas(new Long(1)));
	}
	
}
