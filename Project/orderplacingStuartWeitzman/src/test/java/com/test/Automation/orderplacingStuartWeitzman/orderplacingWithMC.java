package com.test.Automation.orderplacingStuartWeitzman;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class orderplacingWithMC {
	WebDriver driver;

	@BeforeClass
	public void Pagelunch() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"D:/Automation Scripts/Project/orderplacingStuartWeitzman/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://staging-eu01-stuartweitzman.demandware.net/s/swEu/en/default/");

		// Closing the Popup

		try {
			driver.findElement(By.xpath("//button[@title='Close']")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	@AfterClass
	public void PageClose() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}

	@Test
	public void guestUsrOrderplacewithMC() throws InterruptedException, IOException {

		GoingtoShoes();
		scrollingDown();
		clickingtheDesiredElement();
		Sizedrpdown();
		AddToBagAndViewBag();
		Shipping();
		Payment();
		confirmation();
		screenshot();

	}

	public void waiting() throws InterruptedException {
		Thread.sleep(2000);
	}

	public void popup() {

		driver.findElement(By.xpath("//button[@title='Close']")).click();

	}

	public void GoingtoShoes() throws InterruptedException {

		Actions move = new Actions(driver);
		waiting();
		WebElement BOOTSANDBOOTIES = driver.findElement(By
				.xpath("//a[@href='https://staging-eu01-stuartweitzman.demandware.net/s/swEu/en/boots-and-booties/']"));
		WebElement ALLBOOTS = driver.findElement(By.xpath("//a[@title='All Boots']"));
		move.moveToElement(BOOTSANDBOOTIES).perform();
		waiting();
		move.moveToElement(ALLBOOTS).click().build().perform();
		driver.findElement(By.xpath("//button[@title='Close']")).click();
		waiting();
	}

	public void scrollingDown() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3000)");
		Thread.sleep(3000);
	}

	public void clickingtheDesiredElement() throws InterruptedException {

		/*
		 * driver.findElement(By.xpath(
		 * "(//a[@href='https://staging-eu01-stuartweitzman.demandware.net/s/swEu/en/tieland/boots-and-booties/suede/beige/TIELANDSUEADO.html?dwvar_TIELANDSUEADO_color=ADO&cgid=boots'])[2]"
		 * )) .click();
		 */
		driver.findElement(By.xpath("(//img[@title='TIELAND BOOT in SLATE MEDIUM GRAY'])[2]")).click();
		Thread.sleep(1000);
	}

	public void Sizedrpdown() throws InterruptedException {
		// Choosing Color Swatches
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");

		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@class=\"attr-value size-value\" and contains(text(),\"size\")]")).click();
		// Choosing the Available size from the Sizedrpdwn
		for (int i = 1; i <= 18; i++) {
			if (driver.findElement(By.xpath("//ul[@class='swatches size']/li[" + i + "]/a")).isEnabled()) {
				driver.findElement(By.xpath("//ul[@class='swatches size']/li[" + i + "]/a")).click();

			}
			break;
		}
	}

	/*
	 * public void Widthdrpdown() throws InterruptedException { Select sel = new
	 * Select(driver.findElement(By.xpath("//select[@id='ddlWidth']")));
	 * sel.selectByIndex(1); Thread.sleep(2000); }
	 */
	public void AddToBagAndViewBag() throws InterruptedException {

		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='add-to-cart']")).click();
		waiting();
		driver.findElement(By.xpath("//a[text()='View Shopping Bag']")).click();
		// Selecting Quantity
		Select sel = new Select(
				driver.findElement(By.xpath("//select[@id='dwfrm_cart_shipments_i0_items_i0_quantity']")));
		sel.selectByIndex(0);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");

		driver.findElement(By.xpath("(//button[@value='Proceed to checkout'])[2]")).click();

	}

	public void Shipping() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='dwfrm_singleshipping_shippingAddress_email_emailAddress']"))
				.sendKeys("umodhipalli1@tapestry.com");
		driver.findElement(By.xpath("//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_firstName']"))
				.sendKeys("Kruthika", Keys.TAB, "Machoman");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");

		driver.findElement(By.xpath("//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_postal']"))
				.sendKeys("M17 8AA");

		driver.findElement(By.xpath("//a[text()='Enter Manually']")).click();
		waiting();
		driver.findElement(By.xpath("//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_companyName']"))
				.sendKeys("CH", Keys.TAB, "Lord's Cricket Ground", Keys.TAB, "St.John's Wood Road", Keys.TAB, "London");
		waiting();
		driver.findElement(By.xpath("//span[text()='Use this address for Billing']")).click();
		waiting();
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath("//button[@value='Continue to Payment']")).click();

	}

	public void Payment() throws InterruptedException {
		Select sel = new Select(
				driver.findElement(By.xpath("//select[@id='dwfrm_billing_paymentMethods_selectedPaymentMethodID']")));
		sel.selectByIndex(0);
		Thread.sleep(2000);
		Select sel2 = new Select(
				driver.findElement(By.xpath("//select[@id='dwfrm_billing_paymentMethods_creditCard_type']")));
		sel2.selectByIndex(3);
		driver.findElement(By.xpath("//input[@id='creditCard_owner']")).sendKeys("CH HUDSON", Keys.TAB,
				"2223 0000 4841 0010", Keys.TAB, "1020", Keys.TAB, "737");
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,500)");

		driver.findElement(By.xpath("//input[@id='dwfrm_billing_billingAddress_addressFields_phone']"))
				.sendKeys("7008939926");
		waiting();
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,150)");
		driver.findElement(By.xpath("//button[@id='billing-submit']")).click();
	}

	public void confirmation() {
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,150)");
		driver.findElement(By.xpath("//button[@value='Submit Order']")).click();
	}

	public void screenshot() throws IOException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,150)");
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,
				new File("D:\\Automation Scripts\\Project\\orderplacingStuartWeitzman\\screenshots\\OrderwithMC.png"));
	}

}
