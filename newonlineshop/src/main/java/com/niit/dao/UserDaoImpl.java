package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Category;
import com.niit.model.User;
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory; 
		public UserDaoImpl(SessionFactory session){
			sessionFactory=session;
		}
		
	@Transactional
	public void addUser(User u){
		sessionFactory.getCurrentSession().save(u);
		}

//	@Override
	@Transactional
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		Session session= sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User");
		return query.list();
	}

//	@Override
	@Transactional
	public User getUser(String uname) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class,uname);
		return user;
	
	}

//	@Override
	@Transactional
	public void deleteUser(String uname) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();	
		User user =(User)session.get(User.class,uname);
		session.delete(user );
	}

//	@Override
	public User updateUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}

}
	
		
	

	


