package pe.gob.pnp.emergencias.managedbean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import com.google.common.collect.Lists;

import pe.gob.pnp.emergencias.model.Emergencia;
import pe.gob.pnp.emergencias.model.EquipoEmergencia;
import pe.gob.pnp.emergencias.service.EmergenciaService;
import pe.gob.pnp.emergencias.service.EstadoParteService;

@ManagedBean
public class MarkersView implements Serializable {

	private static final long serialVersionUID = 1L;
	private MapModel simpleModel;
	private MapModel todosModel;
	private String centerGeoMap;

	@ManagedProperty(value = "#{emergenciaService}")
	private EmergenciaService emergenciaService;

	FacesContext context = FacesContext.getCurrentInstance();
	@SuppressWarnings("rawtypes")
	Map params = context.getExternalContext().getSessionMap();
	EquipoEmergencia equipoEmergencia1 = (EquipoEmergencia) params.get("equipoLogin");

	@PostConstruct
	public void init() {
		simpleModel = new DefaultMapModel();
		todosModel = new DefaultMapModel();
		marcarLugarEmergencia();
		centrarLugarEmergencia();

	}

	public EmergenciaService getEmergenciaService() {
		return emergenciaService;
	}

	public void setEmergenciaService(EmergenciaService emergenciaService) {
		this.emergenciaService = emergenciaService;
	}

	public MapModel getTodosModel() {
		return todosModel;
	}

	public void setTodosModel(MapModel todosModel) {
		this.todosModel = todosModel;
	}

	public MapModel getSimpleModel() {
		return simpleModel;
	}

	public String getCenterGeoMap() {
		return centerGeoMap;
	}

	public void setCenterGeoMap(String centerGeoMap) {
		this.centerGeoMap = centerGeoMap;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setSimpleModel(MapModel simpleModel) {
		this.simpleModel = simpleModel;
	}

	public void marcarLugarEmergencia() {
		BigDecimal bdLatitud = equipoEmergencia1.getEmergencia().getLatitud();
		double latitud = bdLatitud.doubleValue();

		BigDecimal bdLongitud = equipoEmergencia1.getEmergencia().getLongitud();
		double longitud = bdLongitud.doubleValue();

		LatLng coord3 = new LatLng(latitud, longitud);

		simpleModel.addOverlay(new Marker(coord3, equipoEmergencia1.getEmergencia().getEmeDir() + " - "
				+ equipoEmergencia1.getEmergencia().getDistrito().getDisDescripcion()));
	}

	public void centrarLugarEmergencia() {
		BigDecimal lat = new BigDecimal(equipoEmergencia1.getEmergencia().getLatitud().toString());
		String latitudCenter = String.valueOf(lat.doubleValue());

		BigDecimal lon = new BigDecimal(equipoEmergencia1.getEmergencia().getLongitud().toString());
		String longitudCenter = String.valueOf(lon.doubleValue());
		centerGeoMap = latitudCenter + "," + longitudCenter;
	}

	public void marcarTodos() {
		BigDecimal latitud, longitud;
		ArrayList<Emergencia> lista = Lists.newArrayList(emergenciaService.getEmergenciaRepository().findAll());
		for (int i = 0; i < lista.size(); i++) {
			latitud = new BigDecimal(lista.get(i).getLatitud().toString());
			double lat = latitud.doubleValue();
			longitud = new BigDecimal(lista.get(i).getLongitud().toString());
			double longi = longitud.doubleValue();

			LatLng coord3 = new LatLng(lat, longi);

			todosModel.addOverlay(new Marker(coord3, lista.get(i).getEmeObservacion()));

		}

	}

}