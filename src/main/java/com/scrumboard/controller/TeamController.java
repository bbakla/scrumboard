package com.scrumboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.scrumboard.domain.model.Backlog;
import com.scrumboard.domain.model.Person;
import com.scrumboard.domain.model.Project;
import com.scrumboard.domain.model.Sprint;
import com.scrumboard.domain.model.Team;
import com.scrumboard.service.PersonRepoService;
import com.scrumboard.service.ProjectRepoService;
import com.scrumboard.service.TeamRepoService;

import static com.scrumboard.controller.ViewNames.*;

@Controller
@RequestMapping("/projects")
public class TeamController {
	
	@Autowired
	private ProjectRepoService projectRepoService;
	
	@Autowired
	private PersonRepoService personRepoService;
	
	@Autowired
	private TeamRepoService teamRepoService;
	
	@RequestMapping(value="/{projectId}/team", method = RequestMethod.GET)
	public String getTeam(@PathVariable("projectId") Long projectId,  Model model ) {
		
		Project project = projectRepoService.findProject(projectId);
		
		model.addAttribute("team", new Team());
		model.addAttribute("project", project);
		model.addAttribute("backlog", project.getBacklogs());
		
		return TEAM_PAGE;
	} 
	
	@RequestMapping(value="/{projectId}/team/{teamId}", method=RequestMethod.GET)
	public ModelAndView getTeamById(@PathVariable("projectId") Long projectId,
									@PathVariable("teamId") Long teamId,
									Model model) {
		Project project = projectRepoService.findProject(projectId);
		Team team = teamRepoService.findTeamById(teamId);
				
		model.addAttribute("team", team);
		model.addAttribute("project", project);
		model.addAttribute("person", new Person());
		model.addAttribute("sprint", new Sprint());
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(TEAM_PAGE);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/{projectId}/team/{teamId}", method = RequestMethod.POST)
	public ModelAndView updateTeam(@ModelAttribute Team team, 
									 @PathVariable("projectId") Long projectId,
									 @PathVariable("teamId") Long teamId, Model model) {
		
		
		teamRepoService.updateTeam(teamId, team);
		
		model.addAttribute("person", new Person());
		model.addAttribute("team", team);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(TEAM_PAGE);

		return modelAndView;
	}
	
	
	@RequestMapping(value = "/{projectId}/team/{teamId}/member", method = RequestMethod.POST)
	public ModelAndView addMemberToTeam(@RequestParam("personId") Long personId, 
									 @PathVariable("projectId") Long projectId,
									 @PathVariable("teamId") Long teamId, Model model) {
		
		Person person = personRepoService.findPerson(personId);
		
		Team team = teamRepoService.findTeamById(teamId);
		team.addPerson(person);
		
		teamRepoService.updateTeam(teamId, team);
		
		model.addAttribute("team", team);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(REDIRECT_TO_A_PAGE + "/" + projectId + "/team/" + teamId); 

		return modelAndView;
	}

	@RequestMapping(value="/{projectId}/team", method = RequestMethod.POST)
	public ModelAndView createTeam(@PathVariable("projectId") Long projectId, 
								   @ModelAttribute Team team, Model model, SessionStatus sessionStatus) {
		
		Project project = projectRepoService.findProject(projectId);
		team.setProject(project);
		
		project.addTeam(team);
		
		projectRepoService.saveProject(project);
		
		model.addAttribute("project", project);
		model.addAttribute("backlog", new Backlog());
		
		ModelAndView modelAndView = new ModelAndView();
		sessionStatus.setComplete();
		modelAndView.setViewName(REDIRECT_TO_A_PAGE + "/" + projectId); 
		
		return modelAndView;
	}
}
