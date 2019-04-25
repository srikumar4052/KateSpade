package com.ch.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.ch.avf.utils.constants.FileConstants;

public class DriverFactory extends PropertyUtil implements FileConstants
{
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver()
    {
        return webDriver.get();
    }

    public static void setWebDriver(WebDriver driver)
    {
        webDriver.set(driver);
    }

//    public static WebDriver webInstance(String browserName)
//    {
//        WebDriver driver = null;
//        switch (browserName)
//        {
//            case "firefox":
//                System.setProperty("webdriver.gecko.driver", GECKO_WINDOWS);
//                driver = new FirefoxDriver();
//                break;
//            case "IE":
//                System.setProperty("webdriver.ie.driver", I_E);
//                driver = new InternetExplorerDriver();
//                break;
//            case "safari":
//                driver = new SafariDriver();
//                break;
//            case "opera":
//                System.setProperty("webdriver.opera.driver", OPERA);
//                driver = new OperaDriver();
//                break;
//            case "chrome":
//                System.setProperty("webdriver.chrome.driver", CHROME_WINDOWS);
//                driver = new ChromeDriver();
//                break;
//            case "phantomjsWin":
//                System.setProperty("phantomjs.binary.path", PHANTOMJS_WIN);
//                driver = new PhantomJSDriver();
//                break;
//            case "headless":
//                driver = new HtmlUnitDriver(true);
//                break;
//            case "headlessChrome":
//                driver = new HtmlUnitDriver(BrowserVersion.CHROME, true);
//                break;
//            case "headlessFirefox":
//                driver = new HtmlUnitDriver(BrowserVersion.FIREFOX_52, true);
//                break;
//            case "headlessEdge":
//                driver = new HtmlUnitDriver(BrowserVersion.EDGE, true);
//                break;
//            case "headlessIE":
//                driver = new HtmlUnitDriver(BrowserVersion.INTERNET_EXPLORER, true);
//                break;
//            case "headlessDefault":
//                driver = new HtmlUnitDriver(BrowserVersion.BEST_SUPPORTED, true);
//                break;
//            default:
//                System.err.println(
//                        "You did not mentioned the browser name exactly so defualt it is launching firefox. \nIf you mentioned the browser name please follow the rules");
//                System.setProperty("webdriver.gecko.driver", GECKO_WINDOWS);
//                driver = new FirefoxDriver();
//                break;
//        }
//        return driver;
//    }

    public static WebDriver webInstance(String browserName)
    {
      WebDriver driver = null;
      if (browserName.equalsIgnoreCase("firefox"))
      {
        System.out.println("Exectuion Started on ");
        System.setProperty("webdriver.gecko.driver", GECKO_WINDOWS);
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile geoDisabled = new FirefoxProfile();
        profile.getProfile("default");
        geoDisabled.setPreference("geo.enabled", true);
        geoDisabled.setPreference("geo.provider.use_corelocation", true);
        geoDisabled.setPreference("geo.prompt.testing", true);
        geoDisabled.setPreference("geo.prompt.testing.allow", true);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("firefox_profile", geoDisabled);
        geoDisabled.setPreference("geo.wifi.uri", GEO_LOC);
        driver = new FirefoxDriver(capabilities);
      }
      if (browserName.equalsIgnoreCase("IE"))
      {
        System.setProperty("webdriver.ie.driver", I_E);
        driver = new InternetExplorerDriver();
      }
      if (browserName.equalsIgnoreCase("safari"))
      {
        driver = new SafariDriver();
      }
      if (browserName.equalsIgnoreCase("opera"))
      {
        System.setProperty("webdriver.opera.driver", OPERA);
        driver = new OperaDriver();
      }
      if (browserName.equalsIgnoreCase("chrome"))
      {
        System.out.println("Exectuion Started on");
        System.setProperty("webdriver.chrome.driver", CHROME_WINDOWS);
        driver = new ChromeDriver();
      }
      if (browserName.equalsIgnoreCase("phantomjsWin"))
      {
        System.setProperty("phantomjs.binary.path", PHANTOMJS_WIN);
        driver = new PhantomJSDriver();
      }
      browserName.equalsIgnoreCase("mobileEmulation");
      
      return driver;
    }
    
    
    public static WebDriver getmobileDriver()
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", getConfigValue(PLATFORM_NAME));
        caps.setCapability("app", getConfigValue(APP_NAME));
        caps.setCapability("platformVersion", getConfigValue(PLATFORM_VERSION));
        caps.setCapability("deviceName", getConfigValue(DEVICE_NAME));
        caps.setCapability(CapabilityType.BROWSER_NAME, getConfigValue(BROWSE_NAME));
        caps.setCapability(CapabilityType.PLATFORM, PLATFORMEXE);
        return new RemoteWebDriver(getURL(), caps);
    }

    public static URL getURL()
    {
        try
        {
            return new URL(getConfigValue(DEVICE_URL));
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}