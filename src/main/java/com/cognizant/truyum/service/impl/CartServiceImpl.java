package com.cognizant.truyum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartDao;
	
	@Override
	public void addCartItem(long userId, long menuItemId) {
		cartDao.addCartItem(userId, menuItemId);

	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		return cartDao.getAllCartItems(userId);
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		cartDao.removeCartItem(userId, menuItemId);
	}

}
