package com.capg.greatoutdoor.cartmanagement.service;

import java.util.List;

import com.capg.greatoutdoor.cartmanagement.exception.ProductNotFound;
import com.capg.greatoutdoor.cartmanagement.exception.UserNotFound;
import com.capg.greatoutdoor.cartmanagement.model.CartDTO;

public interface ICartManagementService {
	public CartDTO addToCart(CartDTO cart);

	public boolean removeFromCart(String userId, String productId) throws ProductNotFound, UserNotFound;

	public CartDTO viewAllProductsInCart(String userId) throws UserNotFound;
}
