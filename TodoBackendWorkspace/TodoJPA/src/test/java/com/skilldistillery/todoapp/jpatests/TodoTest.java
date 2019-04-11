package com.skilldistillery.todoapp.jpatests;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.todoapp.entities.Todo;

class TodoTest {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private Todo todo;

	@BeforeEach
	void setUp() {
		emf = Persistence.createEntityManagerFactory("todo");
		em = emf.createEntityManager();
		todo = em.find(Todo.class, 1);

	}

	@AfterEach
	void tearDown() {
		em.close();
		emf.close();
	}

	@Test
	void test_todo_exists_in_db() {
		assertEquals("Go round Mum's", todo.getTask());
	}
	
	@Test
	void test_todo_has_user() {
		assertEquals("shaun", todo.getUser().getUsername());
	}

}
