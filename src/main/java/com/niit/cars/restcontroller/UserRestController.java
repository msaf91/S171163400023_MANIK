package com.niit.cars.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.cars.model.User;
import com.niit.cars.service.User_service;

@RestController
public class UserRestController {
	
	@Autowired
	User_service userservice;
	
	//Retrieve all Users
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers(){
		List <User> user = userservice.showallusers();
		if(user.isEmpty()){
			return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND); 
		}
		return new ResponseEntity<List<User>>(HttpStatus.OK);
	}
	
	//Retrieve Single User
     @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
      public ResponseEntity<User> getUser(@PathVariable("id")int id){
    	 System.out.println("Fetching user with userid" +id);
    	 User user = userservice.getbyId(id);
    	 if(user == null){
    		 System.out.println("User with id" +id+ "not found");
    		 return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
    	 }
    	 return  new ResponseEntity<User>(HttpStatus.OK);
     }

     // Create a New User
     @RequestMapping(value = "/user/", method = RequestMethod.POST)
     public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder)
     {
    	 System.out.println("Creating User " +user.getUsername());
    	 if(userservice.isUserexist(user)){
    		 System.out.println("A User with name" +user.getUsername()+ "already exists");
    		 return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    	 }
    	 userservice.saveUser(user);
    	 HttpHeaders headers = new HttpHeaders();
    	 headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getUserid()).toUri());
         return new ResponseEntity<Void>(HttpStatus.CREATED);
     }
     
     
}
