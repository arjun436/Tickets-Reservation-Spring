package com.mypackage.myapp.controllers;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {
 
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");
 
		return model;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
 
		
		ModelAndView model = new ModelAndView();

		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (!(auth instanceof AnonymousAuthenticationToken)) {
			model.setViewName("home");

		    /* The user is logged in :) */
			return model;
		}
		
		
		if (error != null) {
			model.addObject("error", "Invalid username or password!");
		}
 
//		if (logout != null) {
//			model.addObject("msg", "You've been logged out successfully.");
//		}
		model.setViewName("login");
 
		return model;
 
	}
	
	
	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public ModelAndView accessDenied404() 
	{
 
		ModelAndView model = new ModelAndView();
		model.setViewName("404");
 
		return model; 
 
	}
}
