package com.ch.avf.desktopPages;

import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.ch.ExcelUtils.ExcelBean;
import com.ch.ExcelUtils.ExcelProperty;
import com.ch.avf.utils.constants.FileConstants;
import com.ch.avf.utils.constants.ObjectConstants;
import com.ch.utils.DriverFactory;
import com.ch.utils.PropertyUtil;
import com.ch.utils.SeleniumUtils;



public class Delivery_Pickup implements FileConstants, ObjectConstants {

	public static void enterEmailId(String data) throws Exception {
		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(DELIVERY_PICKUP, DeliveryPickUp_Email),
				PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
	}

	public static boolean verifyDeliveryPickupHeader() throws Exception {
		ExcelBean element1 = ExcelProperty.getElementValue(DELIVERY_PICKUP, DeliveryPickUp_Header);

		boolean flag = false;
		try {
			flag = SeleniumUtils.iSDisplayed(element1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("system Should display Delivery PickUp Header");
		return flag;
	}

	public static void enterPhone(String data) throws Exception {

		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(DELIVERY_PICKUP, DeliveryPickUp_Phone),
				PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
	}

	public static void enterFirstName(String data) throws Exception {
		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(DELIVERY_PICKUP, DeliveryPickUp_FirstName),
				PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
	}

	public static void enterLastName(String data) throws Exception {
		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(DELIVERY_PICKUP, DeliveryPickUp_LastName),
				PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
	}

	public static void enterCompanyName(String data) throws Exception {
		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(DELIVERY_PICKUP, DeliveryPickUp_CompanyName),
				PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
	}

	public static void enterAddress1(String data) throws Exception {
		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(DELIVERY_PICKUP, DeliveryPickUp_Address1),
				PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
	}

	public static void enterAddress2(String data) throws Exception {
		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(DELIVERY_PICKUP, DeliveryPickUp_Address2),
				PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
	}

	public static void enterCity(String data) throws Exception {
		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(DELIVERY_PICKUP, DeliveryPickUp_City), 
				PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
		SeleniumUtils.wait(5);
	}

	public static void selectAddressAsBilling() throws Exception {
		ExcelBean element1 = ExcelProperty.getElementValue(DELIVERY_PICKUP, DeliveryPickUp_PostalCode);
		boolean flag = SeleniumUtils.isSelected(element1);
		System.out.println("Billig checkbox" + flag);
		if (flag == true) {
			SeleniumUtils.click(ExcelProperty.getElementValue(DELIVERY_PICKUP, DeliveryPickUp_AddressAsBilling));
			SeleniumUtils.wait(1);
		}
	}

	public static void enterPostalCode(String data) throws Exception {
		System.out.println("Inside Postal Code");
		SeleniumUtils.click(ExcelProperty.getElementValue(DELIVERY_PICKUP, DeliveryPickUp_PostalCode));
		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(DELIVERY_PICKUP, DeliveryPickUp_PostalCode),
				PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
	}

	public static void selectState(String data) throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(DELIVERY_PICKUP, DeliveryPickUp_State));
		WebElement address = DriverFactory.getDriver().findElement(
				By.xpath("//select[@name=\"dwfrm_splitshipping_shippingAddress_addressFields_states_state\"]"));
		Select state = new Select(address);
		state.selectByValue(PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
	}

	public static void clickOnContinue() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(DELIVERY_PICKUP, DeliveryPickUp_Continue));
		SeleniumUtils.wait(3);
	}
	
	public static void clickOnAditionalDeliveryOptionsLink() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(DELIVERY_PICKUP, DeliveryPickUp_AdDDelivOptions));
		SeleniumUtils.wait(3);
	}
	
	public static boolean verifyDeliveryOptionHeader() throws Exception {
		ExcelBean element1 = ExcelProperty.getElementValue(DELIVERY_PICKUP, DeliveryPickUp_DeliveryOptHeader);

		boolean flag = false;
		try {
			flag = SeleniumUtils.iSDisplayed(element1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("system Should display Delivery Option Header");
		return flag;
	}
	
	public static void clickOnAditionalDeliveryOptions1() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(DELIVERY_PICKUP, DeliveryPickUp_DeliveryOpt1));
		SeleniumUtils.wait(3);
	}

	public static String deliveryOption1Text() throws Exception {
		ExcelBean element1 = ExcelProperty.getElementValue(DELIVERY_PICKUP, DeliveryPickUp_DeliveryOpt1Text);
		return SeleniumUtils.getText(element1);
	}

	public static void clickOnApplyButton() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(DELIVERY_PICKUP, DeliveryPickUp_DeliveryOptAPPLYButton));
		SeleniumUtils.wait(3);
	}
	
	public static String deliveryOption1Text_OrderSummary() throws Exception {
		ExcelBean element1 = ExcelProperty.getElementValue(DELIVERY_PICKUP, DeliveryPickUp_DeliveryOpt1OrderSummary);
		return SeleniumUtils.getText(element1);
	}
	
	public static void clickOnRemoveMattressRecycling() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(DELIVERY_PICKUP, DeliveryPickUp_RemoveMattressRecycling));
		SeleniumUtils.wait(5);
	}
	
	public static void clickOnFreeStorePickUp() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(DELIVERY_PICKUP, DeliveryPickUp_FREESTOREPICKUP));
		SeleniumUtils.wait(3);
	}
	
	public static void clickOnChooseDiffLink() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(DELIVERY_PICKUP, DeliveryPickUp_CHOOSEDIFFSTORE));
		SeleniumUtils.wait(3);
	}
	
	public static void enterFreeStoreZipCode(String data) throws Exception {
		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(DELIVERY_PICKUP, DeliveryPickUp_FREESTOREZIPCODE), 
				PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
		SeleniumUtils.wait(5);
	}
	
	public static void clickOnFreeStoreSearchButton() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(DELIVERY_PICKUP, DeliveryPickUp_FREESTORESEARCH));
		SeleniumUtils.wait(3);
	}
	
	public static void clickOnFreeStoreSeletLocation() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(DELIVERY_PICKUP, DeliveryPickUp_FREESTORESSELECTLINK));
		SeleniumUtils.wait(4);
	}
	
	public static void clickOnChoosePickUpDate() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(DELIVERY_PICKUP, DeliveryPickUp_ChOOSEPICKUPDATE));
		SeleniumUtils.wait(3);
	}
	
	public static boolean verifyChoosePickUpDateHeader	() throws Exception {
		ExcelBean element1 = ExcelProperty.getElementValue(DELIVERY_PICKUP, DeliveryPickUp_PickUpDateHeader);

		boolean flag = false;
		try {
			flag = SeleniumUtils.iSDisplayed(element1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("system Should display Choose Pickup date Header");
		return flag;
	}
	
	public static void pickupdatelist() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(DELIVERY_PICKUP, DeliveryPickUp_ChOOSEPICKUPDATE));
		List<WebElement> elm = DriverFactory.getDriver().findElements(By.xpath("//*[@href='#']"));
		for(WebElement e : elm) 
        {        
			System.out.println(" pickup date: "+e.getText());
			LocalDate localDate = LocalDate.now();
			int currdt = localDate.getDayOfMonth();
			
        }
	}
	
	public static void pickupdate() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(DELIVERY_PICKUP, DeliveryPickUp_ChOOSEPICKUPDATE));
		SeleniumUtils.wait(1);
		SeleniumUtils.click(ExcelProperty.getElementValue(DELIVERY_PICKUP, DeliveryPickUp_AvailableDate));
		SeleniumUtils.wait(1);
	}
	
	public static void clickOnSavePickupDateButton() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(DELIVERY_PICKUP, DeliveryPickUp_SAVRPICKUPTAE));
		SeleniumUtils.wait(3);
	}
}
