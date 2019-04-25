package packag;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test3 {
	@Test
	public void seleniumTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
	}
}
