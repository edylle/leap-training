package com.vanhack.leap.javatraining;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordTest {

	public static void main(String[] args) {

		System.out.println(new BCryptPasswordEncoder().encode("1234"));

	}

}
