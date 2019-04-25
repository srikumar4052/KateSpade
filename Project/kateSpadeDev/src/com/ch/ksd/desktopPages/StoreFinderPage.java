package com.ch.ksd.desktopPages;

import com.ch.ExcelUtils.ExcelBean;
import com.ch.ExcelUtils.ExcelProperty;
import com.ch.ksd.utils.constants.FileConstants;
import com.ch.utils.SeleniumUtils;

public class StoreFinderPage implements FileConstants {

	public static void enterZipcodeSearchInputField(String zipcode) throws Exception {
		SeleniumUtils.sendKeys(ExcelProperty.getElementValue(StoreFinder, ZIPCODE_SEARCH_INPUT_FIELD), zipcode);
	}

	public static boolean verifyElementsInStoreFinderPage() throws Exception {
		ExcelBean element1 = ExcelProperty.getElementValue(StoreFinder, OPEN_TODAY_TITLE);
		ExcelBean element2 = ExcelProperty.getElementValue(StoreFinder, MAKE_THIS_MY_STORE_BUTTON);
		ExcelBean element3 = ExcelProperty.getElementValue(StoreFinder, STORE_DETAILS_BUTTON);
		ExcelBean element4 = ExcelProperty.getElementValue(StoreFinder, EMBEDDED_MAP);

		boolean flag = false;
		try {
			flag = SeleniumUtils.iSDisplayed(element1);
			flag = SeleniumUtils.iSDisplayed(element2);
			flag = SeleniumUtils.iSDisplayed(element3);
			flag = SeleniumUtils.iSDisplayed(element4);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("System Should display the elements in store finder page");
		return flag;
	}

}
