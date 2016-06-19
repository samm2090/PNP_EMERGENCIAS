package com.gob.pe.pnp.emergencia.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import pe.gob.pnp.emergencias.model.Civil;
import pe.gob.pnp.emergencias.model.Rol;
import pe.gob.pnp.emergencias.model.TipoEmergencia;
import pe.gob.pnp.emergencias.model.Usuario;

public class TestEmergencias {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringData");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction tx = manager.getTransaction();

	@Test
	public void testInsertaUsuarioRol() {

		tx.begin();

		try {
			Usuario usuario1 = new Usuario();
			usuario1.setUsuNombre("Maria Cristina");
			usuario1.setUsuClave("123456");
			usuario1.setEstadoRegistro(true);
			manager.persist(usuario1);

			Rol rol1 = new Rol();
			rol1.setRolDescripcion("ADMIN");
			rol1.setEstadoRegistro(true);
			usuario1.setRol(rol1);

			Usuario usuario2 = new Usuario();
			usuario2.setUsuNombre("Cristian Marcas");
			usuario2.setUsuClave("123456");
			usuario2.setEstadoRegistro(true);
			manager.persist(usuario2);

			Rol rol2 = new Rol();
			rol2.setRolDescripcion("POLICIA");
			rol2.setEstadoRegistro(true);
			usuario2.setRol(rol2);

			Usuario usuario3 = new Usuario();
			usuario3.setUsuNombre("Sergio Muroy");
			usuario3.setUsuClave("123456");
			usuario3.setEstadoRegistro(true);
			manager.persist(usuario3);

			Rol rol3 = new Rol();
			rol3.setRolDescripcion("OPERADOR");
			rol3.setEstadoRegistro(true);
			usuario3.setRol(rol3);

			assertNull(usuario1.getUsuId());
			assertNull(rol1.getRolId());
			assertNull(usuario2.getUsuId());
			assertNull(rol2.getRolId());
			assertNull(usuario3.getUsuId());
			assertNull(rol3.getRolId());

			manager.flush();

			assertNotNull(usuario1.getUsuNombre());
			assertNotNull(usuario2.getUsuClave());
			assertNotNull(rol1.getRolDescripcion());
			assertTrue(rol2.getRolDescripcion() != "");

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		tx.commit();
	}

	@Test
	public void testRegistrarTipoEmergencia() {
		tx.begin();

		try {
			TipoEmergencia tipo = new TipoEmergencia();
			tipo.setTemDescripcion("Pandillaje'");
			manager.persist(tipo);

			assertNotNull(tipo.getTemDescripcion());
			assertTrue(tipo.getTemDescripcion() != "");

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		tx.commit();
	}

	@Test
	public void testInsertarCivil() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpringData");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		boolean validacion = false;
		tx.begin();
		try {
			Civil civil = new Civil();
			civil.setCivNombre("Prueba1");
			civil.setCivApellidoPaterno("Zambrano");
			civil.setCivApellidoMaterno("Suarez");
			civil.setCivTelefono("99999999");
			civil.setCivDocumento("463dd");
			civil.setEstadoRegistro(true);
			civil.setFechaRegistro(new Date());

			manager.persist(civil);
			validacion = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		assertTrue(validacion);
	}

}
