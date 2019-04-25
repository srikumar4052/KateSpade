package com.ch.utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ch.avf.utils.constants.FileConstants;

public class ParallelFactory implements FileConstants
{
    private static final String CHANGE = PropertyUtil.getConfigValue(MOBILE_PC);

    @BeforeMethod
    public void beforeInvocation()
    {
        try
        {
            resetWebDriver();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void resetWebDriver() throws Exception
    {
        quitDriver();
        if (CHANGE.equalsIgnoreCase("pc"))
        {
            System.out.println("***************************");
            WebDriver driver;
            driver = DriverFactory.webInstance(PropertyUtil.getConfigValue(BROWSER_NAME));
            DriverFactory.setWebDriver(driver);
        }
        if (CHANGE.equalsIgnoreCase("mobile"))
        {
            System.out.println("***************************");
            WebDriver driver = DriverFactory.getmobileDriver();
            DriverFactory.setWebDriver(driver);
        }
    }

    @AfterMethod
    public void afterInvocation()
    {
//        quitDriver();
    }

    private static void quitDriver()
    {
        WebDriver driver = DriverFactory.getDriver();
        boolean b = driver != null;
        if (b)
        {
            driver.quit();
            driver = null;
        }
    }
}