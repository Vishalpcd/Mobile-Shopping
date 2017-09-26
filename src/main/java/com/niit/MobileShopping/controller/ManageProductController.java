package com.niit.MobileShopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.MobileShopping.util.FileUploadUtility;
import com.niit.MobileShopping.validator.ProductValidator;
import com.niit.MobileShoppingBackend.DAO.BrandDAO;
import com.niit.MobileShoppingBackend.DAO.CatDao;
import com.niit.MobileShoppingBackend.DAO.ProductDAO;
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
	@Autowired
	private ProductDAO productDao;
	
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
	
	
	//submit product to the data base 
	@RequestMapping(value="/products",method=RequestMethod.POST)
	public String SubmitProduct(@Valid @ModelAttribute("product") Product mProduct,BindingResult result,Model model,HttpServletRequest request)//mis for modified product 
	{
		 new  ProductValidator().validate(mProduct, result);//calling the ProductValidaor class and giving command to valide for mProduct and get result
		//checking the result 
		if(result.hasErrors())
		{
			model.addAttribute("title", "Manage Products");
			model.addAttribute("userClicksManageProducts", true);
			return "DefaultPage";
		}
		productDao.add(mProduct);
		//if image is select then
		if(!mProduct.getFile().getOriginalFilename().equals(""))
		{
			//passing the request ,file and code from the mProduct it is overrided in the FileUploadUtitlity class which will be generated after clicking on the  submit button
			FileUploadUtility.uploadFile(request,mProduct.getFile(),mProduct.getCode());
		}
		
		
		
		return "redirect:/Manage/products";
	}
	
	@RequestMapping(value="/product/{id}/activation",method=RequestMethod.POST)
	public String ActivateOrDeactivateProduct(@PathVariable int id )
	{
		//is going to fetch the product from the data base
		Product product=productDao.get(id);
		//checking the actual value of the product
		boolean isActive=product.isActive();
		product.setActive(!product.isActive());
		productDao.update(product);
		
		return "";
	}
	//what to do when new brand is saved in database 
	@RequestMapping(value="/brand",method=RequestMethod.GET)
	public ModelAndView showBrand()
	{
		ModelAndView mv=new ModelAndView("DefaultPage");
		mv.addObject("title", "Manage brand");
		mv.addObject("userClicksManageBrands", true);
		Brand nBrand=new Brand();
		
		nBrand.setActive(true);
		mv.addObject("brand", nBrand);
		return mv;
	}
	//if error is there then how to handle and the save the product by post method 
	@RequestMapping(value="/brand",method=RequestMethod.POST)
	public String SubmitBrand(@Valid @ModelAttribute("brand") Brand mBrand,BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			model.addAttribute("title", "Manage Brand");
			model.addAttribute("userClicksManageBrands", true);
			return  "DefaultPage";
		}
		brandDao.add(mBrand);
		return "redirect:/Manage/brand";
		
	}
	

}
