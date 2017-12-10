package com.niit.MobileShopping.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.niit.MobileShopping.model.UserModel;
import com.niit.MobileShoppingBackend.DAO.UserDao;
import com.niit.MobileShoppingBackend.DTO.User;
//this is the annotation for the globalController 
@ControllerAdvice
public class GlobalController {
	
	@Autowired
	private HttpSession session;
	@Autowired
	private UserDao userDao;
	
	private UserModel userModel=null;
	
	//for login to the global i.e globally available for all the controller 
	@ModelAttribute("userModel")
	public UserModel getUserModel()
	{
		if(session.getAttribute("userModel")==null)
		{
			userModel = new UserModel();
			//need to set the usermodel
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			//it will return emailid as user name
			User user=userDao.getByEmail(authentication.getName());
			if(user!=null)//if the user is present
			{
				//create a new user model
				userModel.setId(user.getId());
				userModel.setEmail(user.getEmail());
				userModel.setRole(user.getRole());
				userModel.setFullName(user.getFirstName()+" "+user.getLastName());
				//set the userModel in the session
				if(userModel.getRole().equals("USER"))
				{
					userModel.setCart(user.getCart());
				}
				session.setAttribute("userModel", userModel);
				return userModel;
			}
		}
		//if session is already there then return it 
		return (UserModel)session.getAttribute("userModel");
		
		//for address and user details write code here after creating the addressmodel class 
		
	}

}
