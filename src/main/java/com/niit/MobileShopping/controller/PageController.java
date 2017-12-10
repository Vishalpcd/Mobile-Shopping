package com.niit.MobileShopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.MobileShopping.exception.ProductNotFoundException;
import com.niit.MobileShopping.model.UserModel;
import com.niit.MobileShoppingBackend.DAO.AddressDAO;
import com.niit.MobileShoppingBackend.DAO.BrandDAO;
import com.niit.MobileShoppingBackend.DAO.CartLineDao;
import com.niit.MobileShoppingBackend.DAO.CatDao;
import com.niit.MobileShoppingBackend.DAO.ProductDAO;
import com.niit.MobileShoppingBackend.DAO.TypeDAO;
import com.niit.MobileShoppingBackend.DAO.UserDao;
import com.niit.MobileShoppingBackend.DTO.Address;
import com.niit.MobileShoppingBackend.DTO.Brand;
import com.niit.MobileShoppingBackend.DTO.Cart;
import com.niit.MobileShoppingBackend.DTO.Category;
import com.niit.MobileShoppingBackend.DTO.Product;
import com.niit.MobileShoppingBackend.DTO.Type;

@Controller // it specifies that this class is a Controller for this project
public class PageController {
	@Autowired // autowiring CatDao interface
	private CatDao catDao;// making object of CatDao as catDao
	@Autowired
	private ProductDAO productDao;
	@Autowired
	private BrandDAO brandDao;
	@Autowired
	private TypeDAO typeDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private AddressDAO addressDAO;
	@Autowired
	private CatDao cartDao;
	@Autowired
	private CartLineDao cartLineDao;
	
	@Autowired
	private HttpSession session;
	
	
	//return the cart of the user who logged in
	private Cart getCart()
	{
		
		return ((UserModel)session.getAttribute("userModel")).getCart();
	}
	
	

	@RequestMapping(value = { "/home", "/" }) // provides url pattern for
												// specific page as given below
	public ModelAndView index()// this holds Model and View i.e returns model
								// and view in combined manner
	{
		ModelAndView mv = new ModelAndView("DefaultPage");// it will search page
															// as a name of the
															// web page
		mv.addObject("title", "home");// message is attribute name with value
		mv.addObject("userClicksHome", true);
		mv.addObject("user", userDao.listActiveUsers());

		// passing list of Products list
		mv.addObject("Products", productDao.list());
		// passing list of categories
		mv.addObject("Categories", catDao.list());
		// getting the list of brands
		mv.addObject("Brands", brandDao.list());
		// getting the list of the type
		mv.addObject("Types", typeDao.list());
		return mv;
	}

	@RequestMapping(value = { "/about" }) // provides url pattern for specific
											// page as given below

