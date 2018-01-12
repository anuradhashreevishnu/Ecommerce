package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Product;
@Repository("productDAO")
public class ProductDaoImpl implements ProductDao {
@Autowired
private SessionFactory  sessionfactory;

public ProductDaoImpl(SessionFactory session) {
	sessionfactory=session;
}

@Transactional
public Product getproduct(int id){
	String s="from Product where id="+id;
	Query q=sessionfactory.getCurrentSession().createQuery(s);
	List<Product> pl=q.list();
	if(pl!=null && !pl.isEmpty())
		return pl.get(0);
	
	return null;
}

@Transactional
public void addorupdateproduct(Product p) {
	Session s=sessionfactory.getCurrentSession();
	s.saveOrUpdate(p);
}

//@Override
@Transactional
public List<Product> getAllproducts() {
	Session session= sessionfactory.getCurrentSession();
	Query query=session.createQuery("from Product");
	return query.list();
}

//@Override
@Transactional
public void deleteproduct(int id) {
	Session session=sessionfactory.getCurrentSession();	
	Product product=(Product)session.get(Product.class,id);
	session.delete(product);
}

@Transactional
public List<Product> getBycid(int cid) {
	Session ses=sessionfactory.getCurrentSession();
	String s="from Product where category_id="+cid;
	Query q=ses.createQuery(s);
	return q.list();
}


	








}
