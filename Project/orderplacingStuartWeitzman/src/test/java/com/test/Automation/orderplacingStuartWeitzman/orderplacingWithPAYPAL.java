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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class orderplacingWithPAYPAL {
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

	/*
	 * @AfterClass public void PageClose() throws InterruptedException {
	 * Thread.sleep(3000); driver.close(); }
	 */

	@Test
	public void guestUsrOrderplacewithPAYPAL() throws InterruptedException, IOException {

		GoingtoBootsANDBooties();
		scrollingDown();
		clickingtheDesiredElement();
		Sizedrpdown();
		AddToBagAndViewBag();
		Shipping();
		Payment();
		confirmation();
		PaypalPaymentPage();
		screenshot();

	}

	public void waiting() throws InterruptedException {
		Thread.sleep(2000);
	}

	public void popup() {

		driver.findElement(By.xpath("//button[@title='Close']")).click();

	}

	public void GoingtoBootsANDBooties() throws InterruptedException {

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
		driver.findElement(By.xpath("(//a[@title='Go to Product: NIKI 60'])[2]")).click();
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

			} else {
				System.out.println("dfhi");
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

		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='add-to-cart']")).click();
		Thread.sleep(4000);
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
		sel.selectByIndex(1);
		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,500)");

		driver.findElement(By.xpath("//input[@id='dwfrm_billing_billingAddress_addressFields_phone']"))
				.sendKeys("7008939926");
		waiting();
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,150)");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement REVIEWORDER = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='billing-submit']")));
		driver.findElement(By.xpath("//button[@id='billing-submit']")).click();
	}

	public void confirmation() throws InterruptedException {
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,150)");
		driver.findElement(By.xpath("//button[@value='Submit Order']")).click();
		waiting();
	}

	public void PaypalPaymentPage() throws InterruptedException {

		waiting();
		/* driver.findElement(By.xpath("//input[@id='email']")).sendKeys(""); */
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		waiting();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("qa-uk@lyonscg.com", Keys.TAB, "testing2018");
		driver.findElement(By.xpath("//button[@id='btnLogin']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement PAYNOWPAYPAL = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Pay Now']")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		driver.findElement(By.xpath("(//a[@transitions-to='checkout.review'])[2]")).sendKeys(Keys.TAB, Keys.TAB);
		waiting();
		driver.findElement(By.xpath("//input[@value='Pay Now']")).click();
	}

	public void screenshot() throws IOException, InterruptedException {
		Thread.sleep(7000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(
				"D:\\Automation Scripts\\Project\\orderplacingStuartWeitzman\\screenshots\\OrderwithPAYPAL.png"));
	}

}
