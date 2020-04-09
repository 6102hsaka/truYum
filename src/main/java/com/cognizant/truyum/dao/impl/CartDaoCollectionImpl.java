package com.cognizant.truyum.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao {
	
	@Autowired
	private MenuItemDao menuItemDao;
	
	private HashMap<Long, Cart> userCarts = new HashMap<Long, Cart>();
	
	public CartDaoCollectionImpl() {
		if(userCarts==null) {
			userCarts = new HashMap<Long, Cart>();
		}
	}

	@Override
	public void addCartItem(long userId, long menuItemId) {
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
		if(userCarts.containsKey(userId)) {
			List<MenuItem> menuItems = userCarts.get(userId).getMenuItemList();
			menuItems.add(menuItem);
		} else {
			Cart cart = new Cart();
			List<MenuItem> menuItems = new ArrayList<MenuItem>();
			menuItems.add(menuItem);
			cart.setMenuItemList(menuItems);
			userCarts.put(userId, cart);
		}
		
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		Cart cart = userCarts.get(userId);
		if(cart==null) {
			throw new CartEmptyException();
		}
		List<MenuItem> menuItems =  cart.getMenuItemList();
		if(menuItems.size()==0) {
			throw new CartEmptyException();
		} else {
			double total = 0;
			for(MenuItem item : menuItems) {
				total += item.getPrice();
			}
			userCarts.get(userId).setTotal(total);
			return menuItems;
		}
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		List<MenuItem> menuItems =  userCarts.get(userId).getMenuItemList();
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
		menuItems.remove(menuItem);
		userCarts.get(userId).setMenuItemList(menuItems);
		
	}

}