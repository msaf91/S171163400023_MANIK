package com.niit.cars.dao;

import java.util.List;

import com.niit.cars.model.User;

public interface User_dao {

	public List<User> list();
	
	public User getByName(String name);
	
	public boolean saveOrUpdate(User user);
	
	public boolean delete(String id);
	
	public boolean isValidUser(User user);
	
}
