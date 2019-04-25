package com.ch.avf.desktopPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ch.ExcelUtils.ExcelBean;
import com.ch.ExcelUtils.ExcelProperty;
import com.ch.avf.utils.constants.FileConstants;
import com.ch.utils.DriverFactory;
import com.ch.utils.PropertyUtil;
import com.ch.utils.SeleniumUtils;

public class BillingPage implements FileConstants {

	public static boolean verifyBillingHeader() throws Exception {
		ExcelBean element1 = ExcelProperty.getElementValue(Billing, Billing_Header);

		boolean flag = false;
		try {
			flag = SeleniumUtils.iSDisplayed(element1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("system Should display Billing Page header");
		return flag;
	}

	public static void clickOnArtVanSignatureCard() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(Billing, Billing_ArtVanFurniture));
		SeleniumUtils.wait(3);
	}

	public static void clickOnCreditCard() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(Billing, Billing_CreditCard));
		SeleniumUtils.wait(3);
	}

	public static void selectExpirationDate(String data) throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(Billing, Billing_ExpDt));
		WebElement address = DriverFactory.getDriver()
				.findElement(By.xpath("//select[@id=\"dwfrm_billing_paymentMethods_primaryCard_expiration_month\"]"));
		Select state = new Select(address);
		state.selectByValue(PropertyUtil.getPropertyValue("BILLING_ExpMonth", TEST_PROPERTY_FILE));
	}

	public static void selectExpirationYear(String data) throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(Billing, Billing_ExpYr));
		WebElement address = DriverFactory.getDriver()
				.findElement(By.xpath("//select[@id=\"dwfrm_billing_paymentMethods_primaryCard_expiration_year\"]"));
		Select state = new Select(address);
		state.selectByValue(PropertyUtil.getPropertyValue("BILLING_ExpYr", TEST_PROPERTY_FILE));
	}

	public static void enterCardNumber(String data) throws Exception {
		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(Billing, Billing_CardNumber),
				PropertyUtil.getPropertyValue("BILLING_CREDITCARD", TEST_PROPERTY_FILE));
	}

	public static void enterNameOnCard(String data) throws Exception {
		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(Billing, Billing_NameOnCard),
				PropertyUtil.getPropertyValue("BILLING_NameOnCard", TEST_PROPERTY_FILE));
	}
	
	
	public static void enterFirstName(String data) throws Exception {
		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(Billing, Billing_FirstName),
				PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
	}

	public static void enterLastName(String data) throws Exception {
		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(Billing, Billing_LastName),
				PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
	}

	public static void enterCompanyName(String data) throws Exception {
		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(Billing, Billing_CompanyName),
				PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
	}

	public static void enterAddress1(String data) throws Exception {
		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(Billing, Billing_Address1),
				PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
	}
	
	public static void enterCity(String data) throws Exception {
		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(Billing, Billing_City), 
				PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
		SeleniumUtils.wait(5);
	}
	
	public static void enterPostalCode(String data) throws Exception {
		
		SeleniumUtils.click(ExcelProperty.getElementValue(Billing, Billing_ZipCode));
		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(Billing, Billing_ZipCode),
				PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
	}

	public static void selectState(String data) throws Exception {
//		SeleniumUtils.click(ExcelProperty.getElementValue(Billing, Billing_State));
		WebElement address = DriverFactory.getDriver().findElement(
				By.xpath("//select[@id='dwfrm_billing_billingAddress_addressFields_states_state']"));
		Select state = new Select(address);
		state.selectByValue(PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
		SeleniumUtils.wait(3);
		SeleniumUtils.keys(Keys.ESCAPE);
		
	}
	
	public static void enterPhonenumber(String data) throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(Billing, Billing_Phone));
		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(Billing, Billing_Phone),
				PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
		SeleniumUtils.wait(3);
	}
	
	
//	public static void clickOnContinue() throws Exception {
//		System.out.println("Billing continue: ");
//		SeleniumUtils.click(ExcelProperty.getElementValue(Billing, Billing_Continue));
//		SeleniumUtils.wait(3);
//	}
	
	public static void clickOnContinue() throws Exception {
		SeleniumUtils.wait(3);
		SeleniumUtils.keys(Keys.ESCAPE);
		System.out.println("Billing continue: ");
		SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(Billing, Billing_Continue), 200);
		SeleniumUtils.wait(3);
	}
}
