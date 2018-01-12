package com.niit.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Category {

private int category_id;
private String categoryname;
//@OneToMany(mappedBy="category")
//private List products;
private Set<Product> products;
@OneToMany(mappedBy="category" , fetch = FetchType.EAGER)	
public Set<Product> getProducts() {
	return products;
}
public void setProducts(Set<Product> products) {
	this.products = products;
}
@Id
@GeneratedValue(strategy=GenerationType.AUTO )
public int getCategory_id() {
	return category_id;
}
public void setCategory_id(int category_id) {
	this.category_id = category_id;
}
public String getCategoryname(){
	return categoryname;
	
}
public void setCategoryname(String categoryname){
	this.categoryname=categoryname;
}
}
