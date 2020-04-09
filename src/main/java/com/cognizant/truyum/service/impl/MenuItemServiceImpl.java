package com.cognizant.truyum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@Service
public class MenuItemServiceImpl implements MenuItemService{

	@Autowired
	private MenuItemDao menuItemDao;
	
	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemDao.getMenuItemListAdmin();
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		return menuItemDao.getMenuItemListCustomer();
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		menuItemDao.modifyMenuItem(menuItem);
		
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		return menuItemDao.getMenuItem(menuItemId);
	}

}
