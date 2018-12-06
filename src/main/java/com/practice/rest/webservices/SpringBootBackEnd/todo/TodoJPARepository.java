package com.practice.rest.webservices.SpringBootBackEnd.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoJPARepository extends JpaRepository<Todo, Long> {

	// Method can be created for any fields for searching based on Column Names
	// Syntax findBy<field_name>
	public List<Todo> findByUsername(String username);

}
