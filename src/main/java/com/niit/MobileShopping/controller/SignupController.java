package com.niit.MobileShopping.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.MobileShoppingBackend.DAO.UserDao;
import com.niit.MobileShoppingBackend.DTO.Brand;
import com.niit.MobileShoppingBackend.DTO.Cart;
import com.niit.MobileShoppingBackend.DTO.Product;
import com.niit.MobileShoppingBackend.DTO.User;

@Controller
public class SignupController {

	@Autowired
	private UserDao userDao;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	//to get the value for the path i.e it will compare the  value 
	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public ModelAndView signupSuccess()
	{
		ModelAndView mv=new ModelAndView("DefaultPage");
		mv.addObject("title","signup Successfull");
		mv.addObject("userClicksSignup", true);
		User nuser=new User();
		//setting few fields
		nuser.setEnabled(true);
		nuser.setRole("USER");
		mv.addObject("user", nuser);
		return mv;
	}
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String submitUser(@Valid @ModelAttribute("user") User muser,BindingResult result,Model model)
	{
		
		if(result.hasErrors())
		{
			model.addAttribute("title"," signup failed ");
			model.addAttribute("userClicksSignup", true);
			return "DefaultPage";
		}
		if(userDao.getByEmail(muser.getEmail())!=null)
		{
			model.addAttribute("message","email id is already exist please re-enter different email address !!");
		}
					
			Cart cart=new Cart();
			//encrypting the password before saving it to database 
			muser.setPassword(passwordEncoder.encode(muser.getPassword()));
			//because it is bi-directional thats we need set user id as foreign key in the cart and cart id as foreign key in the user table 
			cart.setUser(muser);
			muser.setCart(cart);
			userDao.add(muser);
			//setting the userid as foreign key in the cart table 
			model.addAttribute("message", "Signup successfull  :) please login to go for shopping");
			model.addAttribute("title", "signup Successfull");
			model.addAttribute("userClicksLogin", true);
		
			return "DefaultPage";
	}
}
