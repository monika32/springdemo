package com.example.demo.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;

import net.minidev.json.writer.UpdaterMapper;

@RestController
public class UserController  {
	@Autowired
	UserService UserService;
	@RequestMapping("/")
	public String result() {
		return "Hello World";
	}

	
	@GetMapping("/user/{name}")
	public User getUserByName(@PathVariable("name") String name ) {
		return UserService.retrieveByName(name);
	}
	ArrayList<User> us = new ArrayList<>();
	int count=0;
	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		return UserService.create(user);
		
	}

	@DeleteMapping("/user")
	public void removeUser(@RequestBody User user) {
		UserService.delete(user);
		/*us.remove(user);
		count--;
		System.out.println(us);
		return "sucessfully deleted " +user;*/
	}
	@PutMapping("/user")
	public String putUser(@RequestBody User user) {
		UserService.update(user);
		/*us.set(count-1, user);
		System.out.println(us);
		return "sucessfully updated " +user;*/
		return "updated sucessfully";
	}
}
