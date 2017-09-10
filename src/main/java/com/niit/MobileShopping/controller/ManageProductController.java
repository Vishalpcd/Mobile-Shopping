package com.niit.MobileShopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.MobileShoppingBackend.DAO.BrandDAO;
import com.niit.MobileShoppingBackend.DAO.CatDao;
import com.niit.MobileShoppingBackend.DAO.TypeDAO;
import com.niit.MobileShoppingBackend.DTO.Brand;
import com.niit.MobileShoppingBackend.DTO.Category;
import com.niit.MobileShoppingBackend.DTO.Product;
import com.niit.MobileShoppingBackend.DTO.Type;

@Controller
@RequestMapping("/Manage")
public class ManageProductController {
	@Autowired
	private CatDao catDao;
	@Autowired
	private BrandDAO brandDao;
	@Autowired
	private TypeDAO typeDao;
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public ModelAndView showManageProducts()
	{
		ModelAndView mv=new ModelAndView("DefaultPage");
		mv.addObject("title","Manage Products");
		mv.addObject("userClicksManageProducts", true);
		Product nProduct=new Product();
		//setting few fields
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		mv.addObject("product", nProduct);
		
		
		return mv;
	}
	
	@ModelAttribute("categories")
	public List<Category> getCategories()
	{
		return catDao.list();
	}
	@ModelAttribute("brands")
	public List<Brand> getBrands()
	{
		return brandDao.list();
	}
	@ModelAttribute("types")
	public List<Type> getTypes()
	{
		return typeDao.list();
	}

}
