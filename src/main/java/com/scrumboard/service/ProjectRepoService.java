package com.scrumboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrumboard.domain.model.Backlog;
import com.scrumboard.domain.model.Project;
import com.scrumboard.domain.model.Task;
import com.scrumboard.repository.ProjectRepository;
import com.scrumboard.repository.TaskRepository;

@Service
public class ProjectRepoService {

	@Autowired
	private ProjectRepository<Project> repository;
	
	@Autowired
	private TaskRepository<Task> taskRepository;
	
	public void createProject(Project project) {
		repository.save(project);
	}

	public List<Project> getAllProjects() {

		return repository.findAll();
	}

	public void updateProject(Long id, Project project) {
		repository.saveAndFlush(project);
		
	}

	public Project findProject(Long id) {

		return repository.findById(id);
	}
	
	public Task saveTask(Task task) {
		return taskRepository.save(task);
	}

	public Backlog findBacklog(Long projectId, Long backlogId) {

		return repository.findById(projectId)
				  .getBacklogs()
				  .stream()
				  .filter(backlog -> backlog.getId() == backlogId)
				  .findAny().get();
				  
	}

	public Task findTaskById(Long taskId) {
		return taskRepository.findById(taskId);
	}
} 
