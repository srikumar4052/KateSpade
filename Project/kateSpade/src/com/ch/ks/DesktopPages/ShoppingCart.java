package com.ch.avf.desktopPages;

import com.ch.ExcelUtils.ExcelBean;
import com.ch.ExcelUtils.ExcelProperty;
import com.ch.avf.utils.constants.FileConstants;
import com.ch.utils.DriverFactory;
import com.ch.utils.SeleniumUtils;

public class ShoppingCart implements FileConstants{
	
	public static boolean verifyShoppingCartHeader() throws Exception {
		ExcelBean element1 = ExcelProperty.getElementValue(SHOPPINGCART, ShopCart_Header);

		boolean flag = false;
		try {
			flag = SeleniumUtils.iSDisplayed(element1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("system Should display Shopping Cart header");
		return flag;
	}
	
	
	
	public static void clickOnProtectYourFurniturePurchase1() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(SHOPPINGCART, Protect_your_Furniture_Purchase1));
		SeleniumUtils.wait(1);
	}
	
	public static void clickOnProtectYourFurniturePurchase2() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(SHOPPINGCART, Protect_your_Furniture_Purchase2));
		SeleniumUtils.wait(3);
	}
	
	public static void clickOnAppyToCart() throws Exception {
		
		SeleniumUtils.click(ExcelProperty.getElementValue(SHOPPINGCART, ShopCart_ApplytoCart));
		SeleniumUtils.wait(3);
	}
	
	public static void clickOnContinueDelivaryPickup	() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(SHOPPINGCART, ShopCart_ContToDeliveryPickUp));
		SeleniumUtils.wait(3);
	}


}
