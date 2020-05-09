package com.rajat.eCommerce.sampleApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	/*--
	 *  Retrieve All users 
	 * --*/
	
	@GetMapping(value = "/allusers")
	public Iterable<User> getAll(){
		return userRepository.findAll();
	}
	
	/*-- 
	 * retrieve Users By ID 
	 * --*/
	
	@GetMapping(value = "/{Id}")
	public Optional<User> getUserById(@PathVariable ("id") Long ids){
		return userRepository.findById(ids);
	}
	
	/*-- 
	 * Add Users
	 *  --*/
	
	@PostMapping(value = "/addUsers")
	public Iterable<User> persist(@RequestBody final User user){
		userRepository.save(user);
		return userRepository.findAll();
	}
	
	/*-- 
	 * Delete All Users
	 *  --*/
	
	@DeleteMapping(value = "/deleteUser")
	public Iterable<User> deleteAllUser(){
		userRepository.deleteAll();
		return userRepository.findAll();
	}
	
	/*-- 
	 * Delete Users By ID 
	 * --*/
	
	@DeleteMapping(value = "/deleteUser/{id}")
	public Iterable<User> deleteUserbyId(@PathVariable ("id") Long id){
		userRepository.deleteById(id);
		return userRepository.findAll();
	}

}
