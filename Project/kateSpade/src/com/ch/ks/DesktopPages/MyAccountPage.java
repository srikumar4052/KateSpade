package com.ch.avf.desktopPages;

import com.ch.ExcelUtils.ExcelBean;
import com.ch.ExcelUtils.ExcelProperty;
import com.ch.avf.utils.constants.FileConstants;
import com.ch.utils.SeleniumUtils;

public class MyAccountPage implements FileConstants{
	
	public static boolean verifyElementsInMyAccountPopup() throws Exception {
		ExcelBean element1 = ExcelProperty.getElementValue(MyAccount, SIGN_IN_BUTTON);
		ExcelBean element2 = ExcelProperty.getElementValue(MyAccount, CREATE_ACCOUNT_BUTTON);
		boolean flag = false;
		try {
			flag = SeleniumUtils.iSDisplayed(element1);
			flag = SeleniumUtils.iSDisplayed(element2);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("System Should display the 'SignIn' and 'Create An account' button in popup");
		return flag;
	}

}
