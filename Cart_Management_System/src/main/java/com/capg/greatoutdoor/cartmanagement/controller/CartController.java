package com.capg.greatoutdoor.cartmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.greatoutdoor.cartmanagement.exception.ProductNotFound;
import com.capg.greatoutdoor.cartmanagement.exception.UserNotFound;
import com.capg.greatoutdoor.cartmanagement.model.CartDTO;
import com.capg.greatoutdoor.cartmanagement.service.ICartManagementService;

/**
* CartController class used for accessing the service methods
*/
@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private ICartManagementService service;

	@PostMapping("/addtocart")
	public CartDTO addToCart(@RequestBody CartDTO cart) {

		return service.addToCart(cart);
	}
	/**
	* removing products from  cart
	*/
	@DeleteMapping("/remove/user/{userid}/productid/{productid}")
	public void removeFromCart(@PathVariable String userid ,@PathVariable String productid) throws ProductNotFound, UserNotFound {
		
			service.removeFromCart(userid,productid);
		
	}
	@GetMapping("/getallproducts/userid/{userId}")
	public CartDTO viewAllProductsInCart(@PathVariable String userId) throws UserNotFound{
		return service.viewAllProductsInCart(userId);
	}
	
 }
