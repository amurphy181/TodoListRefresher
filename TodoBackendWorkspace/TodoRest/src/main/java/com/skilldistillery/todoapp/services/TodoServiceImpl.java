package com.skilldistillery.todoapp.services;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.todoapp.entities.Todo;
import com.skilldistillery.todoapp.entities.User;
import com.skilldistillery.todoapp.repositories.TodoRepository;
import com.skilldistillery.todoapp.repositories.UserRepository;

@Service
public class TodoServiceImpl implements TodoService {
	
	@Autowired
	private TodoRepository todoRepo;
	
	@Autowired
	private UserRepository userRepo;
	

	@Override
	public Set<Todo> index(String username) {
		User user = userRepo.findByUsername(username);
		System.out.println(user.getUsername());
		
		// TODO Auto-generated method stub
		return todoRepo.findByUserId(user.getId());
	}

	@Override
	public Todo show(String username, int tid) {
		User user = userRepo.findByUsername(username);
		System.out.println(user.getId());
		Optional<Todo> singleTodo = todoRepo.findById(tid);
		Todo returnedTodo = singleTodo.get();
		return returnedTodo;
	}

	@Override
	public Todo create(String username, Todo todo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Todo update(String username, int tid, Todo todo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean destroy(String username, int tid) {
		// TODO Auto-generated method stub
		return false;
	}

}
