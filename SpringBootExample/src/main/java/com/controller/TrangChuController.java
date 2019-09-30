package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home.html")
public class TrangChuController {
	
	@GetMapping
	public String index() {
		return "home";
	}

}
