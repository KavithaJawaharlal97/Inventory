package com.inventory.product.webapp.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
public class HomeController {
	
	@RequestMapping("/Home")
	String home() {
		return "Home";
		
	}

}
