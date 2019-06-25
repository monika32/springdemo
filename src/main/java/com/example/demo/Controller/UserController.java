package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;

@RestController
@RequestMapping("/")
public class UserController  {
	@Autowired
	UserService UserService;    
	@RequestMapping("/hello")
	public String result() {
		return "Hello World";
	}
	@RequestMapping("/get")
	public List<User> onHtml() {
		return UserService.getData();
	}
	
	@GetMapping("/name/{name}")
	public User getUserByName(@PathVariable("name") String name) {
		
		return UserService.retrieveByName(name);
	}
	
	@GetMapping("/name/gender/{name}/{gender}")
	public User getUserByNameAndGender(@PathVariable("name") String name,@PathVariable("gender") String gender) {
		
		return UserService.retrieveByNameAndGender(name,gender);
	}
	
	ArrayList<User> us = new ArrayList<>();
	int count=0;
	@PostMapping("/{id}/{name}/{gender}")
	public String createUser(@PathVariable("id") long id,@PathVariable("name") String name,@PathVariable("gender") String gender) {
		UserService.insertByDetails(id, name, gender);
		return "created";
	}
	
/*	@GetMapping("/{id}")
	public Optional<User> findById(@PathVariable("id") Long id) {
		return UserService.findById(id);
	}*/

	/*@DeleteMapping("/{id}")
	public void removeUser(@PathVariable("id") Long id) {
		UserService.delete(id);
		return "sucessfully deleted ";
	}*/
	@PostMapping("/put")
	public String putUser(@RequestBody User user) {
		UserService.update(user);
		return 	 "updated sucessfully";
	}
}
