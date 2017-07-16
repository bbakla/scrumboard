package com.scrumboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrumboard.domain.model.Task;
import com.scrumboard.repository.TaskRepository;

@Service
public class TaskRepoService {

	@Autowired
	private TaskRepository<Task> taskRepository;
	
	public Task findTaskById(Long taskId) {
		
		return taskRepository.findById(taskId);
	}
}
