package com.cognizant.truyum.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;
import com.cognizant.truyum.service.MenuItemService;

@Controller
public class CartController {
	
	@Autowired
	private CartService cartService;
	@Autowired
	private MenuItemService menuItemService;
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

	@GetMapping(value = "add-to-cart")
	public String addToCart(@RequestParam String menuItemId,ModelMap model) {
		LOGGER.info("addToCart Start");
		cartService.addCartItem(1, Long.parseLong(menuItemId));
		model.put("addCartStatus", true);
		List<MenuItem> menuItems = menuItemService.getMenuItemListCustomer();
		model.put("menuItems",menuItems);
		LOGGER.info("addToCart End");
		return "menu-item-list-customer";
	}
	
	@GetMapping(value = "show-cart")
	public String showCart(@RequestParam String userId, ModelMap model) {
		try {
			List<MenuItem> menuItems = cartService.getAllCartItems(Long.parseLong(userId));
			model.put("menuItems", menuItems);
			return "cart";
		} catch(CartEmptyException e) {
			return "cart-empty";
		}
	}
	
	@GetMapping(value = "remove-cart")
	public String removeCart(@RequestParam String userId,@RequestParam String menuItemId,ModelMap model) {
		cartService.removeCartItem(Long.parseLong(userId), Long.parseLong(menuItemId));
		try {
			List<MenuItem> menuItems = cartService.getAllCartItems(Long.parseLong(userId));
			model.put("menuItems", menuItems);
			model.put("removeCartItemStatus", true);
			return "cart";
		} catch(CartEmptyException e) {
			return "cart-empty";
		}
	}
}
