package com.scrumboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrumboard.domain.model.Task;
import com.scrumboard.repository.TaskRepository;

@Service
public class ProjectTaskService {
	
	@Autowired
	private TaskRepository<Task> taskRepository;
	
	public void updateTask(Task task) {
		taskRepository.save(task);	}

}
