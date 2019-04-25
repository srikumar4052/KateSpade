package kateSpade;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class Register extends Open_Close
{		 
	 @Test
	 public void Creat_Account() throws Exception
	 {
	account();
	reg();
		
	 } 
public void account()
{
	waiting();
	 driver.findElement(By.xpath("(//span[@class='desktop'])[3]")).click();
	 // Clicking on create an account button
	 driver.findElement(By.xpath("//a[text()='create an account']")).click();
}
	public void reg()
	{
System.out.println("xyz");

		/* // Registering the Data

		 driver.findElement(By.xpath("//*[@id=\"dwfrm_profile_customer_firstname\"]")).sendKeys("mose",Keys.TAB,"Alci",Keys.TAB,"SNAYAK@CHTSINC.COM");
		 driver.findElement(By.xpath("//*[@id=\"dwfrm_profile_customer_emailconfirm\"]")).sendKeys("SNAYAK@CHTSINC.COM",Keys.TAB,"nayak@1234");
		 driver.findElement(By.xpath("//*[@id=\"dwfrm_profile_login_passwordconfirm\"]")).sendKeys("nayak@1234");
		 driver.findElement(By.xpath("//*[@id=\"dwfrm_profile_customer_zip\"]")).sendKeys("10036");
		 //Clicking the submit button
		 driver.findElement(By.xpath("//button[@value='Submit']")).click();*/
	}
	
	
		 }
		
		
		 
	 
	

