package com.scrumboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrumboard.domain.model.Sprint;
import com.scrumboard.repository.SprintRepository;

@Service
public class SprintRepoService {

	@Autowired
	private SprintRepository<Sprint> sprintRepository;
	
	public Sprint findSprintById(Long taskId) {
		
		return sprintRepository.findById(taskId);
	}
	public void save(Sprint sprint) {
		sprintRepository.save(sprint);
	}
}
