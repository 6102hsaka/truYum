package com.cognizant.truyum.service;

import java.util.List;

import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

public interface CartService {
	
	void addCartItem(long userId,long menuItemId);
	List<MenuItem> getAllCartItems(long userId)throws CartEmptyException;
	void removeCartItem(long userId,  long menuItemId);

}
