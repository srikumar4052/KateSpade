package com.ch.avf.desktopPages;

import com.ch.ExcelUtils.ExcelProperty;
import com.ch.avf.utils.constants.FileConstants;
import com.ch.utils.SeleniumUtils;

public class PLPPage implements FileConstants {

	public static void clickOnSecondProduct() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(PLP_Page, SECONDPRODPLP));
		SeleniumUtils.wait(2);
	}
}
