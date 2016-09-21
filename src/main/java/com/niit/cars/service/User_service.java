 package com.niit.cars.service;

import java.util.List;

import com.niit.cars.model.User;

public interface User_service {
	
	public User getbyId(int id);
	
	public User getbyname(String name);
	
	public void saveUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUserbyId(int id);
	
	public void deleteallUsers();
	
	public List<User> showallusers();
	
	public boolean isUserexist(User user);
	
	
	
	
	

}
