package com.niit.MobileShopping.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility  {
	//where the image will be stored 
	private static final String ABS_PATH="C:\\Users\\visha\\Desktop\\MyProject\\MobileShopping\\src\\main\\webapp\\assets\\images\\";
	//from this path server will fetch images 
	private static String REAL_PATH="";
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		//to get the real and saying that save the file which is requested by the client
		REAL_PATH=request.getSession().getServletContext().getRealPath("assets/images");
		try{
			//for the server upload 
			file.transferTo(new File( REAL_PATH + code + ".jpg"));
			//for image stored in the absolute path
			file.transferTo(new File(ABS_PATH + code + ".jpg"));
		}
		catch(Exception ex){
			
			
		}
	}

}
