package com.scrumboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.scrumboard.domain.model.Project;

import static com.scrumboard.controller.ViewNames.*;

@Service
public class ProjectViewService {
	
	@Autowired
	private ProjectRepoService repoService;
	
	@Autowired
	private TeamRepoService teamRepoService;

	public ModelAndView getAllProjects(Model model) {
		Project project = new Project();
		model.addAttribute("project", project);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(PROJECTS_PAGE);
		
		model.addAttribute("projects", repoService.getAllProjects());
		model.addAttribute("teams", teamRepoService.getTeams());
		
		return modelAndView;
		
	}

}
