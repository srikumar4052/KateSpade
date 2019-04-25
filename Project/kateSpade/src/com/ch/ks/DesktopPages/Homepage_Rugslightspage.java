package com.ch.avf.desktopPages;

import com.ch.ExcelUtils.ExcelProperty;
import com.ch.avf.utils.constants.FileConstants;
import com.ch.utils.SeleniumUtils;

public class Homepage_Rugslightspage implements FileConstants{
	
	
	public static void clickOnFirstProd() throws Exception
    {
        SeleniumUtils.javaScriptClick(ExcelProperty.getElementValue(HOME_PAGE, HOMEPAGE_RUGSLIGHTS_FIRSTPROD),
                200);  
        SeleniumUtils.wait(3);
    }
	
	public static void clickOnAddToCart() throws Exception
    {
        SeleniumUtils.click(ExcelProperty.getElementValue(HOME_PAGE, HOMEPAGE_ADDTOCART));
        SeleniumUtils.wait(2);
    }

}
