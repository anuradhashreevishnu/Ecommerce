package com.niit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.model.Category;
import com.niit.model.Product;

@Controller
public class CategoryController {
	@Autowired
	CategoryDao categoryDAO;
	
	@Autowired
	Category category;
	@Autowired
	ProductDao productDAO;
	@RequestMapping("/c")
	public String name() {
		return "Category";
		
	}
	
@ModelAttribute("category")
public Category create() {
	return new Category();
}

@RequestMapping(value="/addcategory",method = RequestMethod.POST)  
public String save(@ModelAttribute("category") Category category,Model p)
{
	System.out.println(category.getCategoryname());
	System.out.println(category.getCategory_id());
	categoryDAO.addorupdatecategory(category);
	List<Category> categorylist=categoryDAO.getAllCategory();
	p.addAttribute("allcategory",categorylist );
	return "redirect:/clist";
}
@RequestMapping("/clist")
public String Allcategory(Model p) {
	System.out.println(" in list method");
	List<Category> categorylist=categoryDAO.getAllCategory();
	p.addAttribute("allcategory",categorylist );
return "Category";	
}

@RequestMapping("editcategory-{id}")
public String edit(@PathVariable("id") int id,Model p) {
		this.category=categoryDAO.getCategory(id);
		System.out.println(this.category.getCategory_id());
		p.addAttribute("category",this.category);
		return "Category";
		
	}
@RequestMapping("deletecategory-{id}")
public String remove(@PathVariable("id") int id) {
	categoryDAO.deleteCategory(id);
	return "redirect:/clist";
	
}
@RequestMapping("category-{category_id}")
public String categoryList(@PathVariable("category_id")int category_id,Model m){
	List<Product> pcatlist=productDAO.getBycid(category_id);
	m.addAttribute("pcatlist",pcatlist);
return "categorylist";
		
}
}



