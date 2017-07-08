package com.scrumboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.scrumboard.domain.model.Project;

@Service
public class ProjectViewService {
	
	@Autowired
	ProjectRepoService repoService;

	public ModelAndView getAllProjects(Model model) {
		Project project = new Project();
		model.addAttribute("project", project);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("new_project");
		
		model.addAttribute("projects", repoService.getAllProjects());
		
		return modelAndView;
		
	}

}
