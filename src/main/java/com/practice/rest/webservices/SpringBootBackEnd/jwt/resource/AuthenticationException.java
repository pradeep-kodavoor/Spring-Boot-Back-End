package com.practice.rest.webservices.SpringBootBackEnd.jwt.resource;

public class AuthenticationException extends RuntimeException {

	private static final long serialVersionUID = -7390485641401101874L;

	public AuthenticationException(String message, Throwable cause) {
		super(message, cause);
	}
}
