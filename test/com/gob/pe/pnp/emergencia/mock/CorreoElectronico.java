package com.gob.pe.pnp.emergencia.mock;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CorreoElectronico {

	public String validacionCorreo(String email) {

		String resultado = "";

		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		Matcher matcher = pattern.matcher(email);

		if (matcher.find() == true) {
			resultado = "Valido";
		} else {
			resultado = "Invalido";
		}

		return resultado;
	}

	public String validarMail(String email) {

		char cadenaEmail = email.charAt(0);
		int posicion1 = 0;
		int posicion2 = 0;
		int a1 = 0;
		int a2 = 0;
		int a3 = 0;
		int x = 0;
		String resultado = "";
		String cadena1 = "";
		String cadena2 = "";
		String cadena3 = "";

		if (cadenaEmail != '@' && cadenaEmail != '.') {

			for (int i = 1; i < email.length(); i++) {
				if (email.charAt(i) == '@') {
					posicion1 = i;
				}
			}
			for (int i = 1; i < email.length(); i++) {
				if (email.charAt(i) == '.') {
					posicion2 = i;
				}
			}

			cadena1 = email.substring(0, posicion1);
			cadena2 = email.substring(posicion1 + 1, posicion2);
			cadena3 = email.substring(posicion2 + 1, email.length());

			for (int i = 0; i < cadena1.length(); i++) {
				System.out.println("carcater " + cadena1);
				a1 = cadena1.codePointAt(i);//
				if ((a1 > 47 && a1 < 58) || (a1 > 64 && a1 < 91) || (a1 > 96 && a1 < 123) || a1 == 46) {
					x++;
				}
			}
			System.out.println("1 " + cadena2);
			for (int i = 0; i < cadena2.length(); i++) {
				a2 = cadena2.codePointAt(i);
				System.out.println("carcater " + a2);
				if ((a2 > 47 && a2 < 58) || (a2 > 64 && a2 < 91) || (a2 > 96 && a2 < 123)) {
					x++;
				}
			}

			for (int i = 0; i < cadena3.length(); i++) {
				a3 = cadena3.codePointAt(i);
				if ((a3 > 47 && a3 < 58) || (a3 > 64 && a3 < 91) || (a3 > 96 && a3 < 123)) {
					x++;
				}
			}
			System.out.println("xxx " + x + "    " + (email.length() - 2));
			if (x == email.length() - 2) {
				if (posicion1 != 0 && posicion2 != 0 && (posicion1 + 2) < posicion2) {

					if (email.length() - 1 >= (posicion2 + 2)) {
							resultado = "Valido";
					} else {
						resultado = "Invalido";
					}
				} else {
					resultado = "Invalido";
				}
			} else {
				resultado = "Invalido";
			}
		} else {
			resultado = "Invalido";
		}
		return resultado;
	}

}
