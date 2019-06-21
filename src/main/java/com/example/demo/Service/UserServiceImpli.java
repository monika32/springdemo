package com.example.demo.Service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
@Service("UserService")
public class UserServiceImpli implements UserService{
	ArrayList<User> us = new ArrayList<>();
	int count=0;
	@Override
	public User create(User user) {
		us.add(user);
		count++;
		System.out.println(us );
		return user;
	}
	
	@Override   
	public User retrieveByName(String name) {
	//	User user = null;
		for(User i : us ) {
			if(i.name.equals(name)) {
				return i;
			} 
		}
		/*if(us.contains(name)) {
			return username;
		} else {
			 username = new User("NOT found");
		}*/
		return null;
	}

	@Override
	public String update(User user) {
		us.set(count-1, user);
		System.out.println(us);
		return "updated Sucessfully";
	}
	@Override
	public String delete(User user) {
		us.remove(user);
		count--;
		System.out.println(us);
		return "sucessfully deleted ";
	}
}
