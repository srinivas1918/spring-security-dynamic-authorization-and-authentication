package com.exp.dynamicroles.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationController {

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/denied")
	public String denied(){
		return "denied";
	}
	
	@RequestMapping(value="/userPage")
	public String userPage(){
		return "user";
	}
	
	@RequestMapping(value="/adminPage")
	public String adminPage(){
		return "user";
	}
	
	@RequestMapping(value="/dashboard")
	public String dashboard(Model model){
		model.addAttribute("roles", SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		return "dashboard";
	}
	
}
