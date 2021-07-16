package com.example.todo;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class TodoRepositoryTests {
	@Autowired
	private TodoRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateTodo() throws ParseException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Todo todo = new Todo();
		todo.setTitle("Spring Boot");
		todo.setDescription("Spring Boot Tutorial. Easier and faster to grasp.");
		todo.setLink("https://www.javatpoint.com/spring-boot-tutorial");
		todo.setTargetDate(formatter.parse("04/08/2021"));
		todo.setEmail("vikramnpatel5@gmail.com");
		Todo savedTodo = repo.save(todo);
		Todo existTodo = entityManager.find(Todo.class, savedTodo.getId());
		assertThat(existTodo.getEmail()).isEqualTo(todo.getEmail());
		
	}
	
	@Test
	public void testFindTodosByEmail() {
		String email="vikramnpatel5@gmail.com";
		List<Todo> todo = repo.findByEmail(email);
		assertThat(todo).isNotNull();
	}
}