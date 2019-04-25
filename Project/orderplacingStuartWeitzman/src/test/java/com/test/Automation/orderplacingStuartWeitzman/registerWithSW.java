package com.test.Automation.orderplacingStuartWeitzman;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class registerWithSW {
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
	 * Thread.sleep(3000); driver.close();
	 * }//select[@id='dwfrm_profile_address_country']
	 */

	@Test
	public void Signup() throws InterruptedException, IOException {

		GoingtoSIGNUP();
		Register();
		AddAddress();
		LogOut();

	}

	public void waiting(int seconds) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	public void popup() {

		driver.findElement(By.xpath("//button[@title='Close']")).click();

	}

	public void GoingtoSIGNUP() throws InterruptedException {

		Actions move = new Actions(driver);
		waiting(2);
		WebElement SIGNUP = driver
				.findElement(By.xpath("//a[@href='/on/demandware.store/Sites-swEu-Site/en/Newsletter-Signup']"));
		WebElement EMAILADRESS = driver.findElement(By.xpath("//input[@id='emailsignup_email_header']"));
		WebElement SIGNUPbtn = driver.findElement(By.xpath("//input[@value='Sign Up']"));
		move.moveToElement(SIGNUP).perform();
		waiting(2);
		EMAILADRESS.sendKeys("kreddy@tapestry.com");
		SIGNUPbtn.click();
		waiting(6);
		driver.findElement(By.xpath("//a[@class='email-signup-create-account']")).click();
		waiting(2);
		popup();
	}

	private void Register() {
		driver.findElement(By.xpath("//input[@id='dwfrm_profile_customer_firstname']")).sendKeys("Kruthiaka", Keys.TAB,
				"Machoman", Keys.TAB, "kreddy@tapestry.com", Keys.TAB, "kreddy@tapestry.com", Keys.TAB, "nayak@1234",
				Keys.TAB, "nayak@1234");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//label[@for='privacy-opt-in']")).click();
		driver.findElement(By.xpath("//button[@value='submit']")).click();

	}

	private void AddAddress() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class=\"addressList\"]")).click();
		waiting(10);
		// Sign in with your Email Page
		driver.findElement(By.xpath("(//input[@placeholder='email@emailaddress.com'])[3]"))
				.sendKeys("kreddy@tapestry.com", Keys.TAB, "nayak@1234");
		driver.findElement(By.xpath("(//button[@value='Sign In'])[2]")).click();
		// Clicking on Add New Address button
		waiting(6);
		driver.findElement(By.xpath("//a[contains(text(),'Add new Address')]")).click();

		// Add Address in Address Popup
		waiting(4);
		driver.findElement(By.xpath("//input[@id='dwfrm_profile_address_addressid']")).sendKeys("Home Address",
				Keys.TAB, "Kruthiaka", Keys.TAB, "Machoman");
		// Country DrpDown
		Select sel = new Select(driver.findElement(By.xpath("//select[@id='dwfrm_profile_address_country']")));
		sel.selectByVisibleText("United Kingdom");
		// Postal Code
		driver.findElement(By.xpath("//input[@id='dwfrm_profile_address_postal']")).sendKeys("M17 8AA");
		// Enter Manually
		driver.findElement(By.xpath("//a[text()='Enter Manually']")).click();
		waiting(4);
		driver.findElement(By.xpath("//input[@id='dwfrm_profile_address_companyName']")).sendKeys("CH", Keys.TAB,
				"Lord's Cricket Ground", Keys.TAB, "St.John's Wood Road", Keys.TAB, "London");
		waiting(4);
		driver.findElement(By.xpath("//input[@id='dwfrm_profile_address_phone']")).sendKeys("1234567890");
		waiting(2);
		driver.findElement(By.xpath("//button[@value='Apply']")).click();

	}

	public void LogOut() {
		WebElement HiKruthiaka = driver.findElement(By.xpath("//div[@class='user-links has-icon signin']"));
		WebElement LOGOUT = driver.findElement(By.xpath("(//a[@class=\"user-logout\"])[2]"));
		Actions move = new Actions(driver);
		move.moveToElement(HiKruthiaka).perform();
		LOGOUT.click();
	}
}
