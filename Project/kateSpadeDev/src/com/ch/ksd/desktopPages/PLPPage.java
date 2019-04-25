package com.ch.ksd.desktopPages;

import com.ch.ExcelUtils.ExcelProperty;
import com.ch.ksd.utils.constants.FileConstants;
import com.ch.utils.SeleniumUtils;

public class PLPPage implements FileConstants {

	public static void clickproduct() throws Exception {
		SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(PLP_Page, SECONDROPDPLP), 200);
		SeleniumUtils.wait(3);
	}

}
