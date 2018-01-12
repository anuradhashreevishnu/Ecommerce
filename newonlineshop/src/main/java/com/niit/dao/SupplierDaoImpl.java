package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Supplier;
@Repository("supplierDAO")
public class SupplierDaoImpl implements SupplierDao {
@Autowired
private SessionFactory sessionFactory;
public SupplierDaoImpl(SessionFactory session){
	sessionFactory=session;
}
@Transactional
public Supplier getByName(String name)
{
	String hql = " from Supplier where suppliername = " + "'" + name + "'";
	
	@SuppressWarnings("rawtypes")
	Query query =  sessionFactory.getCurrentSession().createQuery(hql);
	
	@SuppressWarnings("unchecked")
	List<Supplier> listSupplier = query.list();
	
	if(listSupplier!=null || !listSupplier.isEmpty())
	{
		return listSupplier.get(0);
	}
	return null;
}

	
	@Transactional
	public void deleteSupplier(int Supplierid) {
		Supplier s=(Supplier)sessionFactory.getCurrentSession().load(Supplier.class, Supplierid);
		if(null!=s){
			this.sessionFactory.getCurrentSession().delete(s);
		}
	}
	@Transactional
	public Supplier updatesupplier(Supplier s) {
		Supplier s1=getSupplierBySupplierid(s.getSupplier_id());
		sessionFactory.getCurrentSession().update(s1);
		return s1;
	}
	
	@Transactional
	public void addSupplier(Supplier s){
		sessionFactory.getCurrentSession().saveOrUpdate(s);
		
	}
	@Transactional
	public List<Supplier> getAllSuppliers(){
	return sessionFactory.getCurrentSession().createQuery("from Supplier").list();
}
		
//	@Override
	@Transactional
	public Supplier getSupplierBySupplierid(int supplierid) {
		Session session=this.sessionFactory.getCurrentSession();
		Supplier s=(Supplier) session.load(Supplier.class, supplierid) ;
		return s;
	}
	@Transactional
	public Supplier getSupplier(int id){
	String s="from Supplier where id="+id;
	org.hibernate.Query query=sessionFactory.getCurrentSession().createQuery(s);
	List<Supplier>listSupplier=query.list();
	if(listSupplier!=null&&!listSupplier.isEmpty()){
		return listSupplier.get(0);
	}
	return null;
	}


	
}
