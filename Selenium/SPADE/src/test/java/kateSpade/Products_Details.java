package kateSpade;



import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Products_Details extends Open_Close
{
	
	String det;
	XSSFRow row;
	 XSSFSheet sh;
  @Test
  public void Details() throws InterruptedException, IOException {
	  products();
	  
  }
  
  //Going to Products
  public void products() throws InterruptedException, IOException
  {
//	WebElement Clothing =driver.findElement(By.xpath("//a[@href=\"http://www.katespade.com/shop/clothing/\"]")) ;
//	WebElement View_all = driver.findElement(By.xpath("(//*[@data-nav-category=\"clothing\"])[1]"));
//	Actions a = new Actions(driver);
//	a.moveToElement(Clothing).pause(2000).moveToElement(View_all).click().build().perform();
//	
//	Thread.sleep(3000);
//
//	if(driver.findElement(By.xpath("//div[@class='search-result-content']")).isDisplayed())
//	{
//	List<WebElement> All = driver.findElements(By.xpath("//div[@class='search-result-content']"));
//	for(int i=0;i<All.size();i++)
//	{
//		det = All.get(i).getText();
//		System.out.println(det);
//	}
//	
//	}
//	
//	else
//	{ 
//	
//		System.out.println("Element is not Available");
//	}	
	 String path = "‪‪C:/Users/dell/Desktop/sri/zxc.xlsx";
	 FileOutputStream fos = new FileOutputStream(path);
	 XSSFWorkbook wb = new XSSFWorkbook();
	 sh = wb.createSheet("Vie");

//	 write_Data(sh);
//	 
//	 row = sh.createRow(0);
//	 XSSFCell cell =row.createCell(0);
//	 cell.setCellType(CellType.STRING);
//	 cell.setCellValue(det);
	
  }
  
  public void write_Data( XSSFSheet sh) 
  {
	     row = sh.createRow(0);
		 XSSFCell cell =row.createCell(0);
		 cell.setCellType(CellType.STRING);
		 cell.setCellValue("ItemName");
		 
		 cell =row.createCell(1);
		 cell.setCellType(CellType.STRING);
		 cell.setCellValue("Price");
	 
  }
  
}

