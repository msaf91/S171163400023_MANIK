package com.niit.cars.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.cars.model.User;

@Repository
public class User_dao_impl implements User_dao {
	
	private static List<User> users;
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	User user;

	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> list() {
		String hql = "from user";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<User> list = (List<User>)query.list();
		return list;
	}

	@Transactional
	public User getUser(String id) {
		String hql = "from User where id=" + "'" +id+ "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<User> list = (List<User>)query.list();
		if (list !=null && !list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}

	@Transactional
	public boolean saveOrUpdate(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	return true;
	}

	@Transactional
	public boolean delete(String id) {
		user.setId(id);
		sessionFactory.getCurrentSession().delete(user);
	    return true;
	}

	
	@Transactional
	public boolean isValidUser(User user) {
		return getByName(user.getUsername())!= null; 
	}

    @Override
	public User getByName(String name) {
		for(User user : users){
			if(user.getUsername().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}


}
	

