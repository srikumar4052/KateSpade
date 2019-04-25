package com.ch.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ch.ExcelUtils.ExcelBean;
import com.ch.ksd.utils.constants.FileConstants;

public class SeleniumUtils extends PropertyUtil implements FileConstants {

	/**
	 * This method is used to Load the URL Example: public static void
	 * getURL(http://www.chtsinc.com)
	 */
	public static void getURL(String url) {
		DriverFactory.getDriver().navigate().to(url);
	}

	/**
	 * This Method is used to Close the Browser
	 */
	public static void quitDriver() {
		DriverFactory.getDriver().close();

	}

	// getting css values
	public static String getCSSValueLinkText(String ele, String cssvalue) throws Exception {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(ele)));
		Thread.sleep(3000);
		element1.click();
		return element1.getCssValue(cssvalue);
	}

	public static String getCSSValueCssSelector(String ele, String cssvalue) throws Exception {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ele)));
		Thread.sleep(3000);
		return element1.getCssValue(cssvalue);
	}

	public static String getCSSValueXPath(String ele, String cssvalue) throws Exception {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ele)));
		Thread.sleep(3000);
		return element1.getCssValue(cssvalue);
	}

	public static String getCSSValueId(String ele, String cssvalue) throws Exception {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ele)));
		Thread.sleep(3000);
		return element1.getCssValue(cssvalue);
	}

	public static String getCSSValuePartialLink(String ele, String cssvalue) throws Exception {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(ele)));
		Thread.sleep(3000);
		return element1.getCssValue(cssvalue);
	}

	public static void clearCookies() {
		DriverFactory.getDriver().manage().deleteAllCookies();
	}

	public static String getCSSValueClass(String ele, String cssvalue) throws Exception {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(ele)));
		Thread.sleep(3000);
		return element1.getCssValue(cssvalue);
	}

	// click the elements

	public static void clickByXPath(String element) throws Exception {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
		Thread.sleep(3000);
		element1.click();
	}

	public static void clickById(String element) throws Exception {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
		Thread.sleep(3000);
		element1.click();
	}

	public static void clickByLinkText(String element) throws Exception {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(element)));
		Thread.sleep(2000);
		element1.click();
	}

	public static void clickByClass(String element) throws Exception {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(element)));
		Thread.sleep(3000);
		element1.click();
	}

	public static void clickByPartialLink(String element) throws Exception {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(element)));
		Thread.sleep(3000);
		element1.click();
	}

	public static void clickByCSSSelector(String element) throws Exception {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element)));
		Thread.sleep(3000);
		element1.click();
	}

	public static void clickByName(String element) throws Exception {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(element)));
		Thread.sleep(3000);
		element1.click();
	}

	// verify from page source
	public static boolean PageSourceContains(String element) {
		return DriverFactory.getDriver().getPageSource().contains(element);
	}

	// send keys

	public static void sendKeysXpath(String element, String data) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
		element1.sendKeys(data);
	}

	public static void sendKeysPartialLink(String element, String data) {
		DriverFactory.getDriver().findElement(By.partialLinkText(element)).sendKeys(data);
	}

	public static void sendKeysClassName(String element, String data) {
		DriverFactory.getDriver().findElement(By.className(element)).sendKeys(data);
	}

	public static void sendKeysCssSelector(String element, String data) {
		DriverFactory.getDriver().findElement(By.cssSelector(element)).sendKeys(data);
	}

	public static void sendKeysLinkText(String element, String data) {
		DriverFactory.getDriver().findElement(By.linkText(element)).sendKeys(data);
	}

	public static void sendKeysById(String element, String data) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
		element1.sendKeys(data);
	}

	public static void sendKeysByName(String element, String data) {
		DriverFactory.getDriver().findElement(By.name(element)).sendKeys(data);
	}

	// onhover

	public static void onhoverClickLinkText(String element, String element1) {
		Actions actions = new Actions(DriverFactory.getDriver());
		WebElement ele = DriverFactory.getDriver().findElement(By.linkText(element));
		actions.moveToElement(ele).build().perform();
		DriverFactory.getDriver().findElement(By.linkText(element1)).click();
	}

	public static void onhoverLinkText(String element) {
		Actions actions = new Actions(DriverFactory.getDriver());
		WebElement ele = DriverFactory.getDriver().findElement(By.linkText(element));
		actions.moveToElement(ele).build().perform();
	}

	public static void onhoverClickCss(String element, String element1) {
		Actions actions = new Actions(DriverFactory.getDriver());
		WebElement ele = DriverFactory.getDriver().findElement(By.cssSelector(element));
		actions.moveToElement(ele).build().perform();
		DriverFactory.getDriver().findElement(By.cssSelector(element1)).click();
	}

	public static void onhoverClickName(String element, String element1) {
		Actions actions = new Actions(DriverFactory.getDriver());
		WebElement ele = DriverFactory.getDriver().findElement(By.name(element));
		actions.moveToElement(ele).build().perform();
		DriverFactory.getDriver().findElement(By.cssSelector(element1)).click();
	}

	public static void onhoverClickXpath(String element, String element1) {
		Actions actions = new Actions(DriverFactory.getDriver());
		WebElement ele = DriverFactory.getDriver().findElement(By.xpath(element));
		actions.moveToElement(ele).build().perform();
		DriverFactory.getDriver().findElement(By.xpath(element1)).click();
	}

	public static void onhoverXPath(String element) {
		Actions actions = new Actions(DriverFactory.getDriver());
		WebElement ele = DriverFactory.getDriver().findElement(By.xpath(element));
		actions.moveToElement(ele).build().perform();

	}

	public static void onhoverClickXpathLink(String element, String element1) {
		Actions actions = new Actions(DriverFactory.getDriver());
		WebElement ele = DriverFactory.getDriver().findElement(By.xpath(element));
		actions.moveToElement(ele).build().perform();
		DriverFactory.getDriver().findElement(By.linkText(element1)).click();
	}

	public static void onhoverClickIdLink(String element, String element1) {
		Actions actions = new Actions(DriverFactory.getDriver());
		WebElement ele = DriverFactory.getDriver().findElement(By.id(element));
		actions.moveToElement(ele).build().perform();
		DriverFactory.getDriver().findElement(By.linkText(element1)).click();
	}

	public static void onhoverClickClass(String element, String element1) {
		Actions actions = new Actions(DriverFactory.getDriver());
		WebElement ele = DriverFactory.getDriver().findElement(By.className(element));
		actions.moveToElement(ele).build().perform();
		DriverFactory.getDriver().findElement(By.className(element1)).click();
	}

	// getting css values
	public static String getCssValue(Type type, String element, String cssvalue) throws Exception {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = SeleniumHelperUtils.elements(type, element, wait);
		return element1.getCssValue(cssvalue);
	}

	// getting css values
	public static String getCssValue(ExcelBean bean, String cssvalue) throws Exception {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = SeleniumHelperUtils.elements(bean, wait);
		return element1.getCssValue(cssvalue);
	}

	// getting Tag name
	public static String getTagName(ExcelBean bean) throws Exception {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = SeleniumHelperUtils.elements(bean, wait);
		return element1.getTagName();
	}

	// click the elements
	public static void click(Type type, String element) throws Exception {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = SeleniumHelperUtils.elements(type, element, wait);
		Thread.sleep(1000);
		element1.click();
	}

	public static void click(ExcelBean bean) throws Exception {
		WebElement element1 = SeleniumHelperUtils.fluentWaitElements(bean);
		Thread.sleep(1000);
		element1.click();
	}

	public static WebElement getWebElement(ExcelBean bean) throws Exception {
		WebElement element1 = SeleniumHelperUtils.fluentWaitElements(bean);
		Thread.sleep(1000);
		return element1;
	}

	public static WebElement getWebElement(Type type, String element) throws Exception {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = SeleniumHelperUtils.elements(type, element, wait);
		Thread.sleep(1000);
		return element1;
	}

	// to get text
	public static String getText(Type type, String element) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = SeleniumHelperUtils.elements(type, element, wait);
		return element1.getText();
	}

	public static String getText(ExcelBean bean) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = SeleniumHelperUtils.elements(bean, wait);
		return element1.getText();
	}

	// send keys
	public static void sendKeys(Type type, String element, String data) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = SeleniumHelperUtils.elements(type, element, wait);
		element1.clear();
		Thread.sleep(1000);
		element1.sendKeys(data);
	}

	public static void sendKeys(ExcelBean bean, String data) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = SeleniumHelperUtils.elements(bean, wait);
		element1.clear();
		Thread.sleep(1000);
		element1.clear();
		element1.sendKeys(data);
	}

	// on hover click
	public static void onHoverAndClick(Type type, String element, Type type1, String element1) throws Exception {
		Actions actions = new Actions(DriverFactory.getDriver());
		WebElement ele = null;
		if (type.equals(Type.CLASSNAME)) {
			ele = DriverFactory.getDriver().findElement(By.className(element));
		} else if (type.equals(Type.CSSSELECTOR)) {
			ele = DriverFactory.getDriver().findElement(By.cssSelector(element));
		} else if (type.equals(Type.XPATH)) {
			ele = DriverFactory.getDriver().findElement(By.xpath(element));
		} else if (type.equals(Type.LINKTEXT)) {
			ele = DriverFactory.getDriver().findElement(By.linkText(element));
		} else if (type.equals(Type.ID)) {
			ele = DriverFactory.getDriver().findElement(By.id(element));
		}
		actions.moveToElement(ele).build().perform();
		SeleniumUtils.wait(1);
		if (type1.equals(Type.CLASSNAME)) {
			DriverFactory.getDriver().findElement(By.className(element1)).click();
		} else if (type1.equals(Type.CSSSELECTOR)) {
			DriverFactory.getDriver().findElement(By.cssSelector(element1)).click();
		} else if (type1.equals(Type.XPATH)) {
			DriverFactory.getDriver().findElement(By.xpath(element1)).click();
		} else if (type1.equals(Type.LINKTEXT)) {
			DriverFactory.getDriver().findElement(By.linkText(element1)).click();
		} else if (type1.equals(Type.ID)) {
			DriverFactory.getDriver().findElement(By.id(element1)).click();
		}
	}

	// Click Using JavaScript
	public static void javaScriptClick(Type type, int offset, String element) throws Exception {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = SeleniumHelperUtils.elements(type, element, wait);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getDriver();
		int yScrollPosition = element1.getLocation().getY() - offset;
		executor.executeScript("window.scroll(0, " + yScrollPosition + ");");
		element1.click();
	}

	public static void javaScriptClick(ExcelBean bean, int offset) throws Exception {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = SeleniumHelperUtils.elements(bean, wait);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getDriver();
		int yScrollPosition = element1.getLocation().getY() - offset;
		executor.executeScript("window.scroll(0, " + yScrollPosition + ");");
		element1.click();
	}

	// Hover Using JavaScript
	public static void javaScriptOnHover(Type type, int offset, String element) {
		Actions actions = new Actions(DriverFactory.getDriver());
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = SeleniumHelperUtils.elements(type, element, wait);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getDriver();
		int yScrollPosition = element1.getLocation().getY() - offset;
		executor.executeScript("window.scroll(0, " + yScrollPosition + ");");
		actions.moveToElement(element1).build().perform();
	}

	public static void javaScriptOnHover(ExcelBean bean, int offset) {
		Actions actions = new Actions(DriverFactory.getDriver());
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = SeleniumHelperUtils.elements(bean, wait);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getDriver();
		int yScrollPosition = element1.getLocation().getY() - offset;
		executor.executeScript("window.scroll(0, " + yScrollPosition + ");");
		actions.moveToElement(element1).build().perform();
	}

	// On Hover
	public static void onHover(Type type, String element) {
		Actions actions = new Actions(DriverFactory.getDriver());
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = SeleniumHelperUtils.elements(type, element, wait);
		actions.moveToElement(element1).build().perform();
	}

	public static void onHover(ExcelBean bean) {
		Actions actions = new Actions(DriverFactory.getDriver());
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = SeleniumHelperUtils.elements(bean, wait);
		actions.moveToElement(element1).build().perform();
	}

	public static void onHoverClick(ExcelBean bean, ExcelBean bean1) {
		Actions actions = new Actions(DriverFactory.getDriver());
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = SeleniumHelperUtils.elements(bean, wait);
		actions.moveToElement(element1).build().perform();
		WebElement element2 = SeleniumHelperUtils.elements(bean1, wait);
		element2.click();
	}

	// drop downs
	public static void dropDownByVisibleText(Type type, String element, String text) {
		Select sel = SeleniumHelperUtils.fluentElementDropDown(type, element);
		sel.selectByVisibleText(text);
	}

	public static String getDropDownSelectedText(Type type, String element) {
		Select sel = SeleniumHelperUtils.fluentElementDropDown(type, element);
		String text2 = sel.getFirstSelectedOption().getText();
		return text2;
	}

	public static String getDropDownSelectedText(ExcelBean bean) {
		Select sel = SeleniumHelperUtils.fluentElementDropDown(bean);
		String text2 = sel.getFirstSelectedOption().getText();
		return text2;
	}

	public static void dropDownByVisibleText(ExcelBean bean, String text) {
		Select sel = SeleniumHelperUtils.fluentElementDropDown(bean);
		sel.selectByVisibleText(text);
	}

	public static List<WebElement> dropDownOptions(ExcelBean bean) {
		Select sel = SeleniumHelperUtils.fluentElementDropDown(bean);
		return sel.getOptions();
	}

	public static List<String> getDropDownOptions(ExcelBean bean) {
		ArrayList<String> data = new ArrayList<>();
		Select sel = SeleniumHelperUtils.fluentElementDropDown(bean);
		List<WebElement> options = sel.getOptions();
		for (WebElement webElement : options) {
			data.add(webElement.getText());
		}
		return data;
	}

	public static int getDropDownOptionsSize(ExcelBean bean) {
		Select sel = SeleniumHelperUtils.fluentElementDropDown(bean);
		List<WebElement> options = sel.getOptions();
		return options.size();
	}

	public static void dropDownByValue(Type type, String element, String value) {
		Select sel = SeleniumHelperUtils.fluentElementDropDown(type, element);
		sel.selectByValue(value);
	}

	public static void dropDownByValue(ExcelBean bean, String value) {
		Select sel = SeleniumHelperUtils.fluentElementDropDown(bean);
		sel.selectByValue(value);
	}

	public static List<WebElement> getAllSelectedOptions(ExcelBean bean) {
		Select sel = SeleniumHelperUtils.fluentElementDropDown(bean);
		List<WebElement> allSelectedOptions = sel.getAllSelectedOptions();
		return allSelectedOptions;
	}

	public static void dropDownByIndex(Type type, String element, int index) {
		Select sel = SeleniumHelperUtils.fluentElementDropDown(type, element);
		sel.selectByIndex(index);
	}

	public static List<WebElement> getAllSelectedOptions(Type type, String element) {
		Select sel = SeleniumHelperUtils.fluentElementDropDown(type, element);
		List<WebElement> allSelectedOptions = sel.getAllSelectedOptions();
		return allSelectedOptions;
	}

	public static void dropDownByIndex(ExcelBean bean, int index) {
		Select sel = SeleniumHelperUtils.fluentElementDropDown(bean);
		sel.selectByIndex(index);
	}

	public static WebElement dropDownFirstSelectedText(ExcelBean bean) {
		Select sel = SeleniumHelperUtils.fluentElementDropDown(bean);
		return sel.getFirstSelectedOption();
	}

	public static void isMultipleSelection(ExcelBean bean) {
		Select sel = SeleniumHelperUtils.fluentElementDropDown(bean);
		sel.isMultiple();
	}

	public static List<WebElement> getAllWebElementsByTagA() {
		return DriverFactory.getDriver().findElements(By.tagName("a"));
	}

	// get Attributes
	public static String getAttributes(Type type, String element, String attribute) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = SeleniumHelperUtils.elements(type, element, wait);
		return element1.getAttribute(attribute);
	}

	public static String getAttributes(ExcelBean bean, String attribute) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = SeleniumHelperUtils.elements(bean, wait);
		return element1.getAttribute(attribute);
	}

	public static void clickByParentHtml(ExcelBean bean) {
		String elementHtml = bean.getValue();
		String[] split = elementHtml.split("##");
		List<WebElement> data = SeleniumHelperUtils.fluentTagElement(split[0], split[0]);
		for (WebElement webElement : data) {
			String attribute = webElement.getAttribute(split[1]);
			if (attribute != null) {
				if (attribute.equals(split[2])) {
					webElement.click();
					break;
				}
			}
		}
	}

	public static String getTextByParentHtml(ExcelBean bean) {
		String elementHtml = bean.getValue();
		String[] split = elementHtml.split("##");
		String text = "";
		List<WebElement> data = SeleniumHelperUtils.fluentTagElement(split[0], split[0]);
		for (WebElement webElement : data) {
			String attribute = webElement.getAttribute(split[1]);
			if (attribute != null) {
				if (attribute.equals(split[2])) {
					text = webElement.getText();
					break;
				}
			}
		}
		return text;
	}

	public static void sendKeysByParentHtml(ExcelBean bean, String keys) {
		String elementHtml = bean.getValue();
		String[] split = elementHtml.split("##");
		List<WebElement> data = SeleniumHelperUtils.fluentTagElement(split[0], split[0]);
		for (WebElement webElement : data) {
			String attribute = webElement.getAttribute(split[1]);
			if (attribute != null) {
				if (attribute.equals(split[2])) {
					webElement.sendKeys(keys);
					break;
				}
			}
		}
	}

	public static String getCssValueByParentHtml(ExcelBean bean, String css) {
		String elementHtml = bean.getValue();
		String[] split = elementHtml.split("##");
		List<WebElement> data = SeleniumHelperUtils.fluentTagElement(split[0], split[0]);
		String cssValue = "";
		for (WebElement webElement : data) {
			String attribute = webElement.getAttribute(split[1]);
			if (attribute != null) {
				if (attribute.equals(split[2])) {
					cssValue = webElement.getCssValue(css);
					break;
				}
			}
		}
		return cssValue;
	}

	public static List<WebElement> getElementsByParentHtml(ExcelBean bean, String keys) {
		String elementHtml = bean.getValue();
		String[] split = elementHtml.split("##");
		List<WebElement> data = SeleniumHelperUtils.fluentTagElement(split[0], split[0]);
		return data;
	}

	// Boolean is enabled
	public static boolean isEnabled(Type type, String element) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = SeleniumHelperUtils.elements(type, element, wait);
		return element1.isEnabled();
	}

	public static boolean isEnabled(ExcelBean bean) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = SeleniumHelperUtils.elements(bean, wait);
		return element1.isEnabled();
	}

	// Boolean is displayed
	public static boolean iSDisplayed(Type type, String element) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = SeleniumHelperUtils.elements(type, element, wait);
		return element1.isDisplayed();
	}

	public static boolean iSDisplayed(ExcelBean bean) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = SeleniumHelperUtils.elements(bean, wait);
		return element1.isDisplayed();
	}

	// Boolean is selected
	public static boolean isSelected(Type type, String element) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = SeleniumHelperUtils.elements(type, element, wait);
		return element1.isSelected();
	}

	public static boolean isSelected(ExcelBean bean) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		WebElement element1 = SeleniumHelperUtils.elements(bean, wait);
		return element1.isSelected();
	}

	public static int wait(int time) throws Exception {
		int i = 1000;
		time = time * i;
		Thread.sleep(time);
		return time;
	}

	// verify from page source
	public static void PageSoourcecont(String element) {
		DriverFactory.getDriver().getPageSource().contains(element);
	}

	// frames switching
	public static void switchingFrameById(String frameid) {
		DriverFactory.getDriver().switchTo().frame(frameid);
	}

	public static void switchingFrameByNumber(int framenumber) {
		DriverFactory.getDriver().switchTo().frame(framenumber);
	}

	public static void switchingDefaultContent() {
		DriverFactory.getDriver().switchTo().defaultContent();
	}

	// Alerts
	public static void acceptAlert() {
		Alert alert = DriverFactory.getDriver().switchTo().alert();
		alert.accept();
	}

	public static void dismissAlert() {
		Alert alert = DriverFactory.getDriver().switchTo().alert();
		alert.dismiss();
	}

	public static String alertGetText() {
		Alert alert = DriverFactory.getDriver().switchTo().alert();
		return alert.getText();
	}

	public static void refresh() {
		DriverFactory.getDriver().navigate().refresh();
	}

	public static void browserBack() {
		DriverFactory.getDriver().navigate().back();
	}

	public static void keys(Keys keys) {
		Actions ac = new Actions(DriverFactory.getDriver());
		ac.sendKeys(keys);
		ac.build().perform();
	}

	public static void clickByContainsHref(ExcelBean bean) throws Exception {
		List<WebElement> anchors = SeleniumHelperUtils.getAllElements(bean);
		Iterator<WebElement> i = anchors.iterator();
		while (i.hasNext()) {
			WebElement anchor = i.next();
			String value = bean.getValue();
			if (anchor.getAttribute("href").contains(value)) {
				anchor.click();
				break;
			}
		}
	}

	public static void clickByEqualsHref(ExcelBean bean) throws Exception {
		List<WebElement> anchors = SeleniumHelperUtils.getAllElements(bean);
		Iterator<WebElement> i = anchors.iterator();
		while (i.hasNext()) {
			WebElement anchor = i.next();
			String value = bean.getValue();
			if (anchor.getAttribute("href").equals(value)) {
				anchor.click();
				break;
			}
		}
	}

	public static void openNewBrowser() {
		if (DriverFactory.getDriver() instanceof JavascriptExecutor) {
			((JavascriptExecutor) DriverFactory.getDriver()).executeScript("window.open();");
		}
	}

	public static void javaScriptExecutorUp(String position) throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getDriver();
		jse.executeScript("window.scrollBy(0,-" + position + ")", "");
		Thread.sleep(5000);
	}

	public static int javascriptexecutorPosition() throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getDriver();
		int value = (int) executor.executeScript("return window.scrollY;");
		return value;
	}

	public static void javaScriptExecutorDown(String position) throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getDriver();
		jse.executeScript("window.scrollBy(0," + position + ")", "");
	}

	public static List<WebElement> getAllElements(Type type, String element) {
		List<WebElement> ele = null;
		if (type.equals(Type.CLASSNAME)) {
			ele = SeleniumHelperUtils.fluentwaitElements(DriverFactory.getDriver(), By.className(element));
		} else if (type.equals(Type.CSSSELECTOR)) {
			ele = SeleniumHelperUtils.fluentwaitElements(DriverFactory.getDriver(), By.cssSelector(element));
		} else if (type.equals(Type.LINKTEXT)) {
			ele = SeleniumHelperUtils.fluentwaitElements(DriverFactory.getDriver(), By.linkText(element));
		} else if (type.equals(Type.XPATH)) {
			ele = SeleniumHelperUtils.fluentwaitElements(DriverFactory.getDriver(), By.xpath(element));
		} else if (type.equals(Type.ID)) {
			ele = SeleniumHelperUtils.fluentwaitElements(DriverFactory.getDriver(), By.id(element));
		} else if (type.equals(Type.PARTIALLINK)) {
			ele = SeleniumHelperUtils.fluentwaitElements(DriverFactory.getDriver(), By.partialLinkText(element));
		} else if (type.equals(Type.NAME)) {
			ele = SeleniumHelperUtils.fluentwaitElements(DriverFactory.getDriver(), By.name(element));
		}
		return ele;
	}

	public static List<WebElement> getAllElements(ExcelBean bean) {
		String type = bean.getType();
		String element = bean.getValue();
		List<WebElement> ele = null;
		if (type.equals(Type.CLASSNAME.name())) {
			ele = SeleniumHelperUtils.fluentwaitElements(DriverFactory.getDriver(), By.className(element));
		} else if (type.equals(Type.CSSSELECTOR.name())) {
			ele = SeleniumHelperUtils.fluentwaitElements(DriverFactory.getDriver(), By.cssSelector(element));
		} else if (type.equals(Type.LINKTEXT.name())) {
			ele = SeleniumHelperUtils.fluentwaitElements(DriverFactory.getDriver(), By.linkText(element));
		} else if (type.equals(Type.XPATH.name())) {
			ele = SeleniumHelperUtils.fluentwaitElements(DriverFactory.getDriver(), By.xpath(element));
		} else if (type.equals(Type.ID.name())) {
			ele = SeleniumHelperUtils.fluentwaitElements(DriverFactory.getDriver(), By.id(element));
		} else if (type.equals(Type.PARTIALLINK.name())) {
			ele = SeleniumHelperUtils.fluentwaitElements(DriverFactory.getDriver(), By.partialLinkText(element));
		} else if (type.equals(Type.NAME.name())) {
			ele = SeleniumHelperUtils.fluentwaitElements(DriverFactory.getDriver(), By.name(element));
		}
		return ele;
	}

	// for HTML
	public static WebElement findByElement(String key, String element) {
		By byElement = null;
		if (key.equalsIgnoreCase("xpath")) {
			byElement = By.xpath(element);
		} else if (key.equalsIgnoreCase("id")) {
			byElement = By.id(element);
		} else if (key.equalsIgnoreCase("className")) {
			byElement = By.className(element);
		} else if (key.equalsIgnoreCase("name")) {
			byElement = By.name(element);
		} else if (key.equalsIgnoreCase("css")) {
			byElement = By.cssSelector(element);
		} else if (key.equalsIgnoreCase("linkText")) {
			byElement = By.linkText(element);
		} else if (key.equalsIgnoreCase("partialLinkText")) {
			byElement = By.partialLinkText(element);
		}
		WebElement ele = DriverFactory.getDriver().findElement(byElement);
		return ele;
	}

}
