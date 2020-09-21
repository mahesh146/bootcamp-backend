package com.capg.greatoutdoor.cartmanagement.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.greatoutdoor.cartmanagement.exception.ProductNotFound;
import com.capg.greatoutdoor.cartmanagement.exception.UserNotFound;
import com.capg.greatoutdoor.cartmanagement.model.CartDTO;
import com.capg.greatoutdoor.cartmanagement.repository.ICartRepo;

/**
* CartServiceImp class implements the service interface and to access the cartRepository methods
*/
@Service
public class CartServiceImpl implements ICartManagementService {
	@Autowired
	private ICartRepo cartRepo;
	/**
	* Adding products to cart
	*/
	@Override
	public CartDTO addToCart(CartDTO cart) {
		boolean flag = false;
		HashMap<String, Integer> map = cart.getMyCart();
		Set<String> keys = map.keySet();
		List<String> keyList = new ArrayList<String>(keys);
		String productKey = "";
		if (cartRepo.existsById(cart.getUserId())) {
			CartDTO cartObject = cartRepo.getOne(cart.getUserId());
			Set<String> existingKeys = cartObject.getMyCart().keySet();
			for (String string : keys) {
				if (existingKeys.contains(string)) {
					productKey = string;
					flag = true;
					break;
				}
			}

			if (flag == true) {
				int q = cartObject.getMyCart().get(productKey) + map.get(productKey);
				cartObject.getMyCart().replace(productKey, q);
				return cartRepo.save(cartObject);
			} else {
				for (String string : keyList) {
					cartObject.getMyCart().put(string, map.get(string));
				}

				return cartRepo.save(cartObject);
			}
		} else {

			return cartRepo.save(cart);
		}
	}
	/**
	* Removing products from cart
	*/
	@Override
	public boolean removeFromCart(String userId, String productId) throws ProductNotFound, UserNotFound {
		boolean flag = false;
		if (cartRepo.existsById(userId)) {
			CartDTO cartdto = cartRepo.getOne(userId);
			Set<String> keys = cartdto.getMyCart().keySet();
			if (keys.contains(productId)) {
				cartdto.getMyCart().remove(productId);
				cartRepo.save(cartdto);
				flag = true;
			} else {
				throw new ProductNotFound("product not found");
			}
		} else {
			throw new UserNotFound("invalid user");
		}

		return flag;
	}
	/**
	* fetching all products from cart
	*/
	@Override
	public CartDTO viewAllProductsInCart(String userId) throws UserNotFound {

		if (cartRepo.existsById(userId)) {
			CartDTO cartdto = cartRepo.getOne(userId);
			return cartdto;
		} else {
			throw new UserNotFound("invalid user");
		}

	}
}
