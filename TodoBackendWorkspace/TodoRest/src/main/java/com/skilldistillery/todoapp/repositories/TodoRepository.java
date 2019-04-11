package com.skilldistillery.todoapp.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.skilldistillery.todoapp.entities.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
	
	Set<Todo> findByUserId(int userId);
	
	@Query("SELECT * FROM todo where user_id = 1 AND id = 1;")
	Todo findTodoByUserIdAndTodoId(int userId, int todoId);

}
