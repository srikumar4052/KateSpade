package CH.sel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sun.corba.se.spi.orbutil.fsm.Action;

public class FlipcartEx1 {
	 WebDriver driver;
	 WebElement Electronics;
	 WebElement DSLR ;
	 
  @BeforeClass 
public void Browseropen()
	{
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\Downloads\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(4,TimeUnit.MINUTES);
		
	}
 
  
  @Test
  public void Browser()
  {
	  
	  driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
	   Electronics = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]//li[1]/span"));
	   DSLR = driver.findElement(By.xpath("//*[@id='container']/div/div[2]//li[1]/ul/li/ul/li[4]/ul/li[10]/a"));
	  Actions hov = new Actions(driver);
	  hov.moveToElement(Electronics).pause(2000).moveToElement(DSLR).click().build().perform();
	  
	  
	  
  }
  @AfterClass
  public void BrowClose() throws InterruptedException
  {
	  Thread.sleep(3000);
  driver.close();
  }
}
