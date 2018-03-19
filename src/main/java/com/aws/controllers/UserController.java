package com.aws.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aws.domain.User;
import com.aws.repository.UserMongoRepository;

@RestController
public class UserController {
	
	@Autowired
	UserMongoRepository userMongoRepository;
	
	
	@GetMapping("/user/{user}")
	public User getUser(@PathVariable("user") String user){
		
		return userMongoRepository.findByName("Bob");
		
	}
	
	@GetMapping("/save/user/{user}")
	public User saveUser(@PathVariable("user") String user){
		User user1 = new User();
		user1.setName(user);
		return userMongoRepository.save(user1);
	}
	
	@GetMapping("/add/mock")
	public void addMockUsers(){
		User user1 = new User();
		user1.setName("Alice");
		user1.setAge(23);
		User user2 = new User();
		user2.setName("Bob");
		user2.setAge(38);
		// save product, verify has ID value after save
		userMongoRepository.save(user1);
		userMongoRepository.save(user2);
	}
	
	@GetMapping("/users")
	public List<User> fetchAllUsers(){
		return userMongoRepository.findAll();
	}

}
