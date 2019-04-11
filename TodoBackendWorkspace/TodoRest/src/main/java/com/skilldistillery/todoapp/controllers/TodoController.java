package com.skilldistillery.todoapp.controllers;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.todoapp.entities.Todo;
import com.skilldistillery.todoapp.services.TodoService;
import com.skilldistillery.todoapp.services.TodoServiceImpl;

@RestController
@RequestMapping(path = "api")
@CrossOrigin({ "*", "http://localhost:4202" })
public class TodoController {

	String username = "shaun";
	
	@Autowired
	private TodoService todoServ = new TodoServiceImpl();

	// GET todos
	@GetMapping("todos")
	public Set<Todo> index(HttpServletRequest req, HttpServletResponse res) {
		return todoServ.index(username);
	}

	// GET todos/{tid}
	@GetMapping("todos/{tid}")
	public Todo show(HttpServletRequest req, HttpServletResponse res, @PathVariable("tid") int tid) {
		return todoServ.show(username, tid);
	}

//	// POST todos
//	public Todo create(HttpServletRequest req, HttpServletResponse res, Todo todo) {
//	}
//
//	// PUT todos/{tid}
//	public Todo update(HttpServletRequest req, HttpServletResponse res, int tid, Todo todo) {
//	}
//
//	// DELETE todos/{tid}
//	public void destroy(HttpServletRequest req, HttpServletResponse res, int tid) {
//	}

}
