package com.niit.cars.dao;

import java.util.List;

import com.niit.cars.model.Blog;

public interface Blog_dao {

	public List<Blog> list();
	
	public Blog getBlog(int id);
	
	public boolean saveOrUpdate(Blog blog);
	
	public boolean deleteById(String id);

}
