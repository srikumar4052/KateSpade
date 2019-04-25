package com.ch.avf.desktopPages;

import com.ch.ExcelUtils.ExcelBean;
import com.ch.ExcelUtils.ExcelProperty;
import com.ch.avf.utils.constants.FileConstants;
import com.ch.utils.SeleniumUtils;

public class OrderReviewPage implements FileConstants {

	public static boolean verifyBillingHeader() throws Exception {
		ExcelBean element1 = ExcelProperty.getElementValue(OrderReview, OrderReview_Header);

		boolean flag = false;
		try {
			flag = SeleniumUtils.iSDisplayed(element1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("system Should display Order Review Page Header");
		return flag;
	}

	public static String getDetails(String data) throws Exception {

		ExcelBean element1 = ExcelProperty.getElementValue(OrderReview, data);
		System.out.println(SeleniumUtils.getText(element1));

		return SeleniumUtils.getText(element1);
	}

}
