package com.test.automation.uiAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flight {

	public static void main(String[] args) {
// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/user/Downloads/chromedriver (2).exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("kruthika517@gmail.com", Keys.TAB,
				"123456789", Keys.TAB, Keys.ENTER);
// WebElement RadioBtns=driver.findElement(By.xpath("//font[@face='Arial, Helvetica, sans-serif']"));
		List<WebElement> r = driver.findElements(By.xpath("(//font[@size=\"2\"])[5]"));
	}

}