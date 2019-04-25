package kateSpade;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

public class Open_Close {

	WebDriver driver ;
	
	
	@BeforeClass
	public void PageOpen() throws InterruptedException
	{
		
			  System.setProperty("webdriver.chrome.driver", "‪‪C:\\Users\\dell\\Downloads\\chromedriver.exe");
			    driver = new ChromeDriver();
				driver.get("https://www.katespade.com/");
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
	
	
	 public void waiting()
	 {
		 driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);	 
	 }
	 
	 public void popup()
	 {
		 driver.findElement(By.xpath("//a[@id='bx-close-inside-945033']"));
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			WebElement Promotion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='bx-close-inside-945033']")));	
			 
			 driver.findElement(By.xpath("//*[@id='bx-close-inside-945033']")).click();
	 }

	/* @AfterClass
	  public void PageClose() throws InterruptedException
	  {
		  Thread.sleep(3000);
	  driver.close();
	  }*/
	 
	
}
