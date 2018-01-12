package com.niit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.PaymentDao;
import com.niit.model.Payment;

@Controller
public class PaymentController {
	@Autowired
	PaymentDao paymentDAO;
    @ModelAttribute("payment")
	public Payment paymodel()
	{
		System.out.println("created payment model");
		return new Payment();
	}

	@RequestMapping("/payment")
	public ModelAndView pay()
	{
		ModelAndView mv = new ModelAndView("Payment");
		return mv;
	}

	@RequestMapping(value="/addpayment", method=RequestMethod.POST)
	public ModelAndView addpaymentfunc(@ModelAttribute("payment") Payment payment)
	{
		
		paymentDAO.paymentsave(payment);
		ModelAndView mv = new ModelAndView("Thanks");
		return mv;
	}		

}
