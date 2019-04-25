package com.ch.ksd.desktopPages;

import com.ch.ExcelUtils.ExcelProperty;
import com.ch.ksd.utils.constants.FileConstants;
import com.ch.utils.PropertyUtil;
import com.ch.utils.SeleniumUtils;

public class ShippingPage implements FileConstants {

	public static void enterEmail(String data) throws Exception {
		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(Shipping, SHIPPING_EMAIL),
				PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
	}

	public static void enterFirstName(String data) throws Exception {
		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(Shipping, Shipping_FirstName),
				PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
	}

	public static void enterLastName(String data) throws Exception {
		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(Shipping, Shipping_LastName),
				PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
	}

	public static void enterCompanyName(String data) throws Exception {
		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(Shipping, Shipping_CompanyName),
				PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
	}

	public static void enterAddress1(String data) throws Exception {
		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(Shipping, Shipping_Address1),
				PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
	}

	public static void enterAddress2(String data) throws Exception {
		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(Shipping, Shipping_Address2),
				PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
	}

	public static void enterCity(String data) throws Exception {
		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(Shipping, Shipping_City),
				PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
		SeleniumUtils.wait(5);
	}

	public static void enterProvince(String data) throws Exception {
		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(Shipping, Shipping_Province),
				PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
		SeleniumUtils.wait(5);
	}

	public static void enterPostalCode(String data) throws Exception {

		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(Shipping, Shipping_ZipCode),
				PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
	}

	public static void enterPhoneNumber(String data) throws Exception {

		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(Shipping, Shipping_Phone),
				PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
	}

	public static void UseThisAddressForBilling() throws Exception {
		SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(Shipping, Same_As_Shipping_Adress), 200);
		SeleniumUtils.wait(3);
	}

	public static void ShippingMethod() throws Exception {
		SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(Shipping, Express_Method), 200);
		SeleniumUtils.wait(3);
	}

	public static void ContinueToPayment() throws Exception {
		SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(Shipping, Shipping_Paymentbtn), 200);
		SeleniumUtils.wait(3);
	}
}