	public ModelAndView aboutPage()// this holds Model and View i.e returns
									// model and view in combined manner
	{
		ModelAndView mv = new ModelAndView("DefaultPage");// it will search page
															// as a name of the
															// web page
		mv.addObject("title", "about");// message is attribute name with value
		mv.addObject("userClicksAbout", true);
		// passing list of Products list
		mv.addObject("Products", productDao.list());
		// passing list of categories
		mv.addObject("Categories", catDao.list());
		// getting the list of brands
		mv.addObject("Brands", brandDao.list());
		// getting the list of the type
		mv.addObject("Types", typeDao.list());

		return mv;
	}
	//for adding the address in the data base
	@RequestMapping(value="/Address",method=RequestMethod.GET)
	public ModelAndView addAddress()
	{
		ModelAndView mv=new ModelAndView("DefaultPage");
		mv.addObject("title", "Address");
		mv.addObject("UserClicksCheckOut", true);
		Cart cart=new Cart();
		Address nAddress=new Address();
		nAddress.setCartid(this.getCart().getId());
		mv.addObject("address", nAddress);
		return mv;
	}
	@RequestMapping(value="/Address",method=RequestMethod.POST)
	public String submitAddress(@Valid @ModelAttribute("address") Address maddress,BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			model.addAttribute("title","Error");
			model.addAttribute("message","Please fill the form as required ");
			model.addAttribute("UserClicksCheckOut",true);
			return "DefaultPage";
		}
		
		
		Cart cart=new Cart();
		//cartLineDao.deletCartforTheCheckout(this.getCart().getId());
		addressDAO.add(maddress);
		//cartLineDao.deletCartforTheCheckout(5/*this.getCart().getId()*/);
		model.addAttribute("UserClicksReceipt",true);
		model.addAttribute("title", "Receipt");
		model.addAttribute("message","Your Reciept is generated :) ");
		model.addAttribute("Address", maddress);
		return "DefaultPage";
	}
	@RequestMapping(value = { "/login" }) // provides url pattern for specific
											// page as given below

	public ModelAndView loginPage(@RequestParam(name = "error", required = false) String error)// this holds Model and View i.e returns	// model and view in combined manner
	{
		ModelAndView mv = new ModelAndView("DefaultPage");/* it will search page
															 as a name of the
															web page*/
		mv.addObject("title", "login");// message is attribute name with value
		mv.addObject("userClicksLogin", true);
		if(error!=null)
		{
			mv.addObject("title", "error");
			mv.addObject("message","incorrect email address and password !!");
		}
		
		
		// passing list of Products list
		mv.addObject("Products", productDao.list());
		// passing list of categories
		mv.addObject("Categories", catDao.list());
		// getting the list of brands
		mv.addObject("Brands", brandDao.list());
		// getting the list of the type
		mv.addObject("Types", typeDao.list());
		return mv;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPageSuccess() {
		ModelAndView mv = new ModelAndView("DefaultPage");
		mv.addObject("title", "LoginSuccessfull");
		mv.addObject("userClicksHome", true);
		// passing list of Products list
		mv.addObject("Products", productDao.list());
		// passing list of categories
		mv.addObject("Categories", catDao.list());
		// getting the list of brands
		mv.addObject("Brands", brandDao.list());
		// getting the list of the type
		mv.addObject("Types", typeDao.list());
		return mv;

	}
	
	
	//for logout 
	
	@RequestMapping(value="/logout")
	public ModelAndView logoutFunction(HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView mv=new ModelAndView("DefaultPage");
		mv.addObject("userClicksLogin", true);
		mv.addObject("title", "logged out");
		mv.addObject("message", "Logged out successfully thank you for visiting us :)");
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null)
		{
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		
		
		return mv;
	}

	/*
	 * Mapping for the show all products and category
	 * 
	 */
	@RequestMapping(value = { "/show/all/products" }) // provides url pattern
														// for specific page as
														// given below
	public ModelAndView ShowAllProducts()// this holds Model and View i.e
											// returns model and view in
											// combined manner
	{
		ModelAndView mv = new ModelAndView("DefaultPage");// it will search page
															// as a name of the
															// web page
		mv.addObject("title", "allProducts");// message is attribute name with
												// value
		mv.addObject("userClicksallProducts", true);
		// passing list of Products list
		mv.addObject("Products", productDao.list());
		// passing list of categories
		mv.addObject("Categories", catDao.list());
		// getting the list of brands
		mv.addObject("Brands", brandDao.list());
		// getting the list of the type
		mv.addObject("Types", typeDao.list());
		return mv;
	}

	// mapping for the edit products
	@RequestMapping(value = { "/edit/products" })
	public ModelAndView EditProducts() {
		ModelAndView mv = new ModelAndView("DefaultPage");
		mv.addObject("title", "Edit Product");
		mv.addObject("userClickseditProducts", true);
		// passing list of Products list
		mv.addObject("Products", productDao.list());
		// passing list of categories
		mv.addObject("Categories", catDao.list());
		// getting the list of brands
		mv.addObject("Brands", brandDao.list());
		// getting the list of the type
		mv.addObject("Types", typeDao.list());
		return mv;
	}
	/*
	 * Mapping the products by category id
	 */

	@RequestMapping(value = { "/show/category/{id}/products" })
	public ModelAndView ShowCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("DefaultPage");
		mv.addObject("title", "categoryProducts");// message is attribute name
													// with value
		mv.addObject("userClickscategoryProducts", true);

		// to fetch the categogry id to give the title name
		Category category = null;
		category = catDao.get(id);
		mv.addObject("title", category.getName());
		mv.addObject("category", category);// it will fetch category object
		mv.addObject("userClickscategoryProducts", true);
		// passing list of Products list
		mv.addObject("Products", productDao.list());
		// passing list of categories
		mv.addObject("Categories", catDao.list());
		// getting the list of brands
		mv.addObject("Brands", brandDao.list());
		// getting the list of the type
		mv.addObject("Types", typeDao.list());
		return mv;
	}

	@RequestMapping(value = { "/show/brand/{id}/products" })
	public ModelAndView ShowBrandProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("DefaultPage");
		mv.addObject("title", "brandProducts");// message is attribute name with
												// value
		mv.addObject("userClicksbrandProducts", true);
		Brand brand = null;
		brand = brandDao.get(id);
		mv.addObject("title", brand.getName());
		mv.addObject("brand", brand);
		// passing list of Products list
		mv.addObject("Products", productDao.list());
		// passing list of categories
		mv.addObject("Categories", catDao.list());
		// getting the list of brands
		mv.addObject("Brands", brandDao.list());
		// getting the list of the type
		mv.addObject("Types", typeDao.list());
		return mv;
	}

	@RequestMapping(value = { "/show/type/{id}/products" })
	public ModelAndView ShowTypeProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("DefaultPage");
		mv.addObject("title", "typeProducts");// message is attribute name with
												// value
		mv.addObject("userClickstypeProducts", true);
		Type type = null;
		type = typeDao.get(id);
		mv.addObject("title", type.getName());
		mv.addObject("type", type);
		mv.addObject("UserClicksType", true);
		// passing list of Products list
		mv.addObject("Products", productDao.list());
		// passing list of categories
		mv.addObject("Categories", catDao.list());
		// getting the list of brands
		mv.addObject("Brands", brandDao.list());
		// getting the list of the type
		mv.addObject("Types", typeDao.list());
		return mv;
	}

	@RequestMapping(value = { "/show/{id}/product" })
	public ModelAndView ShowProduct(@PathVariable("id") int id) throws ProductNotFoundException {
		ModelAndView mv = new ModelAndView("DefaultPage");
		mv.addObject("UserClickProduct", true);
		Product product = null;
		product = productDao.get(id);
		if (product == null)
			throw new ProductNotFoundException();
		mv.addObject("title", product.getName());
		product.setViews(product.getViews() + 1);
		// update the view count
		productDao.update(product);
		// to use product table or product class in jsp page
		mv.addObject("product", product);
		// passing list of Products list
		mv.addObject("Products", productDao.list());
		// passing list of categories
		mv.addObject("Categories", catDao.list());
		// getting the list of brands
		mv.addObject("Brands", brandDao.list());
		// getting the list of the type
		mv.addObject("Types", typeDao.list());

		return mv;
	}
	
	
