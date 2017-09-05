package com.niit.MobileShopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.MobileShoppingBackend.DAO.ProductDAO;
import com.niit.MobileShoppingBackend.DTO.Product;

//to say the server that this is the controller class 
@Controller
//to say the server that all mapping should start with the following mapping
@RequestMapping("/json/data")
public class JsonDataController {
	//for retrieving the data from the DAO interface Autowiring the Interfacce
	@Autowired
	private ProductDAO productDao;
	@RequestMapping("/all/products")
	//it will generate the structure for the list automatically we don't need to define the ModelAndView like we have done in PageController
	@ResponseBody
	public List<Product> getAllProducts()
	{
		return productDao.list();
	}

	//for getting the all products by its ctegory id 
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable int id)
	{
		return productDao.listActiveProductsByCategory(id);
	}
	//for getting the all products by its brand id 
	@RequestMapping("/brand/{id}/products")
	@ResponseBody
	public List<Product> getProductsByBrand(@PathVariable int id)
	{
		return productDao.listAcitveProductsByBrandId(id);
	}
	//for getting the products by type id 
	@RequestMapping("/type/{id}/products")
	@ResponseBody
	public List<Product> getProductsByType(@PathVariable int id)
	{
		return productDao.listActiveProductsByTypeId(id);
	}
}
