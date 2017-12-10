package com.niit.MobileShopping.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.MobileShopping.model.UserModel;
import com.niit.MobileShoppingBackend.DAO.CartLineDao;
import com.niit.MobileShoppingBackend.DAO.ProductDAO;
import com.niit.MobileShoppingBackend.DTO.Cart;
import com.niit.MobileShoppingBackend.DTO.CartLine;
import com.niit.MobileShoppingBackend.DTO.Product;

@Service("cartLineService")
public class CartLineService {

	@Autowired
	private CartLineDao cartLineDao;
	@Autowired
	private ProductDAO productDao;
	@Autowired
	private HttpSession session;
	
	
	//return the cart of the user who logged in
	private Cart getCart()
	{
		
		return ((UserModel)session.getAttribute("userModel")).getCart();
	}
	//returns the cartLine list by the cart id 
	public List<CartLine> getCartLines()
	{
		return cartLineDao.list(this.getCart().getId());
	}
	public String addCart(int product_id) {
		String response=null;
		Cart cart=this.getCart();
		CartLine cartLine=cartLineDao.getByProductIdAndCartId(cart.getId(), product_id);
		if(cartLine==null)
		{
			//adding the new cartline 
			cartLine=new CartLine();
			//fetching the product
			Product product=productDao.get(product_id);
			cartLine.setCart_id(cart.getId());
			cartLine.setPrice(product.getUnitPrice());
			cartLine.setProduct(product);
			cartLine.setProduct_count(1);
			cartLine.setTotal(product.getUnitPrice());
			cartLine.setAvailable(true);
			cartLineDao.add(cartLine);
			cart.setCartline_id(cart.getCartline_id()+1);
			cart.setGrandTotal(cart.getGrandTotal()+cartLine.getPrice());
			cartLineDao.update(cart);
			response="result=added";
		}
		else
		{
			response="result=already";
		}
		
		return response;
	}
	public String removeCart(int id) {
		String response=null;
		Cart cart=this.getCart();
		CartLine cartLine=cartLineDao.get(id);
		boolean rmv=cartLineDao.delete(cartLine);
		if(rmv==true)
		{
			cart.setCartline_id(cart.getCartline_id() -1);
			cart.setGrandTotal(cart.getGrandTotal()- cartLine.getPrice());
			cartLineDao.update(cart);
			response="result=removed";
			
		}
		else
		{
			response="result=removeFailed";
		}
		return response;
	}
}