//access denied 
@RequestMapping(value = { "/error" }) // provides url pattern for specific
// page as given below
public ModelAndView errorPage()// this holds Model and View i.e returns
// model and view in combined manner
{
ModelAndView mv = new ModelAndView("error");// it will search page
					// as a name of the
					// web page
mv.addObject("errorTitle", "403 acces denied ");
mv.addObject("errorDescription", "Access denied for this page please make sure you are requesting right page");


return mv;
}



	/*
	 * @RequestMapping(value={"/test/{message}"})//adding another pattern for
	 * opening the page.jsp page with message as variable so that it can called
	 * by /value instead of ? public ModelAndView
	 * test(@PathVariable(value="message",required=false)String
	 * message)//PathVariable is used for giving value at the run time and user
	 * can provide any value using url saperating url with / this marks and then
	 * providing any value in the url {//required=false given for indentifying
	 * the server that the value is not mendatory to specify for opening the
	 * page if(message==null)//testing for if message=null value then by default
	 * value of hi there string { message="Hi there "; } ModelAndView mv=new
	 * ModelAndView("page");//instantiating ModelAndView class with construct
	 * ModelAndView(String) mv.addObject("message",message);//calling the method
	 * addObject in parameter providing the value attribute and the value as the
	 * variable as message which will be assigned at the run time return mv; }
	 */

}
