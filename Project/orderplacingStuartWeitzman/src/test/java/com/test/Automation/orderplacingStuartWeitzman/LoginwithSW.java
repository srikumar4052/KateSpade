package com.test.Automation.orderplacingStuartWeitzman;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginwithSW {
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
	public void Login() throws InterruptedException {
		Actions move = new Actions(driver);
		waiting(2);
		WebElement Login = driver.findElement(By.xpath("(//a[@class='signup'])[1]"));
		waiting(5);
		move.moveToElement(Login).build().perform();
		WebElement Details = driver.findElement(By.xpath("//input[@id='dwfrm_login_username']"));
		Details.sendKeys("kreddy@tapestry.com", Keys.TAB, "nayak@1234", Keys.TAB, Keys.TAB, Keys.ENTER);
		// driver.findElement(By.xpath("//button[@name='dwfrm_login_login']")).click();
	}

	public void waiting(int seconds) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	public void popup() {

		driver.findElement(By.xpath("//button[contains(text(),'log in')]")).click();

	}
}
