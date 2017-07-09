package com.scrumboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrumboard.domain.model.Project;
import com.scrumboard.repository.ProjectRepository;

@Service
public class ProjectRepoService {

	@Autowired
	private ProjectRepository<Project> repository;
	
	public void createProject(Project project) {
		repository.save(project);
	}

	public List<Project> getAllProjects() {

		return repository.findAll();
	}

	public void updateProject(Long id, Project project) {
		repository.save(project);
		
	}

	public Project findProject(Long id) {

		return repository.findById(id);
	}
} 
