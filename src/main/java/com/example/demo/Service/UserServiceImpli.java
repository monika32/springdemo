package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.repo.UserRepo;
@Service("UserService")
public class UserServiceImpli implements UserService{
	@Autowired
	UserRepo UserRepo;
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
	public User update(User user) {
		User oUser1 = UserRepo.save(user);
		return user;
			
		/*	us.set(count-1, user);
		System.out.println(us);
		return "updated Sucessfully";*/
	}
	@Override
	public void delete(long id) {
		
		UserRepo.deleteById(id);
		/*us.remove(user);
		count--;
		System.out.println(us);
		return "sucessfully deleted ";*/
	}

	@Override
	public Optional<User> findById(Long id) {
		return UserRepo.findById(id);
	}
	@Override
	public User retrieveByName(String name) {
//		return UserRepo.findByName(name);

		return UserRepo.userByName(name);
	}
	@Override
	public User retrieveByNameAndGender(String name,String gender) {
		return UserRepo.findByNameAndGender(name, gender);

//		return UserRepo.userByName(name);
	}
	
	public void insertByDetails(long id,String name,String gender) {
//		return UserRepo.findByName(name);

		UserRepo.insertByDetails(id,name,gender);
	}
	@Override
	public List<User> getData() {
		
		return UserRepo.returnTableData();
	}

	
}
