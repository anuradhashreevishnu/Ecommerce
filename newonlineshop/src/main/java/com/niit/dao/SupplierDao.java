package com.niit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.model.Category;
import com.niit.model.Supplier;

@Repository("SupplierDAO")
public interface SupplierDao {
	public void addSupplier(Supplier s);
	public List<Supplier>getAllSuppliers();
	public void deleteSupplier(int Supplierid);
	public Supplier updatesupplier(Supplier s);
	public Supplier getSupplier(int id);
	public Supplier getSupplierBySupplierid(int supplierid);
	public Supplier getByName(String name);

}
