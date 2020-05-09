package com.rajat.eCommerce.sampleApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajat.eCommerce.sampleApp.models.User;
import com.rajat.eCommerce.sampleApp.repository.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UsersController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping(value = "/allusers")
	public Iterable<User> getAll(){
		return userRepository.findAll();
	}
	
	@PostMapping(value = "/addUsers")
	public void persist(@RequestBody final User user){
		userRepository.save(user);
	}

}
