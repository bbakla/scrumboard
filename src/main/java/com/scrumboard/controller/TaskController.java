package com.scrumboard.controller;

import static com.scrumboard.controller.ViewNames.BACKLOG_PAGE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.scrumboard.domain.model.Backlog;
import com.scrumboard.domain.model.Project;
import com.scrumboard.domain.model.Task;
import com.scrumboard.service.ProjectRepoService;
import com.scrumboard.service.ProjectTaskService;

import static com.scrumboard.controller.ViewNames.*;

@Controller
@RequestMapping("/projects")
public class TaskController {
	
	@Autowired
	private ProjectRepoService projectRepoService;
	
	@Autowired
	private ProjectTaskService taskService;
	
	
	@RequestMapping(value="/{projectId}/backlog/{backlogId}/task", method=RequestMethod.GET)
	public ModelAndView getTasks(@PathVariable("projectId") Long projectId, 
						   @PathVariable("backlogId") Long backlogId, Model model) {
		
		Project project = projectRepoService.findProject(projectId);
		Backlog backlog = projectRepoService.findBacklog(projectId, backlogId);
		
		
		model.addAttribute("task", new Task());
		model.addAttribute("project", project);
		model.addAttribute("backlog", backlog);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(SINGLE_TASK_PAGE);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/{projectId}/backlog/{backlogId}/task/{taskId}", method=RequestMethod.GET)
	public ModelAndView getTaskById(@PathVariable("projectId") Long projectId, 
						   			@PathVariable("backlogId") Long backlogId, 
						   			@PathVariable("taskId") Long taskId,
						   			Model model) {
		
		Project project = projectRepoService.findProject(projectId);
		Backlog backlog = projectRepoService.findBacklog(projectId, backlogId);
		
		Task task = projectRepoService.findTaskById(taskId);
		
		model.addAttribute("task", task);
		model.addAttribute("project", project);
		model.addAttribute("backlog", backlog);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(SINGLE_TASK_PAGE);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/{projectId}/backlog/{backlogId}/task/{taskId}", method=RequestMethod.POST)
	public ModelAndView updateTask(@PathVariable("projectId") Long projectId,
									@ModelAttribute Task task,
						   			@PathVariable("backlogId") Long backlogId, 
						   			@PathVariable("taskId") Long taskId,
						   			Model model) {
				Project project = projectRepoService.findProject(projectId);
		Backlog backlog = projectRepoService.findBacklog(projectId, backlogId);
		
		taskService.updateTask(task);
		
		
		model.addAttribute("task", task);
		model.addAttribute("project", project);
		model.addAttribute("backlog", backlog);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(SINGLE_TASK_PAGE);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/{projectId}/backlog/{backlogId}/task", method=RequestMethod.POST)
	public ModelAndView createTask(@PathVariable("projectId") Long projectId, 
						   @PathVariable("backlogId") Long backlogId, @ModelAttribute Task task, Model model) {
		
		Project project = projectRepoService.findProject(projectId);
		Backlog backlog = projectRepoService.findBacklog(projectId, backlogId);
		
		backlog.addTaskToBacklog(projectRepoService.saveTask(task));
		backlog.addTaskToBacklog(task);
		
		projectRepoService.updateProject(projectId, project);

		model.addAttribute("backlog", backlog);
		model.addAttribute("project", project);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(BACKLOG_PAGE);
		
		return modelAndView;
	}

}
