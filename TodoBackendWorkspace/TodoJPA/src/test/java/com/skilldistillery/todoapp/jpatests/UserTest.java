package com.skilldistillery.todoapp.jpatests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.todoapp.entities.User;

class UserTest {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private User user;

	@BeforeEach
	void setUp() {
		emf = Persistence.createEntityManagerFactory("todo");
		em = emf.createEntityManager();
		user = em.find(User.class, 1);

	}

	@AfterEach
	void tearDown() {
		em.close();
		emf.close();
	}

	@Test
	void test_user_has_information() {
		assertEquals("shaun", user.getUsername());
	}
	
	@Test
	void test_user_has_todos() {
		assertEquals(3, user.getTodos().size());
	}

}
