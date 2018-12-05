package com.practice.rest.webservices.SpringBootBackEnd;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderTest {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		for (int i = 0; i < 10; i++) {
			String encodedString = encoder.encode("dummy");
			System.out.println(encodedString);
		}

	}

}
