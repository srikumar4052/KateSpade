package com.test.automation.uiAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class VerifyLogin {
	@Test
	public void firstTest() {
		System.setProperty("webdriver.chrome.driver",
				"D:/Automation Scripts/Selenium/uiAutomation/drivers/windows/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/ajax.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		List<WebElement> elements = driver.findElements(By.name("name"));
		System.out.println("Number of elements:" + elements.size());

		for (int i = 0; i < elements.size(); i++) {
			System.out.println("Radio button text:" + elements.get(i).getAttribute("value"));
		}
	}
}
