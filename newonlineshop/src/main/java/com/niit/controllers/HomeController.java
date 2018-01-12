package com.niit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.model.Product;

@Controller
public class HomeController {
	@Autowired
	ProductDao productDAO;
	@Autowired
	private Product product;
	@Autowired
	private CategoryDao categoryDAO;
	
	@RequestMapping("/home")
	public String func(Model model)
	{
		
		
		model.addAttribute("product",product );
		model.addAttribute("hproList", this.productDAO.getAllproducts());
		model.addAttribute("hcatList",this.categoryDAO.getAllCategory());
		return "home";
	}
	
	@RequestMapping("/admin")
	public String f2() 
	{
		return "Admin";
		
	}
	@RequestMapping("/")
	public String home(Model model)
	{
		model.addAttribute("product",product );
		model.addAttribute("hproList", this.productDAO.getAllproducts());
		model.addAttribute("hcatList",this.categoryDAO.getAllCategory());
		return "home";}
	
	
	
}