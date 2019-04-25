package com.ch.ksd.desktopPages;

import com.ch.ExcelUtils.ExcelBean;
import com.ch.ExcelUtils.ExcelProperty;
import com.ch.ksd.utils.constants.FileConstants;
import com.ch.utils.SeleniumUtils;

public class BrowseAndShopPage implements FileConstants {

	public static boolean verifyL1Category() throws Exception {
		ExcelBean element1 = ExcelProperty.getElementValue(HOME_PAGE, HOMEPAGE_LIVING_CATEGORY);
		ExcelBean element2 = ExcelProperty.getElementValue(HOME_PAGE, HOMEPAGE_DINING_CATEGORY);
		ExcelBean element3 = ExcelProperty.getElementValue(HOME_PAGE, HOMEPAGE_BEDROOM_CATEGORY);
		ExcelBean element4 = ExcelProperty.getElementValue(HOME_PAGE, HOMEPAGE_MATTRESSES_CATEGORY);
		ExcelBean element5 = ExcelProperty.getElementValue(HOME_PAGE, HOMEPAGE_OFFICE_CATEGORY);
		ExcelBean element6 = ExcelProperty.getElementValue(HOME_PAGE, HOMEPAGE_BABY_KIDS_CATEGORY);
		ExcelBean element7 = ExcelProperty.getElementValue(HOME_PAGE, HOMEPAGE_RUGS_LIGHTING_CATEGORY);
		ExcelBean element8 = ExcelProperty.getElementValue(HOME_PAGE, HOMEPAGE_DECOR_CATEGORY);
		ExcelBean element9 = ExcelProperty.getElementValue(HOME_PAGE, HOMEPAGE_OUTDOOR_CATEGORY);
		ExcelBean element10 = ExcelProperty.getElementValue(HOME_PAGE, HOMEPAGE_DESIGN_CATEGORY);
		ExcelBean element11 = ExcelProperty.getElementValue(HOME_PAGE, HOMEPAGE_OUTLET_CATEGORY);
		ExcelBean element12 = ExcelProperty.getElementValue(HOME_PAGE, HOMEPAGE_SALE_CATEGORY);

		boolean flag = false;
		try {
			flag = SeleniumUtils.iSDisplayed(element1);
			flag = SeleniumUtils.iSDisplayed(element2);
			flag = SeleniumUtils.iSDisplayed(element3);
			flag = SeleniumUtils.iSDisplayed(element4);
			flag = SeleniumUtils.iSDisplayed(element5);
			flag = SeleniumUtils.iSDisplayed(element6);
			flag = SeleniumUtils.iSDisplayed(element7);
			flag = SeleniumUtils.iSDisplayed(element8);
			flag = SeleniumUtils.iSDisplayed(element9);
			flag = SeleniumUtils.iSDisplayed(element10);
			flag = SeleniumUtils.iSDisplayed(element11);
			flag = SeleniumUtils.iSDisplayed(element12);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("System Should navigate to the static page");
		return flag;
	}

	public static void hoverOnBabyAndKidsL1category() throws Exception {
		SeleniumUtils.onHover(ExcelProperty.getElementValue(HOME_PAGE, HOMEPAGE_BABY_KIDS_CATEGORY));
		SeleniumUtils.wait(3);
	}

	public static boolean verifyL2Category() throws Exception {
		ExcelBean element1 = ExcelProperty.getElementValue(HOME_PAGE, KIDS_BEDS_HEADBOADS_L2_CATEGORY);
		ExcelBean element2 = ExcelProperty.getElementValue(HOME_PAGE, KIDS_FURNITURE_L2_CATEGORY);
		ExcelBean element3 = ExcelProperty.getElementValue(HOME_PAGE, KIDS_BEDDINGS_DECOR_L2_CATEGORY);
		ExcelBean element4 = ExcelProperty.getElementValue(HOME_PAGE, KIDS_NURSERY_L2_CATEGORY);

		boolean flag = false;
		try {
			flag = SeleniumUtils.iSDisplayed(element1);
			flag = SeleniumUtils.iSDisplayed(element2);
			flag = SeleniumUtils.iSDisplayed(element3);
			flag = SeleniumUtils.iSDisplayed(element4);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("System Should display L2 category on flyout");
		return flag;
	}

	public static boolean verifyL3Category() throws Exception {
		ExcelBean element1 = ExcelProperty.getElementValue(HOME_PAGE, KIDS_BEDS_L3_CATEGORY);
		ExcelBean element2 = ExcelProperty.getElementValue(HOME_PAGE, KIDS_DRESSERS_AND_CHESTS_L3_CATEGORY);
		ExcelBean element3 = ExcelProperty.getElementValue(HOME_PAGE, KIDS_BERDDING_L3_CATEGORY);
		ExcelBean element4 = ExcelProperty.getElementValue(HOME_PAGE, CRIBS_AND_TODDLER_BEDS_L3_CATEGORY);

		boolean flag = false;
		try {
			flag = SeleniumUtils.iSDisplayed(element1);
			flag = SeleniumUtils.iSDisplayed(element2);
			flag = SeleniumUtils.iSDisplayed(element3);
			flag = SeleniumUtils.iSDisplayed(element4);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("System Should display L3 category on flyout");
		return flag;
	}

	public static void clickOnKidsBedsL3Category() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(HOME_PAGE, KIDS_BEDS_L3_CATEGORY));
		SeleniumUtils.wait(3);
	}

	public static boolean verifyProductDetailPage() throws Exception {
		ExcelBean element1 = ExcelProperty.getElementValue(HOME_PAGE, TITLE_IN_PRODUCT_DETAIL_PAGE);
		ExcelBean element2 = ExcelProperty.getElementValue(HOME_PAGE, FILTER_BY_TITLE);
		ExcelBean element3 = ExcelProperty.getElementValue(HOME_PAGE, SORT_BY);

		boolean flag = false;
		try {
			flag = SeleniumUtils.iSDisplayed(element1);
			flag = SeleniumUtils.iSDisplayed(element2);
			flag = SeleniumUtils.iSDisplayed(element3);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("System Should navigate to the product detail page");
		return flag;
	}

	public static void clickOnKidsDressersAndChestsL3Category() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(HOME_PAGE, KIDS_DRESSERS_AND_CHESTS_L3_CATEGORY));
		SeleniumUtils.wait(3);
	}

	public static void clickOnKidsBeddingL3Category() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(HOME_PAGE, KIDS_BERDDING_L3_CATEGORY));
		SeleniumUtils.wait(3);
	}

	public static void clickOnCribsAndToddlerBedsL3Category() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(HOME_PAGE, CRIBS_AND_TODDLER_BEDS_L3_CATEGORY));
		SeleniumUtils.wait(3);
	}

	public static void clickOnKidsBedsHeadBoadsL2Category() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(HOME_PAGE, KIDS_BEDS_HEADBOADS_L2_CATEGORY));
		SeleniumUtils.wait(3);
	}

	public static void clickOnKidsFurnitureL2Category() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(HOME_PAGE, KIDS_FURNITURE_L2_CATEGORY));
		SeleniumUtils.wait(3);
	}

	public static void clickOnKidsbeddingsDecorL2Category() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(HOME_PAGE, KIDS_BEDDINGS_DECOR_L2_CATEGORY));
		SeleniumUtils.wait(3);
	}

	public static void clickOnKidsNurseryL2Category() throws Exception {
		SeleniumUtils.click(ExcelProperty.getElementValue(HOME_PAGE, KIDS_NURSERY_L2_CATEGORY));
		SeleniumUtils.wait(3);
	}

}
