package com.niit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.model.Product;

@Repository("productDAO")
public interface ProductDao {
	public List<Product> getAllproducts();
	public Product getproduct(int id);
void deleteproduct(int id);
void addorupdateproduct(Product p);
public List<Product> getBycid(int cid);

}
