package com.scrumboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.scrumboard.domain.model.Backlog;
import com.scrumboard.domain.model.Project;
import com.scrumboard.service.ProjectRepoService;


import static com.scrumboard.controller.ViewNames.*;

@Controller
@RequestMapping(value="/projects")
public class BacklogController {
	
	@Autowired
	private ProjectRepoService projectRepoService;
	
	@RequestMapping(value = "/{projectId}/backlog", method = RequestMethod.GET)
	public ModelAndView getBacklogByProjectId(@PathVariable("projectId") Long projectId, Model model) {
		
		Project project = projectRepoService.findProject(projectId);
		
		model.addAttribute("backlog", new Backlog());
		model.addAttribute("project", project);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(BACKLOG_PAGE);

		return modelAndView;
	}
	
	@RequestMapping(value = "/{projectId}/backlog/{backlogId}", method = RequestMethod.GET)
	public ModelAndView getBacklogByBacklogId(@PathVariable("projectId") Long projectId,
											  @PathVariable("backlogId") Long backlogId, Model model) {
		
		Backlog backlog = projectRepoService.findBacklog(projectId, backlogId);
		
		model.addAttribute("backlog", backlog);
		model.addAttribute("project", backlog.getProject());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(BACKLOG_PAGE);

		return modelAndView;
	}

	@RequestMapping(value = "/{projectId}/backlog", method = RequestMethod.POST)
	public ModelAndView createBacklog(@PathVariable("projectId") Long projectId, @ModelAttribute Backlog backlog, 
			Model model, RedirectAttributes redirectAttributes, SessionStatus sessionStatus) {

		Project project = projectRepoService.findProject(projectId);
		project.addBacklog(backlog);
		backlog.setProject(project);
		
		projectRepoService.updateProject(project.getId(), project);
		
		model.addAttribute("project", project);
		
		ModelAndView modelAndView = new ModelAndView();
		sessionStatus.setComplete();
		
		modelAndView.setViewName(SINGLE_PROJECT_PAGE);

		return modelAndView;
	}
}
