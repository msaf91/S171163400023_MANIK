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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.cars.dao.Blog_dao;
import com.niit.cars.model.Blog;

@RestController
public class BlogController {
	
	@Autowired
	Blog_dao blogdao;
	
	@Autowired
	Blog blog;
	
	//----- Get all Blog
	@GetMapping(value = "/blog/")
	public ResponseEntity<List<Blog>> listAllBlog(){
		List<Blog> blog = blogdao.list();
		if(blog.isEmpty()){
			return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Blog>>(blog, HttpStatus.OK);
	}
	
	//---- Create Blog
	@PostMapping(value = "/blog/")
	public ResponseEntity<Void> createBlog(@RequestBody Blog blog, UriComponentsBuilder uriBuilder)
	{
		System.out.println("Creating new blog with" +blog.getblog_title());
		blogdao.saveOrUpdate(blog);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriBuilder.path("/blog/{id}/").buildAndExpand(blog.getId()).toUri());
	    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	  }
	
	
	
	// Delete a Blog
	@RequestMapping(value = "/blog/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Blog> deleteBlog(@PathVariable("id") int id){
    	System.out.println("Deleting Blog with id" +id);
    	Blog blog = blogdao.getBlog(id);
    	if (blog == null){
    		System.out.println("Unable to find with id" +id);
    		return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
    	}
    	   return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
    	   
    }
	

}
