package com.practice.rest.webservices.SpringBootBackEnd.basicAuth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BasicAuthenticationController {

	@GetMapping("/basicauth")
	public AuthenticationBean helloWorldBean() {
		System.out.println("Invoke Basic Auth Service..");
		return new AuthenticationBean("You are authenticated!");
	}
}
