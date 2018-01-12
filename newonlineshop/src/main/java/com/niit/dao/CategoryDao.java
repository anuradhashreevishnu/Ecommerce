package com.niit.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.model.Category;
@Repository("categoryDAO")
public interface CategoryDao {
	public List<Category> getAllCategory();
	 public Category getCategory(int id);
	void deleteCategory(int id);
	public Category getByName(String name);
	public Category getCategoryByCategoryid(int Categoryid);
	void addorupdatecategory(Category c);
}
