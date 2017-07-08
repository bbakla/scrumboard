package com.scrumboard.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;

import com.scrumboard.config.JpaTestConfiguration;
import com.scrumboard.domain.task.Task;

import static com.scrumboard.helper.SampleDataCreator.*;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {JpaTestConfiguration.class})
public class ScrumboardRepositoryTest extends AbstractTransactionalTestNGSpringContextTests {

	@Autowired
	private ScrumBoardRepository<Task> repository;
	
	@BeforeMethod
	public void deleteRepository() {
		repository.deleteAll();
	}
	
	@Test
	public void saveATaskToTheDatabase() {
		Task task = createTask();
		repository.save(task);
		
		List<Task> tasks = repository.findAll();
		assertEquals(1, tasks.size());
		
		Task taskInDatabase = repository.findById(task.getId());
		assertNotNull(taskInDatabase);
	}
}
