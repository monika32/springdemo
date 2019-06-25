package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.User;

public interface UserRepo extends JpaRepository<User, Long>{
	 User findByName(String name);
	   User findByNameAndGender(String name, String gender);
	   @Query("select user from User user where user.name =?1")
	   User userByName(String name);
	   @Modifying
	   @Query(value = "insert into User (id, name, gender) VALUES (:id,:name,:gender)", nativeQuery = true)
	   @Transactional
	   void insertByDetails(@Param("id") long id,@Param("name") String name,@Param("gender") String gender);
	   
	   @Query("select user from User user where user.name =:username and user.gender =:gender")
	   User userByNameAndGender(@Param("username") String name,@Param("gender") String gender);
	   @Query("select user from User user")
	   List<User> returnTableData();
	   
}
