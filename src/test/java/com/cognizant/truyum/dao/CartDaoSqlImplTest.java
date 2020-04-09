package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.dao.impl.CartDaoSqlImpl;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {
	
	public static void main(String args[]) 
	{
		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();
		testGetAllCartItems();
	}
	static void testAddCartItem() 
	{
		CartDaoSqlImpl t= new CartDaoSqlImpl();
		t.addCartItem(1,2);
		t.addCartItem(1,3);	
		t.addCartItem(1,4);
		
	}
	static void testGetAllCartItems() 
	{
		List<MenuItem> list=new ArrayList<MenuItem>();
		CartDaoSqlImpl t= new CartDaoSqlImpl();
		try {
			list= t.getAllCartItems(1);
			for(MenuItem i: list )
			{
				System.out.println(i);
			}
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void testRemoveCartItem() 
	{
		CartDaoSqlImpl t= new CartDaoSqlImpl();
		t.removeCartItem(1,2);
	}
	
}
