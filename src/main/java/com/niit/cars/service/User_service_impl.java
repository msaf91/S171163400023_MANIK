package com.niit.cars.service;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.cars.model.User;

@Service
@Transactional
public class User_service_impl implements User_service {
	
	private static final AtomicInteger counter = new AtomicInteger();
 
	private static List<User> users;
	
	@Override
	public User getbyId(int id) {
		for(User user : users){
			if(user.getUserid() == id){
				return user;
			}
		}
		
		return null;
	}

	@Override
	public User getbyname(String name) {
		for(User user : users){
			if(user.getUsername().equalsIgnoreCase(name)){
				return user;
			}
		}
		
		return null;
	}

	@Override
	public void saveUser(User user) {
		user.setUserid(counter.incrementAndGet());
		users.add(user);
	}

	@Override
	public void updateUser(User user) {
	  int index = user.indexOf(user);
	  users.set(index, user);
	}

	@Override
	public void deleteUserbyId(int id) {
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext();)
		{
			User user = iterator.next();
			if(user.getUserid()== id){
				iterator.remove();
			}
			
		}

	}

	@Override
	public void deleteallUsers() {
		users.clear();
     }

	@Override
	public List<User> showallusers() {
		return users;
	} 

	@Override
	public boolean isUserexist(User user) {
		return getbyname(user.getUsername())!= null;
	}

}
