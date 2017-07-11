package com.scrumboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrumboard.domain.model.Backlog;
import com.scrumboard.repository.BacklogRepository;

@Service
public class BacklogRepoService {

	@Autowired
	private BacklogRepository<Backlog> backlogRepository;
	
	public void updateBacklog(Long backlogId, String newBacklogName) {
		
		Backlog backlogInDatabase = backlogRepository.findById(backlogId);
		backlogInDatabase.setName(newBacklogName);
		
		backlogRepository.save(backlogInDatabase);
	}
}
