package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Entity.User;

public interface UserService {
	User create(User user);
	User retrieveByName(String name);
	User update(User user);
	void delete(long id);
	Optional<User> findById(Long id);
	User retrieveByNameAndGender(String name, String gender);
	void insertByDetails(long id,String name,String gender);
	List<User> getData();
}
