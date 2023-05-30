package com.smhrd.iot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pageController {
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	@GetMapping("/ads")
	public String ads() {
		return "ads";
	}
	@GetMapping("/call")
	public String call() {
		return "call";
	}
	@GetMapping("/")
	public String regiset() {
		return "register";
	}
	
	@GetMapping("/register")
	public String regiset2() {
		return "redirect:/";
	}
	
	@GetMapping("/users")
	public String users() {
		return "users";
	}
	@GetMapping("/cart")
	public String cart() {
		return "cart";
	}
	@GetMapping("/product")
	public String product() {
		return "productManage";
	}
}
