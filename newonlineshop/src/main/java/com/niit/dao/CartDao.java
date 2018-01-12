package com.niit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.model.Cart;
@Repository("cartDAO")
public interface CartDao {
	public Cart getCart(String id);
	public void saveOrUpdate(Cart cart);
	public void delete(int id);
	public List<Cart> list() ;
	
	public List<Cart> usercartlist(String ucname);

}
