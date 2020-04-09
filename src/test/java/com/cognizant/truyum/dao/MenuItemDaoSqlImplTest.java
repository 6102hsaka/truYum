package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.dao.impl.MenuItemDaoSqlImpl;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {

	public static void main(String args[]) {
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testGetMenuItem();
		testModifyMenuItem();

	}

	static void testGetMenuItemListAdmin() {
		List<MenuItem> list = new ArrayList<MenuItem>();
		MenuItemDaoSqlImpl t = new MenuItemDaoSqlImpl();
		list = t.getMenuItemListAdmin();
		System.out.println("Name Price Active Date Of Launch Category   FreeDelivery");
		try {
			for (MenuItem i : list) {
				if (i.isActive()) {
					if (i.isfreeDelivery()) {
						System.out.println(i.getName() + " " + i.getPrice() + "  YES " + i.getdateOfLaunch() + " "
								+ i.getCategory() + "  YES");
					} else {
						System.out.println(i.getName() + " " + i.getPrice() + "  YES " + i.getdateOfLaunch() + " "
								+ i.getCategory() + "  NO");
					}

				} else {
					if (i.isfreeDelivery()) {
						System.out.println(i.getName() + " " + i.getPrice() + "  NO " + i.getdateOfLaunch() + " "
								+ i.getCategory() + "  YES");
					} else {
						System.out.println(i.getName() + " " + i.getPrice() + "  NO " + i.getdateOfLaunch() + " "
								+ i.getCategory() + "  NO");
					}
				}
			}
		} catch (Exception e) {
		}
	}

	static void testGetMenuItemListCustomer() {
		List<MenuItem> list = new ArrayList<MenuItem>();
		MenuItemDaoSqlImpl t = new MenuItemDaoSqlImpl();
		list = t.getMenuItemListCustomer();
		for (MenuItem i : list) {
			if (i.isfreeDelivery()) {
				System.out.println(i.getName() + " " + i.getPrice() + " " + i.getCategory() + "  YES");
			} else {
				System.out.println(i.getName() + " " + i.getPrice() + " " + i.getCategory() + "  NO");
			}
		}

	}

	static void testModifyMenuItem() {
		List<MenuItem> list = new ArrayList<MenuItem>();
		MenuItemDaoSqlImpl t = new MenuItemDaoSqlImpl();
		list.add(t.getMenuItem(0));
		MenuItem i = new MenuItem();
		i.setId(1);
		i.setName("name");
		i.setActive(false);
		i.setdateOfLaunch(DateUtil.convertToDate("02/07/2017"));
		i.setCategory("starters");
		i.setfreeDelivery(true);
		i.setPrice(200);
		t.modifyMenuItem(i);

	}

	static void testGetMenuItem() {

		List<MenuItem> list = new ArrayList<MenuItem>();
		MenuItemDaoSqlImpl t = new MenuItemDaoSqlImpl();
		list.add(t.getMenuItem(4));
		for (MenuItem i : list) {
			if (i.isfreeDelivery()) {
				System.out.println(i.getName() + " " + i.getPrice() + " " + i.getCategory() + "  YES");
			} else {
				System.out.println(i.getName() + " " + i.getPrice() + " " + i.getCategory() + "  NO");
			}
		}
	}

}
