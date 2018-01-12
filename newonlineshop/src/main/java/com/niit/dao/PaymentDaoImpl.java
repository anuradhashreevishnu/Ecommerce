package com.niit.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Payment;
@Repository("paymentDAO")
public class PaymentDaoImpl implements PaymentDao {
	@Autowired
	PaymentDao paymentDAO;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public PaymentDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
@Transactional
	public void paymentsave(Payment payment) {
	sessionFactory.getCurrentSession().save(payment);
		
	}

}
