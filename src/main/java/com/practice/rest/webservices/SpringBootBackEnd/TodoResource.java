package com.practice.rest.webservices.SpringBootBackEnd;

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
public class TodoResource {

	@Autowired
	TodoService todoService;

	@GetMapping("/users/{username}/todos")
	public List<Todo> getTodos() {
		System.out.println("Invoke getTodos");
		return todoService.findAll();
	}

	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable int id) {
		System.out.println("Invoke deleteTodo");
		Todo todo = todoService.deleteById(id);

		// For Sending status we need to ResponseEntity
		if (todo != null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/users/{username}/todos/{id}")
	public Todo getTodosById(@PathVariable int id) {
		System.out.println("Invoke getTodosById");
		return todoService.findById(id);
	}

	@PutMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable int id, @RequestBody Todo todo) {
		System.out.println("Invoke updateTodo");
		Todo updatedTodo = todoService.update(todo);

		return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
	}

	@PostMapping("/users/{username}/todos")
	public ResponseEntity<Void> createTodo(@RequestBody Todo todo) {
		System.out.println("Invoke createTodo");
		Todo createdTodo = todoService.save(todo);

		// Ideal response for create request should be created resource location
		// Hence getting the cuurent URI and appending id to it.
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId())
				.toUri();

		// Return the status as created and respond with the created URI
		return ResponseEntity.created(uri).build();
	}

}
