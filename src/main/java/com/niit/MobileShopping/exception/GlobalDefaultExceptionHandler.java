/*
 * if exception occurs 
 * */
package com.niit.MobileShopping.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
//if error occurred take advice from this controller
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandleFoundException()
	{
		ModelAndView mv= new ModelAndView("error");
		mv.addObject("title","404 not found");
		mv.addObject("errorTitle", "404 not found error");
		mv.addObject("errorDescription", "Please enter correct url");
		return mv;
	}
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException()
	{
		ModelAndView mv= new ModelAndView("error");
		mv.addObject("title","Product :( not found");
		mv.addObject("errorTitle", "Product is not avl");
		mv.addObject("errorDescription", "Product is not avalable keep shopping we add products very frequently :)");
		return mv;
	}
	
	//global exception
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex)
	{
		ModelAndView mv= new ModelAndView("error");
		mv.addObject("title","Error");
		mv.addObject("errorTitle", "Please check your command");
		mv.addObject("errorDescription", ex.toString());
		return mv;
	}
	
	
	

}
