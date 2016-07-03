package pe.gob.pnp.emergencias.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.google.common.collect.Lists;

import pe.gob.pnp.emergencias.model.Persona;
import pe.gob.pnp.emergencias.model.Rol;
import pe.gob.pnp.emergencias.model.TipoPersonal;
import pe.gob.pnp.emergencias.model.Usuario;
import pe.gob.pnp.emergencias.service.PersonaService;
import pe.gob.pnp.emergencias.service.RolService;
import pe.gob.pnp.emergencias.service.TipoPersonalService;
import pe.gob.pnp.emergencias.service.UsuarioService;

@ManagedBean
@SessionScoped
public class UsuarioManagedBean {

	@ManagedProperty(value = "#{usuarioService}")
	private UsuarioService usuarioService;

	@ManagedProperty(value = "#{rolService}")
	private RolService rolService;

	@ManagedProperty(value = "#{personaService}")
	private PersonaService personaService;

	@ManagedProperty(value = "#{tipoPersonalService}")
	private TipoPersonalService tipoPersonalService;

	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private List<Rol> roles = new ArrayList<Rol>();
	private List<TipoPersonal> tipoPersonales = new ArrayList<TipoPersonal>();
	private List<Persona> personas = new ArrayList<Persona>();

	private Usuario userAutentic = new Usuario();
	private Usuario usuario = new Usuario();
	private Persona persona = new Persona();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUserAutentic() {
		return userAutentic;
	}

	public void setUserAutentic(Usuario userAutentic) {
		this.userAutentic = userAutentic;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public RolService getRolService() {
		return rolService;
	}

	public void setRolService(RolService rolService) {
		this.rolService = rolService;
	}

	public List<Rol> getRoles() {
		roles = Lists.newArrayList(rolService.getRolRepository().findAll());
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public PersonaService getPersonaService() {
		return personaService;
	}

	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public TipoPersonalService getTipoPersonalService() {
		return tipoPersonalService;
	}

	public void setTipoPersonalService(TipoPersonalService tipoPersonalService) {
		this.tipoPersonalService = tipoPersonalService;
	}

	public List<TipoPersonal> getTipoPersonales() {
		tipoPersonales = Lists.newArrayList(tipoPersonalService.getTipoPersonalRepository().findAll());
		return tipoPersonales;
	}

	public void setTipoPersonales(List<TipoPersonal> tipoPersonales) {
		this.tipoPersonales = tipoPersonales;
	}

}
