package packg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class plain {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

	System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\Downloads\\chromedriver.exe");
	
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.google.com//");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.findElement(By.name("q")).sendKeys("amazon");
	//WebDriverWait wait = new WebDriverWait(driver, 10);
	 
	// WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name("btnK")));
	Thread.sleep(4000);
	driver.close();
	
	}

}
