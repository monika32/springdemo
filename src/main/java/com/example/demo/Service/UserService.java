package com.example.demo.Service;

import com.example.demo.Entity.User;

public interface UserService {
	User create(User user);
	User retrieveByName(String name);
	String update(User user);
	String delete(User user);
}
