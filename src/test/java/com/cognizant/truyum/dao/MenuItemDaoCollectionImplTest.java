package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.dao.impl.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoCollectionImplTest {

	
	
	public static void main(String args[])
	{
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
		testGetMenuItem();
	}
	static void testGetMenuItemListAdmin()
	{
		List<MenuItem> menuItemList=new ArrayList<MenuItem>();	
		MenuItemDaoCollectionImpl menuItemDao=new MenuItemDaoCollectionImpl();
		menuItemList=menuItemDao.getMenuItemListAdmin();
		System.out.println("Name Price Active Date Of Launch Category   FreeDelivery");
		try
		{

		for(MenuItem i: menuItemList)
		{
			if(i.isActive())
			{
				if(i.isfreeDelivery())
				{
					System.out.println(i.getName()+ " "+i.getPrice()+"  YES "+i.getdateOfLaunch()+" "+i.getCategory()+"  YES");
				}
				else
				{
					System.out.println(i.getName()+ " "+i.getPrice()+"  YES "+i.getdateOfLaunch()+" "+i.getCategory()+"  NO");		
				}
		
			}
			else
			{
				if(i.isfreeDelivery())
				{
					System.out.println(i.getName()+ " "+i.getPrice()+"  NO "+i.getdateOfLaunch()+" "+i.getCategory()+"  YES");
				}
				else
				{
					System.out.println(i.getName()+ " "+i.getPrice()+"  NO "+i.getdateOfLaunch()+" "+i.getCategory()+"  NO");		
				}
			}	
		}
		}
		catch(Exception e)
		{
		}
		
	}
	static void testGetMenuItemListCustomer()
	{
		List<MenuItem> menuItemList=new ArrayList<MenuItem>();	
		MenuItemDaoCollectionImpl menuItemDao=new MenuItemDaoCollectionImpl();
		menuItemList=menuItemDao.getMenuItemListCustomer();
		System.out.println("Name Price Category   FreeDelivery");
		for(MenuItem i: menuItemList)
		{
			if(i.isfreeDelivery())
		{
			System.out.println(i.getName()+ " "+i.getPrice()+" "+i.getCategory()+"  YES");
		}
		else
		{
			System.out.println(i.getName()+ " "+i.getPrice()+" "+i.getCategory()+"  NO");		
		}
			
		}
		
	}
	static void testModifyMenuItem()
	{
		List<MenuItem> menuItemList=new ArrayList<MenuItem>();	
		MenuItemDaoCollectionImpl menuItemDao=new MenuItemDaoCollectionImpl();
		menuItemList=menuItemDao.getMenuItemListAdmin();
		menuItemDao.modifyMenuItem(menuItemList.get(0));
		System.out.println("Name Price Active Date Of Launch Category   FreeDelivery");
		try
		{

		for(MenuItem i: menuItemList)
		{
			if(i.isActive())
			{
				if(i.isfreeDelivery())
				{
					System.out.println(i.getName()+ " "+i.getPrice()+"  YES "+i.getdateOfLaunch()+" "+i.getCategory()+"  YES");
				}
				else
				{
					System.out.println(i.getName()+ " "+i.getPrice()+"  YES "+i.getdateOfLaunch()+" "+i.getCategory()+"  NO");		
				}
		
			}
			else
			{
				if(i.isfreeDelivery())
				{
					System.out.println(i.getName()+ " "+i.getPrice()+"  NO "+i.getdateOfLaunch()+" "+i.getCategory()+"  YES");
				}
				else
				{
					System.out.println(i.getName()+ " "+i.getPrice()+"  NO "+i.getdateOfLaunch()+" "+i.getCategory()+"  NO");		
				}
			}	
		}
		}catch(Exception e)
		{
		}
	}
	static void testGetMenuItem()
	{
		List<MenuItem> menuItemList=new ArrayList<MenuItem>();	
		MenuItemDaoCollectionImpl menuItemDao=new MenuItemDaoCollectionImpl();
		menuItemList.add(menuItemDao.getMenuItem(2));
		try
		{

		for(MenuItem i: menuItemList)
		{
			if(i.isActive())
			{
				if(i.isfreeDelivery())
				{
					System.out.println(i.getName()+ " "+i.getPrice()+"  YES "+i.getdateOfLaunch()+" "+i.getCategory()+"  YES");
				}
				else
				{
					System.out.println(i.getName()+ " "+i.getPrice()+"  YES "+i.getdateOfLaunch()+" "+i.getCategory()+"  NO");		
				}
		
			}
			else
			{
				if(i.isfreeDelivery())
				{
					System.out.println(i.getName()+ " "+i.getPrice()+"  NO "+i.getdateOfLaunch()+" "+i.getCategory()+"  YES");
				}
				else
				{
					System.out.println(i.getName()+ " "+i.getPrice()+"  NO "+i.getdateOfLaunch()+" "+i.getCategory()+"  NO");		
				}
			}	
		}
		}catch(Exception e)
		{
		}
	}
	
}
