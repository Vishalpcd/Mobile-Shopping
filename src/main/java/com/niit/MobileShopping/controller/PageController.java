package com.niit.MobileShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.MobileShoppingBackend.DAO.CatDao;

@Controller//it specifies that this class is a Controller for this project 
public class PageController {
@Autowired//autowiring CatDao interface
private CatDao catDao;//making object of CatDao as catDao
@RequestMapping(value={"/home","/"})//provides url pattern for specific page as given below
	public ModelAndView index()//this holds Model and View i.e returns model and view in combined manner 
	{
		ModelAndView mv=new ModelAndView("home");//it will serach page as a name of the web page
		mv.addObject("title","home");//message is attrbute name with value
		mv.addObject("userClicksHome",true);
		
		//passing list of categories
		mv.addObject("Categories",catDao.list());
		return mv;
	}
	@RequestMapping(value={"/about"})//provides url pattern for specific page as given below

	public ModelAndView aboutPage()//this holds Model and View i.e returns model and view in combined manner 
	{
		ModelAndView mv=new ModelAndView("about");//it will serach page as a name of the web page
		mv.addObject("title","about");//message is attrbute name with value
		mv.addObject("userClicksAbout",true);
		return mv;
	}
	
	@RequestMapping(value={"/login"})//provides url pattern for specific page as given below

	public ModelAndView loginPage()//this holds Model and View i.e returns model and view in combined manner 
	{
		ModelAndView mv=new ModelAndView("login");//it will serach page as a name of the web page
		mv.addObject("title","login");//message is attrbute name with value
		mv.addObject("userClicksLogin",true);
		return mv;
	}
	@RequestMapping(value={"/signup"})//provides url pattern for specific page as given below

	public ModelAndView signupPage()//this holds Model and View i.e returns model and view in combined manner 
	{
		ModelAndView mv=new ModelAndView("signup");//it will serach page as a name of the web page
		mv.addObject("title","signup");//message is attrbute name with value
		mv.addObject("userClicksSignup",true);
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
	
		
}
