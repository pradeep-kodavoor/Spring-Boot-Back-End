package com.practice.rest.webservices.SpringBoot.basicAuth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class BasicAuthConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("Overridng Spring Security Configuration!!");
		http
			.csrf().disable() // Disable CSRF token
			.authorizeRequests()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll() //Any Request with OPTIONS permit all
				.anyRequest().authenticated() //Rest of the request authorise
				.and()
				// .formLogin().and()
				.httpBasic();
	}

}
