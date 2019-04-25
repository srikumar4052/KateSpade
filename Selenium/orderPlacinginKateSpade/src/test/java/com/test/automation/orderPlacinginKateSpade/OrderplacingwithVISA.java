package com.test.automation.orderPlacinginKateSpade;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrderplacingwithVISA {
	WebDriver driver;

	@BeforeClass
	public void Pagelunch() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"D:/Automation Scripts/Selenium/orderPlacinginKateSpade/drivers/chromedriver..exe");
		driver = new ChromeDriver();
		driver.get(
				"https://dev27-eu-katespade.demandware.net/on/demandware.store/Sites-toroOfficial-Site/default/Home-Show");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// Closing the Popup

		try {

			popup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * @AfterClass public void PageClose() throws InterruptedException {
	 * Thread.sleep(3000); driver.close(); }
	 */

	@Test
	public void guestUsrOrderplacewithVisa() throws InterruptedException {
		{

			GoingtoWatches();
			waiting(6);
			scrolling_Down();
			/*
			 * clickingtheDesiredElement(); AddToBagAndViewBag(); CheckoutAsGuest();
			 * Shipping(); payment(); review();
			 */

		}
	}

	public void waiting(int seconds) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	public void popup() {
		driver.findElement(By.xpath("//a[@id='bx-close-inside-945033']"));

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement Promotion = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='bx-close-inside-945033']")));

		driver.findElement(By.xpath("//*[@id='bx-close-inside-945033']")).click();
	}

	public void GoingtoWatches() throws InterruptedException {

		Actions move = new Actions(driver);
		waiting(2);
		WebElement Jewellery = driver.findElement(
				By.xpath("(//a[@href='http://dev27-eu-katespade.demandware.net/s/toroOfficial/ks-jewellery'])[1]"));
		WebElement watches = driver.findElement(By.xpath("(//a[contains(text(),'watches')])[2]"));
		move.moveToElement(Jewellery).perform();
		waiting(2);
		move.moveToElement(watches).click().build().perform();
	}

	public void scrolling_Down() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3000)");
		Thread.sleep(3000);

	}

	public void clickingtheDesiredElement() throws InterruptedException {
		driver.findElement(
				By.xpath("//img[@src='http://testvipd4.scene7.com/is/image/KateSpade/KSS1603_293_2?$rr_productgrid$']"))
				.click();
		Thread.sleep(1000);
	}

	public void SelectingtheQuantity() {
		/*
		 * WebElement QTY =
		 * driver.findElement(By.xpath("//*[@id='pdpQtySelectSelectBoxItText']"));
		 * QTY.click(); driver.findElement(By.xpath("//*[@id=\"1\"]")).click();
		 */
		Select QtyDrpdown = new Select(driver.findElement(By.xpath("(//select[@id='Quantity'])[1]")));
		QtyDrpdown.selectByIndex(2);
	}

	public void AddToBagAndViewBag() {

		driver.findElement(By.xpath("//*[@id='add-to-cart']")).click();
		/* driver.findElement(By.xpath("//a[text()='View Bag / Checkout']")).click(); */
		driver.findElement(By.xpath("//a[@title=\"Go to Cart\"]")).click();

	}

	public void CheckoutAsGuest() {
		driver.findElement(By.xpath("(//button[@value='Checkout'])[2]")).click();
		driver.findElement(By.xpath("//button[@name=\"dwfrm_login_unregistered\"]")).click();
	}

	public void Shipping() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_firstName']"))
				.sendKeys("mose", Keys.TAB, "Alci", Keys.TAB, "10 Hudson Yards");
		driver.findElement(By.xpath("//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_zip']"))
				.sendKeys("10001");
		driver.findElement(By.xpath("//label[@for='dwfrm_singleshipping_shippingAddress_useAsBillingAddress']"))
				.click();
		driver.findElement(By.xpath("//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_phone']"))
				.sendKeys("7008939926");
		driver.findElement(By.xpath("//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_email']"))
				.sendKeys("kreddy@tapestry.com");
		waiting(3);
		driver.findElement(By.xpath("//div[@class='continuecheckoutbutton form-row form-row-button']")).click();
	}

	public void payment() {
		driver.findElement(By.xpath("//input[@id='dwfrm_billing_paymentMethods_creditCard_owner']"))
				.sendKeys("Testing Purpose", Keys.TAB, "4012000033330026", Keys.TAB, "10/20", Keys.TAB, "737");
		driver.findElement(By.xpath("//button[@value='Review Your Order']")).click();
	}

	public void review() {
		driver.findElement(By.xpath("(//button[@value='Place Order'])[3]")).click();
	}

}
