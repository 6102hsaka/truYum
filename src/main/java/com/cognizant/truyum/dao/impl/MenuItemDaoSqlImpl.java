package com.cognizant.truyum.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.controller.MenuItemController;
import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;

@Repository("menuItemDao")
public class MenuItemDaoSqlImpl implements MenuItemDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);
	
	public List<MenuItem> getMenuItemListAdmin() {
		LOGGER.info("getMenuItemListAdmin - Start");
		List<MenuItem> list = new ArrayList<MenuItem>();
		String sql = "Select * from menuitem";
		list = jdbcTemplate.query(sql,(rs,rowNum)->new MenuItem(
				rs.getLong(1),rs.getString(2),rs.getFloat(3),rs.getBoolean(4),rs.getDate(5),rs.getString(6),rs.getBoolean(7)));
		LOGGER.info("getMenuItemListAdmin - End");
		return list;
	}

	public List<MenuItem> getMenuItemListCustomer() {
		LOGGER.info("getMenuItemListCustomer - Start");
		List<MenuItem> list = new ArrayList<MenuItem>();
		String sql = "SELECT * FROM menuitem WHERE active = true and dateoflaunch < curdate()";
		list = jdbcTemplate.query(sql,(rs,rowNum)->new MenuItem(
				rs.getLong(1),rs.getString(2),rs.getFloat(3),rs.getBoolean(4),rs.getDate(5),rs.getString(6),rs.getBoolean(7)));
		LOGGER.info("getMenuItemListCustomer - End");
		return list;
	}

	public MenuItem getMenuItem(long menuItemId) {
		LOGGER.info("getMenuItem - Start");
		List<MenuItem> list = new ArrayList<MenuItem>();
		String sql = "SELECT * FROM menuitem WHERE id=?";
		list = jdbcTemplate.query(sql,new Object[] {menuItemId} ,(rs,rowNum)->new MenuItem(
				rs.getLong(1),rs.getString(2),rs.getFloat(3),rs.getBoolean(4),rs.getDate(5),rs.getString(6),rs.getBoolean(7)));
		LOGGER.info("getMenuItem - End");
		return list.get(0);
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		LOGGER.info("modifyMenuItem - Start");
		String sql = "UPDATE menuitem SET name = ?, price = ?, active = ?, dateOfLaunch = ?, category=?, freeDelivery = ? where id = ?";
		int update = jdbcTemplate.update(sql, menuItem.getName(), menuItem.getPrice(), menuItem.isActive(),
				menuItem.getdateOfLaunch(), menuItem.getCategory(), menuItem.isfreeDelivery(), menuItem.getId());
		LOGGER.info("modifyMenuItem - End");
	}
}
