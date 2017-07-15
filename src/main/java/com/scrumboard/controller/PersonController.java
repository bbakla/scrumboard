package com.scrumboard.controller;

import org.eclipse.jdt.internal.compiler.flow.LoopingFlowContext;
import org.h2.util.New;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scrumboard.domain.model.Backlog;
import com.scrumboard.domain.model.Person;
import com.scrumboard.domain.model.Project;
import com.scrumboard.domain.model.Team;
import com.scrumboard.service.PersonRepoService;
import com.scrumboard.service.ProjectRepoService;

import static com.scrumboard.controller.ViewNames.*;

@Controller
@RequestMapping("/projects")
public class PersonController {
	
	@Autowired
	private PersonRepoService personRepoService;
	
	@Autowired
	private ProjectRepoService projectRepoService;
	
	@RequestMapping(value="/{projectId}/persons", method=RequestMethod.GET)
	public String getPeople(@PathVariable("projecId") Long projectId, Model model) {
		
		Project project = projectRepoService.findProject(projectId);
		
		model.addAttribute("people", personRepoService.getPeople(project));
		
		return PERSON_PAGE;
	}
	
	@RequestMapping(value="/{projectId}/person", method=RequestMethod.POST)
	public String savePerson(@PathVariable("projectId") Long projectId, @ModelAttribute Person person, Model model) {
		
		Project project = projectRepoService.findProject(projectId);
		
		person.setProject(project);
		personRepoService.savePerson(person);
		
		model.addAttribute("project", project);
		model.addAttribute("backlog", new Backlog());
		model.addAttribute("team", new Team());
		model.addAttribute("person", new Person());
		
		return REDIRECT_TO_SINGLE_PROJECT + "/" + projectId;
	}
}
