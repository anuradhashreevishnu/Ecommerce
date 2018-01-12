package com.niit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.SupplierDao;
import com.niit.model.Supplier;

@Controller
public class SupplierController {
@Autowired
private SupplierDao supplierDAO;
@Autowired
private Supplier supplier;
	
@RequestMapping("/Supplier")
public String prform(Model model) {
return "Supplier";
}
	
@RequestMapping("/getSuppliers")
public String Listsupplier(Model model) {
model.addAttribute("supplierList", this.supplierDAO.getAllSuppliers());
return "Supplier";
}
	
@ModelAttribute("supplier")
public Supplier getsupplierForm() {
 return new Supplier();
}
@RequestMapping(value = "/addsupplier", method = RequestMethod.POST)
 public ModelAndView saveSupplier(@ModelAttribute("supplier") Supplier supplier) {
 //if(user.getUsername()=="")
 // {
System.out.println(supplier.getSupplier_id());
System.out.println(supplier.getSuppliername());
supplierDAO.addSupplier(supplier);
//} else {
//userDao.updateUser(user);
 //}
 return new ModelAndView("redirect:/getSuppliers");
}
 @RequestMapping("/updatesup-{id}")
 public String modifyCategory(@PathVariable("id") int id,Model m){
	    		
this.supplier=this.supplierDAO.getSupplier(id);
 m.addAttribute("supplier", supplierDAO.getSupplier(id));
 m.addAttribute("listSupplier", this.supplierDAO.getAllSuppliers());
				
				
System.out.println(supplierDAO.getSupplier(id).getSupplier_id());
 return "Supplier";
}
	    	
	    	
@RequestMapping("/deletesup-{supplierid}")
 public String deleteCategory(@PathVariable("supplierid") int supplierid){
this.supplierDAO.deleteSupplier(supplierid);
return "redirect:/getSuppliers";
 }

}
