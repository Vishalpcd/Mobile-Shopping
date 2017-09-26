package com.niit.MobileShopping.controller;

import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.MobileShoppingBackend.DAO.UserDao;
import com.niit.MobileShoppingBackend.DTO.User;

//to say that this class is going to used as controller
@Controller
public class UserController {
	@Autowired
	private UserDao userDao;
	@RequestMapping(value="/user/login",method=RequestMethod.POST)
	public ModelAndView loginUser( HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView mv=new ModelAndView("DefaultPage");
		User user=null;
		String em=request.getParameter("email");
		String ps=request.getParameter("password");
		
		//User name=userDao.getname(em);//not working 
		//if success login 
		if(userDao.getUserDetails(em,ps)==true)
		{
			mv.addObject("title","succesfull");
			mv.addObject("userClicksHome", true);
			//mv.addObject("name", name);
			return mv;
		}
		else
		{
		//if credentials not match with db data
			mv.addObject("message", "Error while login please enter correct credentials!!!!");
			mv.addObject("userClicksLogin", true);
			return mv;
		}
		
		
		
	}
	

}
