package com.scrumboard.controller;


import org.h2.util.New;
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
import com.scrumboard.domain.model.Person;
import com.scrumboard.domain.model.Project;
import com.scrumboard.domain.model.Team;
import com.scrumboard.service.ProjectRepoService;
import com.scrumboard.service.ProjectViewService;

import static com.scrumboard.controller.ViewNames.*;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepoService repoService;
	
	@Autowired
	ProjectViewService viewService;

	@RequestMapping(value="", method= RequestMethod.GET)
	public ModelAndView getProjects(Model model) {
		
		return viewService.getAllProjects(model);
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET)
	public ModelAndView getProject(@PathVariable Long id, Model model) {
		
		model.addAttribute("project", repoService.findProject(id));
		model.addAttribute("backlog", new Backlog());
		model.addAttribute("team", new Team());
		model.addAttribute("person", new Person());
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName(SINGLE_PROJECT_PAGE);

		return modelAndView;
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.POST)
	public ModelAndView updateProject(@ModelAttribute Project project, 
			                          @PathVariable Long id,
			                          Model model,
			                          RedirectAttributes redirectAttributes, SessionStatus sessionStatus) {
		
		Project projectInDatabase = repoService.findProject(id);
		project.setBacklogs(projectInDatabase.getBacklogs());
//		project.setSprints(projectInDatabase.getSprints());
		repoService.updateProject(id, project);
		
		model.addAttribute("backlog", new Backlog());
		model.addAttribute("project", project);
		
		ModelAndView modelAndView = new ModelAndView();
		sessionStatus.setComplete();
		
		modelAndView.setViewName(SINGLE_PROJECT_PAGE);

		return modelAndView;
	}
	
	@RequestMapping(value="", method= RequestMethod.POST)
	public ModelAndView createProject(@ModelAttribute Project project, RedirectAttributes redirectAttributes, SessionStatus sessionStatus) {
		
		repoService.saveProject(project);
		
		ModelAndView modelAndView = new ModelAndView();
		sessionStatus.setComplete();
		
		modelAndView.setViewName(REDIRECT_TO_PROJECTS_PAGE);

		return modelAndView;
	}
}