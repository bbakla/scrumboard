package com.scrumboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrumboard.domain.model.Backlog;
import com.scrumboard.domain.model.Team;
import com.scrumboard.repository.BacklogRepository;
import com.scrumboard.repository.TeamRepository;

@Service
public class TeamRepoService {

	@Autowired
	private TeamRepository<Team> teamRepository;
	
	public void updateTeam(Long teamId, Team team) {
		
//		Team backlogInDatabase = teamRepository.findById(teamId);
		
		teamRepository.save(team);
	}
	
	public Team findTeamById(Long id) {
		return teamRepository.findById(id);
	}
}
