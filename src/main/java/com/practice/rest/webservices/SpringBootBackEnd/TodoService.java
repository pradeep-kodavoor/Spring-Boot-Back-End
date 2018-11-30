package com.practice.rest.webservices.SpringBootBackEnd;

import java.util.ArrayList;
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
		return todos;
	}

	public Todo deleteTodo(int id) {
		Todo todo = findTodoById(id);
		todos.remove(todo);
		return todo;
	}

	public Todo findTodoById(int id) {
		for (Todo todo : todos) {
			if (todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}

	public void updateTodo(Todo todo) {
		deleteTodo(todo.getId());
		todos.add(todo);
	}

}
