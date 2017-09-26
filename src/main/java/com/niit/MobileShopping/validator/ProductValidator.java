//we cannot use hibernate validator for the  image since we are not storing it to data base thats why we need a custom validator  for image upload
package com.niit.MobileShopping.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.niit.MobileShoppingBackend.DTO.Product;

public class ProductValidator implements Validator {

	//for which class is this class is going to support for the validation
	@Override
	public boolean supports(Class<?> clazz) {
		
		return Product.class.equals(clazz);
	}

	//what is the validation and when the validation comes  in the picture in web page 
	@Override
	public void validate(Object target, Errors errors) {
		Product product=(Product) target;//typecasting the target object to the Product so all the product validation it can handle 
		if(product.getFile()==null || product.getFile().getOriginalFilename().equals(""))
		{
			errors.rejectValue("file", null, "Please select file to upload ");// 1st parameter is  rejecting the file and 3rd is to show message 
			return;//because this the void method 
		}
		//if other this file type is selected then throw an error as given below code 
		if(!(product.getFile().getContentType().equals("image/jpeg")||
				product.getFile().getContentType().equals("image/png")||
				product.getFile().getContentType().equals("image/gif")))
		{
			errors.rejectValue("file", null, "Please upload image file only ");
			return;
		}
	}

}
