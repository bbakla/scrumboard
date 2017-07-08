package com.scrumboard.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrumboard.domain.model.Backlog;
import com.scrumboard.domain.model.Project;
import com.scrumboard.repository.ProjectRepository;

@Service
public class ProjectRepoService {

	@Autowired
	private ProjectRepository<Project> repository;
	
	public void createProject(Project project) {
		Backlog backlog = new Backlog();
		project.setBacklogs(Arrays.asList(backlog));
		
		repository.save(project);
	}

	public List<Project> getAllProjects() {

		return repository.findAll();
	}
} 
