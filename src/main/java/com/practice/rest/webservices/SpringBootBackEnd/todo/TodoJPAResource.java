package com.practice.rest.webservices.SpringBootBackEnd.todo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoJPAResource {

	@Autowired
	TodoService todoService;

	@Autowired
	TodoJPARepository todoJPARepository;

	@GetMapping("/jpa/users/{username}/todos")
	public List<Todo> getTodos(@PathVariable String username) {
		System.out.println("Invoke getTodos");
		return todoJPARepository.findByUsername(username);
	}

	@GetMapping("/jpa/users/{username}/todos/{id}")
	public Todo getTodosById(@PathVariable Long id) {
		System.out.println("Invoke getTodosById");
		// FindById returns an Optional Object. Get() method has to be called to
		// get the actual output
		return todoJPARepository.findById(id).get();
	}

	@DeleteMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
		System.out.println("Invoke deleteTodo");
		Todo todo = todoJPARepository.findById(id).get();
		todoJPARepository.deleteById(id);

		// For Sending status we need to use ResponseEntity
		if (todo != null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
		System.out.println("Invoke updateTodo");
		Todo updatedTodo = todoJPARepository.save(todo);
		return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
	}

	@PostMapping("/jpa/users/{username}/todos")
	public ResponseEntity<Void> createTodo(@RequestBody Todo todo, @PathVariable String username) {
		System.out.println("Invoke createTodo");
		todo.setUsername(username);
		Todo createdTodo = todoJPARepository.save(todo);

		// Ideal response for create request should be created resource location
		// Hence getting the curent URI and appending id to it.
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId())
				.toUri();

		// Return the status as created and respond with the created URI
		return ResponseEntity.created(uri).build();
	}

}
