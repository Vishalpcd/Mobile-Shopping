package com.niit.MobileShopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller//it specifies that this class is a Controller for this project 
public class PageController {
	@RequestMapping(value={"/home"})//provides url pattern for specific page as given below

	public ModelAndView index()//this holds Model and View i.e returns model and view in combined manner 
	{
		ModelAndView mv=new ModelAndView("home");//it will serach page as a name of the web page
		mv.addObject("message","This is the online shopping website for mobiles ");//message is attrbute name with value 
		return mv;
	}
	
	/*@RequestMapping(value={"/test/{message}"})//adding another pattern for opening the page.jsp page with message as variable so that it can called by /value instead of ?
	public ModelAndView test(@PathVariable(value="message",required=false)String message)//PathVariable is used for giving value at the run time and user can provide any value using url saperating url with / this marks and then providing any value in the url 
	{//required=false given for indentifying the server that the value is not mendatory to specify for opening the page
		if(message==null)//testing for if message=null value then by default value of hi there string 
		{
			message="Hi there ";
		}
		ModelAndView mv=new ModelAndView("page");//instantiating ModelAndView class with construct ModelAndView(String)
		mv.addObject("message",message);//calling the method addObject in parameter providing the value attribute and the value as the variable as message which will be assigned at the run time  
		return mv;
	}*/
	
	@RequestMapping(value={"/test"})//adding another pattern for opening the page.jsp page
	public ModelAndView test(@RequestParam(value="message",required=false)String message)//request param is used for giving value at the run time and user can provide any value using url saperating url with ? this marks and then providing any value in the url 
	{//required=false given for indentifying the server that the value is not mendatory to specify for opening the page
		if(message==null)//testing for if message=null value then by default value of hi there string 
		{
			message="Hi there ";
		}
		ModelAndView mv=new ModelAndView("page");//instantiating ModelAndView class with construct ModelAndView(String)
		mv.addObject("message",message);//calling the method addObject in parameter providing the value attribute and the value as the variable as message which will be assigned at the run time  
		return mv;
	}
	
	
}
