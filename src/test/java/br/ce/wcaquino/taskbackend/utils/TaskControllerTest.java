package br.ce.wcaquino.taskbackend.utils;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.ce.wcaquino.taskbackend.controller.TaskController;
import br.ce.wcaquino.taskbackend.model.Task;
import br.ce.wcaquino.taskbackend.repo.TaskRepo;

public class TaskControllerTest {

	@Mock
	public TaskRepo taskRepo;
	
	@InjectMocks
	public TaskController controller;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void tarefaSalvaSucesso() throws ValidationException {
		Task todo = new Task();
		todo.setDueDate(LocalDate.now());
		todo.setTask("Novo teste com data no passado");
		controller.save(todo);

	}

	@Test
	public void semDescricaoErro() throws ValidationException {
		Task todo = new Task();
		todo.setDueDate(LocalDate.now());
		
		try {
			controller.save(todo);
		} catch (Exception e) {
			// TODO: handle exception
			assertEquals("Fill the task description", e.getMessage());
		}

	}

	@Test
	public void semDataErro() throws ValidationException {
		Task todo = new Task();
		todo.setTask("Descricao teste");
		try {
			controller.save(todo);
		} catch (Exception e) {
			assertEquals("Fill the due date", e.getMessage());
		}
	}

	@Test
	public void dataNoPassadoErro() {
		Task todo = new Task();
		todo.setDueDate(LocalDate.of(2021, 1, 19));
		todo.setTask("Novo teste com data no passado");
		
		try {
			controller.save(todo);
		} catch (Exception e) {
			assertEquals("Due date must not be in past", e.getMessage());
		}

	}

}
