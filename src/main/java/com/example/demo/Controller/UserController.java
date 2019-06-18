package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;

@RestController
public class UserController {
	@RequestMapping("/")
	public String result() {
		return "Hello World";
	}
	User user = new User("monika","femlae");
	@RequestMapping("/User")
	public User getUser() {
		return user;
	}
}
