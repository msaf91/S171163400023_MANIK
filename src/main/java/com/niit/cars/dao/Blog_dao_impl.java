package com.niit.cars.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.niit.cars.model.Blog;

@Repository
public class Blog_dao_impl implements Blog_dao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	Blog blog;
	
	@Transactional
	public List<Blog> list() {
		String hql = "from blog";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Blog> list = (List<Blog>) query.list();
		return list;
	}


	@Transactional
	public Blog getBlog(int id) {
       String hql = "from blog where id=" + "'" +id+ "'";
       Query query = sessionFactory.getCurrentSession().createQuery(hql);
       @SuppressWarnings("unchecked")
	List<Blog> list = (List<Blog>) query.list();
       if ( list!=null && !list.isEmpty()){
    	    return list.get(0);
       }
       return null;
    }

	@Transactional
	public boolean deleteById(String id) {
		sessionFactory.getCurrentSession().delete(id);
		return true;
	}

	@Transactional
	public boolean saveOrUpdate(Blog blog) {
		sessionFactory.getCurrentSession().saveOrUpdate(blog);
		return true;
	}


}
