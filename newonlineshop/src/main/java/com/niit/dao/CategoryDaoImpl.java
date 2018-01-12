package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Category;
import com.niit.model.Product;


@Repository("categoryDAO")
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	private SessionFactory sessionfactory;
	public CategoryDaoImpl(SessionFactory session) {
		sessionfactory=session;
	}
	@Transactional
	public Category getCategory(int id) {
		String s="from Category where id="+id;
		Query q=sessionfactory.getCurrentSession().createQuery(s);
		List<Category> cl=q.list();
		if(cl!=null && !cl.isEmpty())
			return cl.get(0);
		
		return null;	
	}
	
	@Transactional
	public void addorupdatecategory(Category c) {
		Session s=sessionfactory.getCurrentSession();
		s.saveOrUpdate(c);
	}
	
	
	//@Override
	@Transactional
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		Session session= sessionfactory.getCurrentSession();
		Query query=session.createQuery("from Category");
		return query.list();
	}
	@Transactional
	public Category getCategoryByCategoryid(int categoryid){
		Session session=this.sessionfactory.getCurrentSession();
		Category c=(Category)session.load(Category.class,new Integer(categoryid));
		return c;
	}
	@Transactional
	public Category getByName(String name)
	{
		String hql = " from Category where categoryname = " + "'" + name + "'";
		
		@SuppressWarnings("rawtypes")
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Category> listCategory = query.list();
		
		if(listCategory!=null || !listCategory.isEmpty())
		{
			return listCategory.get(0);
		}
		return null;
	}
	
	
	//@Override
	@Transactional
	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.getCurrentSession();	
		Category category =(Category)session.get(Category.class,id);
		session.delete(category );
	}

	
	

}
