package com.kit.kat.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class UserController {
	
	
	@Autowired
	public UserRepository userRepo;
	
	@PostMapping("/user")
	public ResponseEntity<String> userRegister(@RequestBody User user){
		
		if(userRepo.findByName(user.getName()) != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		userRepo.save(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUser(){
		
		if(userRepo.findAll().isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(userRepo.findAll(),HttpStatus.OK);
	} 
	
	@DeleteMapping("/users/{name}")
	public ResponseEntity<String> deleteByName(@PathVariable String name){
		
		if(userRepo.findByName(name) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		userRepo.deleteByName(name);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
