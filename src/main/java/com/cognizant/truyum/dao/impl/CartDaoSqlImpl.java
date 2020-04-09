package com.cognizant.truyum.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@Repository
public class CartDaoSqlImpl implements CartDao {
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private MenuItemService menuItemService;
	public List<MenuItem> getAllCartItems(long userId)throws CartEmptyException
	{
		List<MenuItem> list=new ArrayList<MenuItem>();
		String sql = "select * from cart where userId=?";
		list = jdbcTemplate.query(sql,new Object[] {userId}, (rs,rowNum)->menuItemService.getMenuItem(Long.parseLong(rs.getString(1))));
		return list;
	}
	public void addCartItem(long userId,long menuItemId)
	{
		String sql = "INSERT INTO cart VALUES(?,?)";
		int insert = jdbcTemplate.update(sql, userId,menuItemId);
	}
	public void removeCartItem(long userId,long menuItemId)
	{
		String sql = "DELETE FROM cart WHERE userId=? AND menuId=?";
		int delete = jdbcTemplate.update(sql, userId,menuItemId);
		System.out.println("delete "+delete);
	}

	
}
