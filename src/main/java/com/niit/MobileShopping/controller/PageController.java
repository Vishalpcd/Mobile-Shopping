package com.niit.MobileShopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller//it specifies that this class is a Controller for this project 
public class PageController {
	@RequestMapping(value={"/","/home","/index"})//provides url pattern for specific page as given below

	public ModelAndView index()//this holds Model and View i.e returns model and view in combined manner 
	{
		ModelAndView mv=new ModelAndView("page");//it will serach page as a name of the web page
		mv.addObject("message","This is the online shopping website for mobiles ");//message is attrbute name with value 
		return mv;
	}
}
