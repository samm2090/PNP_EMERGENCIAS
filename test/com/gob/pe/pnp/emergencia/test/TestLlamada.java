package com.gob.pe.pnp.emergencia.test;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

import com.gob.pe.pnp.emergencia.mock.CorreoElectronico;


public class TestLlamada {

	@Test
	public void testValidarNumeroAleatorio() {
		Random random = new Random();

		int terminalAleatorio = random.nextInt((2 - 1) + 1) + 1;
		String numero = "";
		if (terminalAleatorio == 1) {
			int numeroFijo = random.nextInt((9999999 - 1000000) + 1) + 1000000;

			numero = "01" + numeroFijo;
		} else {
			int numeroCelular = random.nextInt((99999999 - 10000000) + 1) + 10000000;
			numero = "9" + numeroCelular;
		}
		
		System.out.println(numero);
	}	
	
	@Test
	public void testValidarCorreoElectronico() {
		
		CorreoElectronico correo = new CorreoElectronico();
		assertEquals(correo.validarMail("antonny93@gmail.com"),"Valido");
		
	}
	
	
	
	
	
	
	
}
