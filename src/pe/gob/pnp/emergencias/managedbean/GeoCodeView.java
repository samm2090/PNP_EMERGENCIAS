package pe.gob.pnp.emergencias.managedbean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.map.GeocodeEvent;
import org.primefaces.event.map.ReverseGeocodeEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.GeocodeResult;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
 
@ManagedBean
public class GeoCodeView {
     
    private MapModel geoModel;
    private MapModel revGeoModel;
    private String centerGeoMap = "-12.102166, -77.032996";
    private String centerRevGeoMap = "-12.102166, -77.032996";
    private String title;
    private double lat;  
    private double lng;
    private MapModel emptyModel;
     
    @PostConstruct
    public void init() {
        geoModel = new DefaultMapModel();
        revGeoModel = new DefaultMapModel();
        emptyModel = new DefaultMapModel();
        
        LatLng coord1 = new LatLng(-12.102166, -77.032996);
        emptyModel.addOverlay(new Marker(coord1, "Emergencia"));
    }
     
    public void onGeocode(GeocodeEvent event) {
        List<GeocodeResult> results = event.getResults();
         
        if (results != null && !results.isEmpty()) {
            LatLng center = results.get(0).getLatLng();
            centerGeoMap = center.getLat() + "," + center.getLng();
             
            for (int i = 0; i < results.size(); i++) {
                GeocodeResult result = results.get(i);
                geoModel.addOverlay(new Marker(result.getLatLng(), result.getAddress()));
            }
        }
    }
    
	public void addMarker() {
        Marker marker = new Marker(new LatLng(lat, lng), title);
        emptyModel.addOverlay(marker);
          
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Added", "Lat:" + lat + ", Lng:" + lng));
    }
     
    public void onReverseGeocode(ReverseGeocodeEvent event) {
        List<String> addresses = event.getAddresses();
        LatLng coord = event.getLatlng();
         
        if (addresses != null && !addresses.isEmpty()) {
            centerRevGeoMap = coord.getLat() + "," + coord.getLng();
            revGeoModel.addOverlay(new Marker(coord, addresses.get(0)));
        }
    }
 
    public MapModel getGeoModel() {
        return geoModel;
    }
 
    public MapModel getRevGeoModel() {
        return revGeoModel;
    }
 
    public String getCenterGeoMap() {
        return centerGeoMap;
    }
 
    public String getCenterRevGeoMap() {
        return centerRevGeoMap;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public MapModel getEmptyModel() {
		return emptyModel;
	}

	public void setEmptyModel(MapModel emptyModel) {
		this.emptyModel = emptyModel;
	}

	public void setGeoModel(MapModel geoModel) {
		this.geoModel = geoModel;
	}

	public void setRevGeoModel(MapModel revGeoModel) {
		this.revGeoModel = revGeoModel;
	}

	public void setCenterGeoMap(String centerGeoMap) {
		this.centerGeoMap = centerGeoMap;
	}

	public void setCenterRevGeoMap(String centerRevGeoMap) {
		this.centerRevGeoMap = centerRevGeoMap;
	}
    
    
}