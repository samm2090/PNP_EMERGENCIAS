package pe.gob.pnp.emergencias.managedbean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import pe.gob.pnp.emergencias.model.EquipoEmergencia;

@ManagedBean
public class MarkersView implements Serializable {

	private static final long serialVersionUID = 1L;
	private MapModel simpleModel;
	private String centerGeoMap;

	FacesContext context = FacesContext.getCurrentInstance();
	@SuppressWarnings("rawtypes")
	Map params = context.getExternalContext().getSessionMap();
	EquipoEmergencia equipoEmergencia1 = (EquipoEmergencia) params.get("equipoLogin");

	@PostConstruct
	public void init() {
		simpleModel = new DefaultMapModel();
		marcarLugarEmergencia();
		centrarLugarEmergencia();
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

}