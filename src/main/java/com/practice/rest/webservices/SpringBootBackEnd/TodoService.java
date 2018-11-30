package com.practice.rest.webservices.SpringBootBackEnd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	static List<Todo> todos = new ArrayList<>();

	static int id = 0;

	static {
		todos.add(new Todo(++id, "Learn Core JAVA", new Date(), false));
		todos.add(new Todo(++id, "Learn J2EE", new Date(), false));
		todos.add(new Todo(++id, "Learn Spring", new Date(), false));
		todos.add(new Todo(++id, "Learn Hibernate", new Date(), false));
		todos.add(new Todo(++id, "Learn Spring Boot", new Date(), false));
	}

	public List<Todo> findAll() {
		Collections.sort(todos, (var1, var2) -> Integer.compare(var1.getId(), var2.getId()));
		return todos;
	}

	public Todo deleteById(int id) {
		Todo todo = findById(id);
		todos.remove(todo);
		return todo;
	}

	public Todo findById(int id) {
		for (Todo todo : todos) {
			if (todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}

	public Todo update(Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
		return todo;
	}

	public Todo save(Todo todo) {
		todo.setId(++id);
		todos.add(todo);
		return todo;
	}

}
