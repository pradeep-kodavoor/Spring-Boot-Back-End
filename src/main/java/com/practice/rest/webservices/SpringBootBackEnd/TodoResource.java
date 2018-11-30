package com.practice.rest.webservices.SpringBootBackEnd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoResource {

	@Autowired
	TodoService todoService;

	@GetMapping("/todos")
	public List<Todo> getTodos() {
		return todoService.findAll();
	}

	@DeleteMapping("/delete-todo/{id}")
	public Todo deleteTodo(@PathVariable int id) {
		return todoService.deleteTodo(id);
	}

	@GetMapping("/todos/{id}")
	public Todo getTodosById(@PathVariable int id) {
		return todoService.findTodoById(id);
	}

	@PutMapping("update-todo/{todo}")
	public void updateTodo(Todo todo) {
		todoService.updateTodo(todo);
	}
}
