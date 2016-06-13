package pe.gob.pnp.emergencias.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pe.gob.pnp.emergencias.service.PersonaService;

@ManagedBean
@SessionScoped
public class PersonaManagedBean {
	@ManagedProperty(value = "#{personaService}")
	private PersonaService personaService;

	public PersonaService getPersonaService() {
		return personaService;
	}

	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}
	
}
