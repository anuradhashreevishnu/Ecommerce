package com.niit.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.dao.SupplierDao;
import com.niit.model.Category;
import com.niit.model.FileUtil;
import com.niit.model.Product;
import com.niit.model.Supplier;

@Controller
public class ProductController {
	
	@Autowired
	ProductDao productDAO;
	
	@Autowired
	Product product;
	
	@Autowired
	private CategoryDao categoryDAO;
		@Autowired
	private SupplierDao supplierDAO;
	
	private Path path;
	@RequestMapping("/p")
	public String name() {
		return "Product";
	}
	
	@ModelAttribute("product")
	public Product createpro() {
		return new Product();
	}
	
	
	
	@RequestMapping(value="/addproduct",method = RequestMethod.POST)  
    public String saveproduct(@ModelAttribute("product") Product product,Model m,HttpServletRequest request)
	{
		System.out.println(product.getId());
		
		Category category = categoryDAO.getByName(product.getCategory().getCategoryname());
		categoryDAO.addorupdatecategory(category);
		
		Supplier supplier = supplierDAO.getByName(product.getSupplier().getSuppliername());
		supplierDAO.addSupplier(supplier);
		
		product.setCategory(category);
		product.setSupplier(supplier);
		
		product.setCategory_id(category.getCategory_id());
		product.setSupplier_id(supplier.getSupplier_id());
		productDAO.addorupdateproduct(product);
		
		MultipartFile file=product.getImage();
		/**/
		String rootDirectory=request.getSession().getServletContext().getRealPath("/");
		/*path=Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\"+product.getPro_id()+".jpg");*/
		path = Paths.get(rootDirectory + "\\resources\\images\\" + product.getId() + ".jpg");
		
		if(file!=null && !file.isEmpty()){
			try{
				file.transferTo(new File(path.toString()));
				System.out.println("Image Uploaded to Product.....");
			}catch(Exception e)
			{
				e.printStackTrace();
				throw new RuntimeException("image saving failed ",e);
			}
		}
		
		System.out.println("path converting to string"+path);
		FileUtil.upload(path.toString(), file, product.getId() + ".jpg");
		System.out.println("path converted to string" + product.getId());
		
		return "redirect:/plist";
	}
	
	
	
	

	@RequestMapping("/plist")
	public String Allproducts(Model m) {
		System.out.println(" in list method");
		List<Product> productlist=productDAO.getAllproducts();
		List<Category> categorylist=categoryDAO.getAllCategory();
		List<Supplier> supplierlist=supplierDAO.getAllSuppliers();
		m.addAttribute("allproducts",productlist );
		m.addAttribute("categoryList",categorylist);
		m.addAttribute("supplierList",supplierlist);
		
	return "Product";	
	}
	
	@RequestMapping("editproduct-{id}")
	public String edit(@PathVariable("id") int id,Model m) {
		this.product=productDAO.getproduct(id);
		System.out.println(this.product.getId());
		m.addAttribute("product",productDAO.getproduct(id));
		return "Product";
		
	}
	@RequestMapping("deleteproduct-{id}")
	public String remove(@PathVariable("id") int id) {
		productDAO.deleteproduct(id);
		
		
		
		
		return "redirect:/plist";
		
	}
	
}
