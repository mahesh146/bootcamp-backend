package com.capg.greatoutdoor.cartmanagement.model;

import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.Id;
/**
* CartDTO bean class
*/
@Entity
public class CartDTO {
	@Id
	private String userId;
	HashMap<String, Integer> myCart = new HashMap<>();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((myCart == null) ? 0 : myCart.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartDTO other = (CartDTO) obj;
		if (myCart == null) {
			if (other.myCart != null)
				return false;
		} else if (!myCart.equals(other.myCart))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	public CartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartDTO(String userId, HashMap<String, Integer> details) {
		super();
		this.userId = userId;
		this.myCart = details;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public HashMap<String, Integer> getMyCart() {
		return myCart;
	}

	public void setMyCart(HashMap<String, Integer> details) {
		this.myCart = details;
	}

	@Override
	public String toString() {
		return "CartDTO [userId=" + userId + ", details=" + myCart + "]";
	}

}
