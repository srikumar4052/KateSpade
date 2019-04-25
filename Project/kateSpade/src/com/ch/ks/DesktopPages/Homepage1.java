package com.ch.avf.desktopPages;

import com.ch.ExcelUtils.ExcelBean;
import com.ch.ExcelUtils.ExcelProperty;
import com.ch.avf.utils.constants.FileConstants;
import com.ch.report.utils.AbstractTestCaseReport;
import com.ch.utils.PropertyUtil;
import com.ch.utils.SeleniumUtils;

public class Homepage1 implements FileConstants {

	public static void clickOnRugsLights() throws Exception {
		SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(HOME_PAGE, HOMEPAGE_L1_RUGSLIGHTS), 200);
		SeleniumUtils.wait(3);
	}

	public static boolean verifyYourSelectionHasBeenAdded() throws Exception {
		ExcelBean element1 = ExcelProperty.getElementValue(HOME_PAGE, HOMEPAGE_YOURSELECTIONHASBEENADDED_HEADER);

		boolean flag = false;
		try {
			flag = SeleniumUtils.iSDisplayed(element1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("system Should display Your selection has been added header");
		return flag;
	}

	public static void clickOnViewCart_Checkout() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(HOME_PAGE, HOMEPAGE_VIEWCART_CHECKOUT_BUTTON));
		SeleniumUtils.wait(3);
	}
	
	public static void clickOnMyAccountLinkInHeader() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(HOME_PAGE, HOMEPAGE_MYACCOUNT_LINK));
		SeleniumUtils.wait(3);
	}
	
	public static void clickOnOutletTabInHeader() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(HOME_PAGE, HOMEPAGE_OUTLET_TAB));
		SeleniumUtils.wait(3);
	}
	
	public static void clickOnPrivacyPolicyInFooter() throws Exception {
		SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(HOME_PAGE, HOMEPAGE_PRIVACY_POLICY_LINK), 400);
		SeleniumUtils.wait(3);
	}
	
	public static boolean verifyElementsInPrivacyPolicyPage() throws Exception {
		ExcelBean element1 = ExcelProperty.getElementValue(HOME_PAGE, PRIVACY_POLICY_TITLE);
		boolean flag = false;
		try {
			flag = SeleniumUtils.iSDisplayed(element1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("System Should navigate to the static page");
		return flag;
	}
	
	public static void enterTextInSearchBar(String data) throws Exception {

		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(HOME_PAGE, HOMEPAGE_SEARCH),
				PropertyUtil.getPropertyValue(data, TEST_PROPERTY_FILE));
	}
	
	public static void clickOnSearchIcon() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(HOME_PAGE, HOMEPAGE_SEARCHICON));
		SeleniumUtils.wait(3);
	}
	
	public static void clickOnHuronXBackChairLink() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(HOME_PAGE, HOMEPAGE_HuronXBackChair));
		SeleniumUtils.wait(3);
	}
	
	public static void hoverOnBabyKisd() throws Exception {
		SeleniumUtils.onHover(ExcelProperty.getElementValue(HOME_PAGE, HOMEPAGE_L1_BABYKIDS));
		SeleniumUtils.wait(1);

	}
	
	public static void hoverOnDecor() throws Exception {
		SeleniumUtils.onHover(ExcelProperty.getElementValue(HOME_PAGE, HOMEPAGE_L1_DECOR));
		SeleniumUtils.wait(1);

	}
	public static void clickOnKidsHeadboards() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(HOME_PAGE, HOMEPAGE_L2_BABYKIDS_KIDSHEADBOARDS));
		SeleniumUtils.wait(2);
	}
	
	public static void clickOnWallMirror() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(HOME_PAGE, HOMEPAGE_L2_DECOR_WALLMIRRORS));
		SeleniumUtils.wait(2);
	}
	
	
	
	//KAVYA
	public static void clickOnFindStoreLinkInHeader() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(HOME_PAGE, HOMEPAGE_FIND_STORE_LINK));
		SeleniumUtils.wait(3);
	}
	
	
}
