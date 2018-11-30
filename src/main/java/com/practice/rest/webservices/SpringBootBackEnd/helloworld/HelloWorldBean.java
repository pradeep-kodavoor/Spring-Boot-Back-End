package com.practice.rest.webservices.SpringBootBackEnd.helloworld;

public class HelloWorldBean {

	public HelloWorldBean(String message) {
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
