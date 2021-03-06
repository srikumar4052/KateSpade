package com.ch.ksd.desktopPages;

import com.ch.ExcelUtils.ExcelProperty;
import com.ch.ksd.utils.constants.FileConstants;
import com.ch.utils.PropertyUtil;
import com.ch.utils.SeleniumUtils;

public class BillingPage implements FileConstants {

	public static void enterNameonCard(String data) throws Exception {

		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(Billing, Billing_NameOnCard),
				PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
	}

	public static void enterCardNumber(String data) throws Exception {

		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(Billing, Billing_CardNumber),
				PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
	}

	public static void enterStartDate(String data) throws Exception {

		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(Billing, Billing_StartDate),
				PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
	}

	public static void enterExpairDate(String data) throws Exception {

		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(Billing, Billing_ExpDate),
				PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
	}

	public static void enterSecuritycode(String data) throws Exception {

		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(Billing, Billing_SecurityCode),
				PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
	}

	public static void enterIssunumber(String data) throws Exception {

		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(Billing, Billing_IssueNumber),
				PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
	}

	public static void clickReviewYourOrder() throws Exception {
		SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(Billing, Billung_ReviewOrder), 500);
		SeleniumUtils.wait(3);
	}

}
