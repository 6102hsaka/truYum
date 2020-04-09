package com.cognizant.truyum.service;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public interface MenuItemService {
	
	List<MenuItem> getMenuItemListAdmin();
	List<MenuItem> getMenuItemListCustomer();
	void modifyMenuItem(MenuItem menuItem);
	MenuItem getMenuItem(long menuItemId);

}
