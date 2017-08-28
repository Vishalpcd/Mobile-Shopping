package com.niit.MobileShopping.controller;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.MobileShoppingBackend.DAO.CatDao;
import com.niit.MobileShoppingBackend.DAO.ProductDAO;
import com.niit.MobileShoppingBackend.DTO.Category;
import com.niit.MobileShoppingBackend.DTO.Product;
import com.sun.mail.iap.Response;

@Controller//it specifies that this class is a Controller for this project 
public class PageController {
	@Autowired//autowiring CatDao interface
	private CatDao catDao;//making object of CatDao as catDao
	@Autowired
	private ProductDAO productDao;
@RequestMapping(value={"/home","/"})//provides url pattern for specific page as given below
	public ModelAndView index()//this holds Model and View i.e returns model and view in combined manner 
	{
		ModelAndView mv=new ModelAndView("DefaultPage");//it will search page as a name of the web page
		mv.addObject("title","home");//message is attribute name with value
		mv.addObject("userClicksHome",true);
		
		//passing list of Products list
		mv.addObject("Products",productDao.list());
		//passing list of categories
		mv.addObject("Categories",catDao.list());
		return mv;
	}
	@RequestMapping(value={"/about"})//provides url pattern for specific page as given below

	public ModelAndView aboutPage()//this holds Model and View i.e returns model and view in combined manner 
	{
		ModelAndView mv=new ModelAndView("DefaultPage");//it will search page as a name of the web page
		mv.addObject("title","about");//message is attribute name with value
		mv.addObject("userClicksAbout",true);
		return mv;
	}
	
	@RequestMapping(value={"/login"})//provides url pattern for specific page as given below

	public ModelAndView loginPage()//this holds Model and View i.e returns model and view in combined manner 
	{
		ModelAndView mv=new ModelAndView("DefaultPage");//it will search page as a name of the web page
		mv.addObject("title","login");//message is attribute name with value
		mv.addObject("userClicksLogin",true);
		return mv;
	}
	@RequestMapping(value={"/signup"})//provides url pattern for specific page as given below

	public ModelAndView signupPage()//this holds Model and View i.e returns model and view in combined manner 
	{
		ModelAndView mv=new ModelAndView("DefaultPage");//it will search page as a name of the web page
		mv.addObject("title","signup");//message is attribute name with value
		mv.addObject("userClicksSignup",true);
		
		
		return mv;
		
	}
	/*
	 * Mapping for the show all products and category
	 * 
	 * */
	@RequestMapping(value={"/show/all/products"})//provides url pattern for specific page as given below
	public ModelAndView ShowAllProducts()//this holds Model and View i.e returns model and view in combined manner 
	{
		ModelAndView mv=new ModelAndView("DefaultPage");//it will search page as a name of the web page
		mv.addObject("title","allProducts");//message is attribute name with value
		mv.addObject("userClicksallProducts",true);
		
		
		
		return mv;
	}
	/*
	 * Mapping the products by category id 
	 * */

	@RequestMapping(value={"/show/category/{id}/products"})
	public ModelAndView ShowCategoryProducts(@PathVariable("id") int id){
		ModelAndView mv=new ModelAndView("DefaultPage");
		//to fetch the categogry id to give the title name 
		Category category=null;
		category=catDao.get(id);
		mv.addObject("title",category.getName());
		mv.addObject("category",category);//it will fetch category object
		mv.addObject("userClickscategoryProducts",true);
		return mv;
	}
	@RequestMapping(value={"/show/brand/{id}/products"})
	public ModelAndView ShowBrandProducts(@PathVariable("id") int id)
	{
		ModelAndView mv=new ModelAndView("DefaultPage");
		Product product=null;
		product=productDao.get(id);
		mv.addObject("title",product.getBrand());
		mv.addObject("product", product);
		mv.addObject("userClicksbrandProducts", true);
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
