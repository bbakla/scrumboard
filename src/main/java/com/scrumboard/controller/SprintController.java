package com.scrumboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.access.SimpleRemoteSlsbInvokerInterceptor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.scrumboard.domain.enumeration.TaskStatus;
import com.scrumboard.domain.model.Sprint;
import com.scrumboard.domain.model.Task;
import com.scrumboard.domain.model.Team;
import com.scrumboard.service.ProjectRepoService;
import com.scrumboard.service.SprintRepoService;
import com.scrumboard.service.TaskRepoService;
import com.scrumboard.service.TeamRepoService;

import static com.scrumboard.controller.ViewNames.*;

import javax.swing.Spring;

@Controller
@RequestMapping("/projects")
public class SprintController {
	
	@Autowired
	private TeamRepoService teamRepoService;
	
	@Autowired
	private ProjectRepoService projectRepoService;
	
	@Autowired
	private TaskRepoService taskRepoService;
	
	@Autowired
	private SprintRepoService sprintRepoService;
	
	@RequestMapping(value="/{projectId}/team/{teamId}/sprint", method=RequestMethod.GET)
	public ModelAndView getSprints(@PathVariable("projectId") Long projectId,
								   @PathVariable("teamId") Long teamId,
								   Model model) {
		
		Team team = teamRepoService.findTeamById(teamId);
		
		model.addAttribute("sprint", team.getSprints());
		model.addAttribute("project", team.getProject());
		model.addAttribute("team", team);
		model.addAttribute("statuses", TaskStatus.values());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(SPRINT_PAGE);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/{projectId}/team/{teamId}/sprint/{sprintId}", method=RequestMethod.GET)
	public ModelAndView getSprint(@PathVariable("projectId") Long projectId,
								   @PathVariable("teamId") Long teamId,
								   @PathVariable("sprintId") Long sprintId,
								   Model model) {
		
		Sprint sprint = teamRepoService.findTeamByAndSprintId(teamId, sprintId);
		
		model.addAttribute("sprint", sprint);
		model.addAttribute("project", sprint.getTeam().getProject());
		model.addAttribute("team", sprint.getTeam());
		model.addAttribute("statuses", TaskStatus.values());
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(SPRINT_PAGE);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/{projectId}/team/{teamId}/sprint", method=RequestMethod.POST)
	public ModelAndView saveSprint(@PathVariable("projectId") Long projectId,
								   @PathVariable("teamId") Long teamId,
								   @ModelAttribute Sprint sprint,
								   Model model) {
		
		Team team = teamRepoService.findTeamById(teamId);
		team.addSprint(sprint);
		sprint.setTeam(team);
		
		teamRepoService.updateTeam(teamId, team);
		
		model.addAttribute("project", projectRepoService.findTaskById(projectId));
		model.addAttribute("sprint", new Sprint());
		model.addAttribute("team", team);
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(REDIRECT_TO_A_PAGE + projectId + "/team/" + teamId);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/{projectId}/team/{teamId}/sprint/{sprintId}", method=RequestMethod.POST)
	public ModelAndView saveTaskToSprint(@RequestParam("taskId") Long taskId,
								   @PathVariable("projectId") Long projectId,
								   @PathVariable("teamId") Long teamId,
								   @PathVariable("sprintId") Long sprintId,
								   Model model) {
		
		Sprint sprint = sprintRepoService.findSprintById(sprintId);
		Task task = taskRepoService.findTaskById(taskId);
		
		sprint.addTask(task);
		sprintRepoService.save(sprint);
		
		
		model.addAttribute("project", projectRepoService.findTaskById(projectId));
		model.addAttribute("sprint", sprint);
		model.addAttribute("team", sprint.getTeam());
		model.addAttribute("statuses", TaskStatus.values());
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(REDIRECT_TO_A_PAGE + projectId + "/team/" + teamId + "/sprint/" + sprintId);
		
		return modelAndView;
	}
}
