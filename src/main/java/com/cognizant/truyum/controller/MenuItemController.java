package com.cognizant.truyum.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.omg.CORBA.SystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@Controller
public class MenuItemController {
	
	@Autowired
	private MenuItemService menuItemService;
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	@GetMapping(value = "show-menu-list-admin")
	public String showMenuItemListAdmin(ModelMap model) throws SystemException {
		LOGGER.info("Start");
		List<MenuItem> menuItems = menuItemService.getMenuItemListAdmin();
		model.put("menuItems",menuItems);
		LOGGER.info("End");
		return "menu-item-list-admin";
	}
	
	@GetMapping(value = "show-menu-list-customer")
	public String showMenuItemListCustomer(ModelMap model) throws SystemException {
		LOGGER.info("Start");
		List<MenuItem> menuItems = menuItemService.getMenuItemListCustomer();
		model.put("menuItems",menuItems);
		LOGGER.info("End");
		return "menu-item-list-customer";
	}
	
	@GetMapping(value ="show-edit-menu-item" )
	public String showEditMenuItem(@RequestParam("id") String id,ModelMap model) {
		LOGGER.info("Start");
		MenuItem menuItem = menuItemService.getMenuItem(Long.parseLong(id));
		model.put("menuItem",menuItem);
		LOGGER.info("End");
		return "edit-menu-item";		
	}
	
	@PostMapping(value = "show-edit-menu-item")
	public String updateMenuItem(@ModelAttribute MenuItem menuItem) {
		menuItemService.modifyMenuItem(menuItem);
		return "edit-menu-item-status";
	}

}
