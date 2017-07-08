package com.scrumboard.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "welcome";
	}
	
	@RequestMapping(value="/task", method= RequestMethod.GET)
	public ModelAndView createTask() {
		
		System.out.println("sdfsdf");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("taskcreation");

		return modelAndView;
	}

}