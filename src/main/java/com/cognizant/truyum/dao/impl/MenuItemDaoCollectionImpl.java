package com.cognizant.truyum.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private List<MenuItem> menuItemList = new ArrayList<MenuItem>();

	public MenuItemDaoCollectionImpl() {
		try {
			if (menuItemList.isEmpty()) {
				MenuItem i1 = new MenuItem(1L, "Sandwich", (float) 99, true, DateUtil.convertToDate("15/03/2017"),
						"Main Course", true);
				menuItemList.add(i1);
				MenuItem i2 = new MenuItem(2L, "Burger", (float) 129, true, DateUtil.convertToDate("23/12/2017"),
						"Main Course", false);
				menuItemList.add(i2);
				MenuItem i3 = new MenuItem(3L, "Pizza", (float) 149, true, DateUtil.convertToDate("21/08/2017"),
						"Main Course", false);
				menuItemList.add(i3);
				MenuItem i4 = new MenuItem(4L, "French Fries", (float) 57, false, DateUtil.convertToDate("02/07/2017"),
						"Starters", true);
				menuItemList.add(i4);
				MenuItem i5 = new MenuItem(5L, "Cholcate Brownie", (float) 32, true,
						DateUtil.convertToDate("02/11/2022"), "Dessert", true);
				menuItemList.add(i5);
			}
		} catch (Exception e) {
		}
	}

	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemList;
	}

	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> menuItem = new ArrayList<MenuItem>();
		String current = "26/02/2020";
		Date d = DateUtil.convertToDate(current);
		for (MenuItem i : menuItemList) {
			Date e = i.getdateOfLaunch();
			long diff = d.getTime() - e.getTime();
			if (i.isActive() && diff > 0) {
				menuItem.add(i);
			}
		}
		return menuItem;
	}

	public void modifyMenuItem(MenuItem menuItem) {
		for (MenuItem i : menuItemList) {
			if (i.equals(menuItem)) {
				i.setName(menuItem.getName());
				i.setActive(menuItem.isActive());
				i.setdateOfLaunch(menuItem.getdateOfLaunch());
				i.setCategory(menuItem.getCategory());
				i.setfreeDelivery(menuItem.isfreeDelivery());
				i.setPrice(menuItem.getPrice());
			}
		}

	}

	public MenuItem getMenuItem(long menuItemId) {
		for (MenuItem i : menuItemList) {
			if (menuItemId == i.getId()) {
				return i;
			}
		}
		return null;
	}
}