package com.ezekiel.app.restapi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ezekiel.app.restapi.models.User;
import com.ezekiel.app.restapi.repo.UserRepo;

@RestController
public class ApiControllers {
	
	// Annotate declaration with auto-wire: handles all dependencies injections for us
		@Autowired
		private UserRepo userRepo;
		
	// the argument passed to GetMapping is a value to the end-point
	// value "/" indicates the initial value like: http://localhost:8080/ is equal http://localhost:8080
	
	
	//we import List from util and also User class
	@GetMapping(value="/users")
	public List<User> getUsers(){
		return userRepo.findAll();
	}
	
	@PostMapping(value = "/save")
	public String saveUser(@RequestBody User user) {
		userRepo.save(user);
		return "Saved...";
	}
	
	@PutMapping(value = "update/{id}")
	public String updateUser(@PathVariable long id, @RequestBody User user) {
		User updatedUser = userRepo.findById(id).get();
		updatedUser.setFirstName(user.getFirstName());
		updatedUser.setLastName(user.getLastName());
		updatedUser.setOccupation(user.getOccupation());
		updatedUser.setAge(user.getAge());
		userRepo.save(updatedUser);
		return "Updated...";	
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public String deleteUser(@PathVariable long id) {
		User deleteUser = userRepo.findById(id).get();
		userRepo.delete(deleteUser);
		return "Delete user with the id: "+id;
		
	}
	
	
	
	
	
}
