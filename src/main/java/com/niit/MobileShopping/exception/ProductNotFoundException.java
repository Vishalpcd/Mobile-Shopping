package com.niit.MobileShopping.exception;

public class ProductNotFoundException extends Exception {

	/**
	 * serialisable id 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	public ProductNotFoundException()
	{
		this("Product not found");
	}
	public ProductNotFoundException(String message)
	{
		this.message=System.currentTimeMillis()+": "+message;
	}
	public String getMessage() {
		return message;
	}
	
	

}
