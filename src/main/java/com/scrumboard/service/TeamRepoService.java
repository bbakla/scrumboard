package com.scrumboard.service;

import java.util.List;

import javax.swing.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrumboard.domain.model.Sprint;
import com.scrumboard.domain.model.Team;
import com.scrumboard.repository.TeamRepository;


@Service
public class TeamRepoService {

	@Autowired
	private TeamRepository<Team> teamRepository;
	
	public void updateTeam(Long teamId, Team team) {
		
		teamRepository.save(team);
	}
	
	public Team findTeamById(Long id) {
		return teamRepository.findById(id);
	}
	
	public List<Team> getTeams() {
		return teamRepository.findAll();
	}

	public Sprint findTeamByAndSprintId(Long teamId, Long sprintId) {
		
		Team team = teamRepository.findById(teamId);
		return team.getSprints()
				   .stream()
				   .filter(sprint -> sprint.getId() == sprintId)
				   .findFirst().get();
	}
	
}
