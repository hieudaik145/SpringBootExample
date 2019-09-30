package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Login {

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@GetMapping("/403")
	public String accessDenie() {
		return "403";
	}
	
//	@PostMapping("/logout")
//	public String logout(HttpServletRequest request, HttpServletResponse response) {
//		
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		
//		if(auth != null) {
//			new SecurityContextLogoutHandler().logout(request, response, auth);
//		}
//		return "redirect:/";
//	}
}
