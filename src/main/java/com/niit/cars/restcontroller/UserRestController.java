package com.niit.cars.restcontroller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.cars.dao.User_dao;
import com.niit.cars.model.Blog;
import com.niit.cars.model.User;


@RestController
public class UserRestController {
	
	@Autowired
	User_dao userdao;
	
	
	//--------Retrieve all Users
    @GetMapping(value = "/User/")
     public ResponseEntity<List<User>> listAllUser(){
    	List<User> user = userdao.list();
    	if(user.isEmpty())
    	{
    		return new ResponseEntity<List<User>>(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
    	}
            return new ResponseEntity<List<User>>(user, HttpStatus.OK);    
    }
    
    
    
    
	
    
    //--------Create a User
    @PostMapping(value= "/User/")
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder uriBuilder)
    {
    	System.out.println("Creating User with" +user.getUsername());
    	if(userdao.isValidUser(user)){
    		System.out.println("A User wtih name" + user.getUsername()+ "already exist");
    		return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    	}
    	userdao.saveOrUpdate(user);
    	HttpHeaders headers = new HttpHeaders();
    	headers.setLocation(uriBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
    	return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
   
    
    
    
    
    
    
        
    
    
         
    
	
}