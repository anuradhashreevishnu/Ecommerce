package com.niit.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Component
public class Product implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@NotEmpty(message="product name is mandatory")
	private String productname;
	@NotEmpty(message="Product description cannot be blank")
	private String productDescription;
	private int quantity;
	@Min(value=10,message="Minimum price is 10") 
	private int price;
	private  int category_id;
    private int supplier_id;

	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}
	//	@ManyToOne
//	private Category Category;
	@Transient
	private MultipartFile image;
	public int getId(){
	return id;
}
	@ManyToOne
	@JoinColumn(name="category_id" , updatable= false , insertable= false, nullable=false)
    private Category category;
	@ManyToOne
	@JoinColumn(name="supplier_id" , updatable= false , insertable= false, nullable=false)
    private Supplier supplier;

public void setId(int id) {
	this.id=id;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname){
	this.productname=productname;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity=quantity;
}
public int getPrice() {
	 return price;
}
public void setPrice(int price){
	this.price=price;
}
public String getProductDescription() {
	return productDescription;
}
public void setProductDescription(String ProductDescription){
	this.productDescription=ProductDescription;
}
public MultipartFile getImage() {
	return image;
}
public void setImage(MultipartFile image) {
	this.image = image;
}
public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
public Supplier getSupplier() {
	return supplier;
}
public void setSupplier(Supplier supplier) {
	this.supplier = supplier;
}

}



