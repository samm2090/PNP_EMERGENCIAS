package com.gob.pe.pnp.emergencia.test;

import java.util.Random;

import org.junit.Test;

public class TestLlamada {

	@Test
	public void test() {
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

}
