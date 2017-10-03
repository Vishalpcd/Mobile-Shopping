package com.niit.MobileShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.MobileShopping.service.CartLineService;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartLineService cartLineService;
	@RequestMapping(value="/show")
	public ModelAndView showCart(@RequestParam(name="result", required=false)String result)
	{
		
		ModelAndView mv=new ModelAndView("DefaultPage");
		if(result!=null)
		{
		if(result.equals("added"))
		{
			mv.addObject("message", "product is added succesfully in the cart :)");
		}
		if(result.equals("already"))
		{
			mv.addObject("message","product is already available in the cart");
		}
		if(result.equals("removed"))
		{
			mv.addObject("message", "Product is removed succesfully from the cart ");
		}
		if(result.equals("removeFailed"))
		{
			mv.addObject("message", "failed to remove the product from the cart ");
		}
		}
		mv.addObject("title", "cart");
		mv.addObject("userClicksCart", true);
		mv.addObject("cartLines",cartLineService.getCartLines());
		return mv;
	}
	@RequestMapping(value="/add/{product_id}/product")
	public String addToCart(@PathVariable int product_id)
	{
		String response=cartLineService.addCart(product_id);
		return "redirect:/cart/show?"+response;
	}
	@RequestMapping(value="/{id}/remove")
	public String removeCartLine(@PathVariable int id)
	{
		String response=cartLineService.removeCart(id);
		return "redirect:/cart/show?"+response;
	}

}
