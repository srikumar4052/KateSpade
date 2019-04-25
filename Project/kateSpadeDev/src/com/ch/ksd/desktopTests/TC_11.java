package com.ch.ksd.desktopTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.ch.ExcelUtils.ExcelBean;
import com.ch.ExcelUtils.ExcelProperty;
import com.ch.ksd.desktopPages.BillingPage;
import com.ch.ksd.desktopPages.CheckoutPage;
import com.ch.ksd.desktopPages.PLPPage;
import com.ch.ksd.desktopPages.ShippingPage;
import com.ch.ksd.desktopPages.ShoppingCart;
import com.ch.ksd.utils.CommonUtils;
import com.ch.ksd.utils.constants.FileConstants;
import com.ch.report.utils.AbstractTestCaseReport;
import com.ch.reports.TestCaseDetail;
import com.ch.reports.TestCaseFactory;
import com.ch.retry.Retry;
import com.ch.utils.DriverFactory;
import com.ch.utils.SeleniumUtils;

public class TC_11 extends AbstractTestCaseReport implements FileConstants {

	public void ksdURL() throws Exception {
		CommonUtils.desktopView();
		CommonUtils.KATESPADEURL();
		SeleniumUtils.wait(1);
		popup();

	}

	public void popup() {
		try {
			System.out.println("inside popup");
			DriverFactory.getDriver().findElement(By.xpath("//*[@class=\"ui-button-icon ui-icon ui-icon-closethick\"]"))
					.click();
			System.out.println("PopUp closed");
		} catch (Exception e) {
			System.out.println("inside ppop up catch" + e.getMessage());
		}
	}

	// TC_11
	// Verify 'My Account' link
	@Test
	public void verifyOrderplacingVISA() throws Exception {
		String name = new Object() {
		}.getClass().getEnclosingMethod().getName();
		TestCaseDetail testcase = TestCaseFactory.createTestCaseDetail(this.getClass(), name);
		Retry retry = new Retry(1);
		while (retry.retry()) {
			try {
				ksdURL();
				SeleniumUtils.wait(3);
				SeleniumUtils.onhoverClickLinkText("HOME", "desk accessories");
				SeleniumUtils.wait(3);
				// Product Select
				PLPPage.clickproduct();
				SeleniumUtils.wait(3);
				// Add To Bag
				ShoppingCart.clickQty();
				ExcelBean element1 = ExcelProperty.getElementValue(Add_To_Bag, QTY);
				SeleniumUtils.dropDownByVisibleText(element1, "3");
				ShoppingCart.AddtoBag();
				ExcelBean element2 = ExcelProperty.getElementValue(ViewBagCheckout, ViewBag);
				SeleniumUtils.click(element2);
				CheckoutPage.CheckOut();
				// Shipping
				ShippingPage.enterEmail("Shipping_Email");
				ShippingPage.enterFirstName("Shipping_FirstName");
				ShippingPage.enterLastName("Shipping_LastName");
				SeleniumUtils.wait(3);
				ExcelBean element3 = ExcelProperty.getElementValue(Shipping, Shipping_Country);
				SeleniumUtils.dropDownByIndex(element3, 4);
				ShippingPage.enterCompanyName("Shipping_CompanyName");
				ShippingPage.enterAddress1("Shipping_Address1");
				/* ShippingPage.enterAddress2("Shipping_Address2"); */
				ShippingPage.enterCity("Shipping_City");
				/* ShippingPage.enterProvince("Shipping_Province"); */
				ShippingPage.enterPostalCode("Shipping_ZipCode");
				ShippingPage.enterPhoneNumber("Shipping_Phone");
				ShippingPage.UseThisAddressForBilling();
				ShippingPage.ShippingMethod();
				SeleniumUtils.wait(3);
				ShippingPage.ContinueToPayment();
				// Billing
				ExcelBean element4 = ExcelProperty.getElementValue(Billing, Billing_CreditCardtype);
				SeleniumUtils.dropDownByIndex(element4, 1);
				BillingPage.enterNameonCard("Billing_NameOnCard");
				BillingPage.enterCardNumber("Billing_CardNumber");
				BillingPage.enterStartDate("Billing_StartDate");
				BillingPage.enterExpairDate("Billing_ExpDate");
				SeleniumUtils.wait(3);
				BillingPage.enterSecuritycode("Billing_SecurityCode");
				BillingPage.clickReviewYourOrder();
				SeleniumUtils.wait(6);

				break;
			} catch (Exception e) {
				testcase.retry("Order Review Page is not available", testcase, retry, e);
				e.printStackTrace();
			}
		}
	}

}
