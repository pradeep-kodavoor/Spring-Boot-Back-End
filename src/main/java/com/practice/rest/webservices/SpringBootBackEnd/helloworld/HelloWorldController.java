package com.practice.rest.webservices.SpringBootBackEnd.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HelloWorldController {

	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public String getMessage(@RequestParam String name) {
		System.out.println(name);
		return "Hello " + name;
	}

	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World!";
	}

	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean() {

		// throw new RuntimeException("Database Server is down! Please contact
		// support team");
		return new HelloWorldBean("Hello World");
	}

	@GetMapping("/hello-world-bean/{name}")
	public HelloWorldBean helloWorldBeanWithPathVariable(@PathVariable String name) {
		return new HelloWorldBean("Hello " + name);
	}

}
