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
import com.scrumboard.domain.backlog.Project;
import com.scrumboard.domain.task.Task;

import static com.scrumboard.helper.SampleDataCreator.*;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {JpaTestConfiguration.class})
public class ProjectRepositoryTest extends AbstractTransactionalTestNGSpringContextTests {

	@Autowired
	private ProjectRepository<Project> repository;
	
	@Autowired
	private ScrumBoardRepository<Task> taskRepository;
	
	@BeforeMethod
	public void deleteRepository() {
		repository.deleteAll();
		taskRepository.deleteAll();
	}
	
	@Test
	public void saveAProjectToTheDatabase() {
		Project project = createProject();
		repository.save(project);
		
		List<Project> tasks = repository.findAll();
		assertEquals(1, tasks.size());
		
		Project taskInDatabase = repository.findById(project.getId());
		assertNotNull(taskInDatabase);
	}

	
}
