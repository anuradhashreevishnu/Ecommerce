package com.niit.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.dao.CartDao;
import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.model.Cart;
import com.niit.model.Category;
import com.niit.model.Product;
@Controller
public class CartController {
	
	 @Autowired(required = true)
		Cart cart;
		
		@Autowired(required = true)
		private CartDao cartDAO;
		
		@Autowired(required = true)
		private CategoryDao categoryDAO;
		
		@Autowired
		private Product product;
		
		@Autowired(required = true)
		private ProductDao productDAO;
		@RequestMapping(value="/myCart{userID}", method = RequestMethod.GET)
		public String cartuserlistfunc(@PathVariable("userID") String userID, Model model)
		{
			model.addAttribute("userscartlists", this.cartDAO.usercartlist(userID));
			return "cart";
		}
		@RequestMapping(value = "/myCart", method = RequestMethod.GET)
		public String myCart(Model model , Principal principal) {
			model.addAttribute("category", new Category());
			model.addAttribute("categoryList",categoryDAO.getAllCategory());
		
			model.addAttribute("cart", new Cart());
			model.addAttribute("cartList", this.cartDAO.usercartlist(principal.getName()));
		//	model.addAttribute("totalAmount", cartDAO.getTotalAmount("user")); // Just to test, password user
			model.addAttribute("displayCart", "true");
			int i,j=0;
			int s=0;
			int n=cartDAO.usercartlist(principal.getName()).size();
			System.out.println(n);
			for(i=0;i<n;i++)
			{
				s=s+cartDAO.usercartlist(principal.getName()).get(i).getPrice();
				
			}
			System.out.println(s);
			model.addAttribute("sum", s);
			
			
			return "Cart";
		}
		@RequestMapping(value= "/cart/add/{id}", method = RequestMethod.GET)
		public String addToCart(@PathVariable("id") int id,HttpServletRequest request, Model model , Principal principal){
			
		
		 Product product =	 productDAO.getproduct(id);
		 Cart cart = new Cart();
		 cart.setProductName(product.getProductname());
		 cart.setPrice(product.getPrice());
		 cart.setCartproduct_id(product.getId());
		 cart.setQuantity("1");
		 cart.setUserID(principal.getName());  //  id should keep session and use the same id
		 	cartDAO.saveOrUpdate(cart);
			//return "redirect:/views/home.jsp";
			System.out.println("connect to controller");
			
			model.addAttribute("cart", new Cart());
			model.addAttribute("cartList", this.cartDAO.usercartlist(principal.getName()));
			
			
			int i,j=0;
			int s=0;
			int n=cartDAO.usercartlist(principal.getName()).size();
			System.out.println(n);
			for(i=0;i<n;i++)
			{
				s=s+cartDAO.usercartlist(principal.getName()).get(i).getPrice();
				
			}
			System.out.println(s);
			model.addAttribute("sum", s);
			
			
			return "redirect:/myCart";
			
			
		}
		@RequestMapping("/cart/delete/{id}")
		public String deleteCart(@PathVariable("id") int id,Model model, Principal principal)
	{
		
			cartDAO.delete(id);
			
			int i,j=0;
			int s=0;
			int n=cartDAO.usercartlist(principal.getName()).size();
			System.out.println(n);
			for(i=0;i<n;i++)
			{
				s=s+cartDAO.usercartlist(principal.getName()).get(i).getPrice();
				
			}
			System.out.println(s);
			model.addAttribute("sum", s);
			
			
			 return "redirect:/myCart";
	}
		@RequestMapping(value = "/checkout", method = RequestMethod.GET)
		public String checkout(Model model , Principal principal) {
		    
			int i,j=0;
			int s=0;
			int n=cartDAO.list().size();
			System.out.println(n);
			for(i=0;i<n;i++)
			{
				s=s+cartDAO.list().get(i).getPrice();
				
			}
			System.out.println(s);
			model.addAttribute("sum", s);
			model.addAttribute("cart", new Category());
			model.addAttribute("cartList", this.cartDAO.usercartlist(principal.getName()));
			//model.addAttribute("total", this.cartDAO.getTotalAmount("id"));
			
		
			
			//System.out.println(U);
			return "/checkout";
		}
		@RequestMapping(value = "/logout2", method = RequestMethod.GET)
		public String logout2(Model model) {
		
			
			
			
		
			
			//System.out.println(U);
			return "/logout";
		}

		@RequestMapping("/logout")
		public String logout(Model model)
		{
			int i,s=0,j=0;
			int n=cartDAO.list().size();
			System.out.println(n);
			for(i=0;i<n;i++)
			{
				s=s+cartDAO.list().get(i).getPrice();
				
			}
			System.out.println(s);
			model.addAttribute("sum", s);
			while(n!=0)
			{
				cartDAO.delete(cartDAO.list().get(j).getId());
				n=cartDAO.list().size();
				
			}
			return "logout";
		}
		
		
		
		
		
		
		
}
