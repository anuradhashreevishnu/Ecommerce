package com.niit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.UserDao;
import com.niit.model.Product;
import com.niit.model.User;

@Controller
public class Usercontroller {
	@Autowired
	 UserDao userDAO;
	@Autowired
	private User user;
	@RequestMapping("/newuser")
	public String name() {
		return "User";
	}
	@RequestMapping(value="/Register",method=RequestMethod.POST)
	 public String save(@ModelAttribute("user") User user){
		System.out.println(user.getUsermailid());
		System.out.println(user.getUsername());
		userDAO.addUser(user);
		
		return "redirect:/ulist";
	}
	@ModelAttribute("user")
	public User form(){
		return new User();
		
	}
	
	@RequestMapping("/ulist")
	private String pub(Model m) {
		List<User> userlist=userDAO.getAllUsers();
		m.addAttribute("alluser",userlist );
		return "User";
	}
	@RequestMapping("/login")
	public String f3()
	{
		return "Login";
	}
	@RequestMapping(value = "/loginUser")
    public String login(@RequestParam(value="error", required = false) String error, @RequestParam(value="logout",
            required = false) String logout, Model model) {
        if (error!=null) {
        	System.out.println("Error.....");
            model.addAttribute("error", "...Invalid username and password");
        }
        	
        if(logout!=null) {
        	System.out.println("Logout called.....");
            model.addAttribute("msg", "...You have been logged out");
        }

        return "Login";
 }
}
