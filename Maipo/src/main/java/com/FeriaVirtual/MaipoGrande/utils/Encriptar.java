package com.FeriaVirtual.MaipoGrande.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encriptar {

	public static void main(String ...args) {
		var password = "123";
		System.out.println("password: "+password);
		System.out.println("Resultado:  "+encriptarClave(password));
	}
	
	public static String encriptarClave(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}
}
