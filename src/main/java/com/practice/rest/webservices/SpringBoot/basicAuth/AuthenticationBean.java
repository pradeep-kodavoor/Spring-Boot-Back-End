package com.practice.rest.webservices.SpringBoot.basicAuth;

public class AuthenticationBean {

	public AuthenticationBean(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private String message;

	@Override
	public String toString() {
		return "HelloWorld [message=" + message + "]";
	}

}
