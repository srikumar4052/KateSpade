
package com.ch.utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ch.ExcelUtils.ExcelBean;
import com.google.common.base.Function;

public class SeleniumHelperUtils
{

    public static List<WebElement> fluentTagElement(final String name, String message)
    {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getDriver()).withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS).ignoring(StaleElementReferenceException.class)
                .withMessage("Unable to locate element: " + message);
        List<WebElement> element = wait.until(new Function<WebDriver, List<WebElement>>()
        {
            public List<WebElement> apply(WebDriver driver)
            {
                return driver.findElements(By.tagName(name));
            }
        });
        return element;
    };

    public static WebElement fluentwaitElement(final By locator, String message)
    {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getDriver()).withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
                .withMessage("Unable to locate element: " + message);
        WebElement element = wait.until(new Function<WebDriver, WebElement>()
        {
            public WebElement apply(WebDriver driver)
            {
                return driver.findElement(locator);
            }
        });
        return element;
    };

    public static WebElement elements(Type type, String element, WebDriverWait wait)
    {
        WebElement element1 = null;
        if (type.equals(Type.CSSSELECTOR))
        {
            element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element)));
        } else if (type.equals(Type.CLASSNAME))
        {
            element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(element)));
        } else if (type.equals(Type.ID))
        {
            element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
        } else if (type.equals(Type.LINKTEXT))
        {
            element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(element)));
        } else if (type.equals(Type.NAME))
        {
            element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(element)));
        } else if (type.equals(Type.PARTIALLINK))
        {
            element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(element)));
        } else if (type.equals(Type.XPATH))
        {
            element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
        }
        return element1;
    }

    public static WebElement elements(ExcelBean bean, WebDriverWait wait)
    {
        String type = bean.getType();
        String element = bean.getValue();
        WebElement element1 = null;
        if (type.equals(Type.CSSSELECTOR.name()))
        {
            element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element)));
        } else if (type.equals(Type.CLASSNAME.name()))
        {
            element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(element)));
        } else if (type.equals(Type.ID.name()))
        {
            element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
        } else if (type.equals(Type.LINKTEXT.name()))
        {
            element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(element)));
        } else if (type.equals(Type.NAME.name()))
        {
            element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(element)));
        } else if (type.equals(Type.PARTIALLINK.name()))
        {
            element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(element)));
        } else if (type.equals(Type.XPATH.name()))
        {
            element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
        }
        return element1;
    }

    public static List<WebElement> getAllElements(Type type, String element)
    {
        List<WebElement> ele = null;
        if (type.equals(Type.CLASSNAME))
        {
            ele = DriverFactory.getDriver().findElements(By.className(element));
        } else if (type.equals(Type.CSSSELECTOR))
        {
            ele = DriverFactory.getDriver().findElements(By.cssSelector(element));
        } else if (type.equals(Type.LINKTEXT))
        {
            ele = DriverFactory.getDriver().findElements(By.linkText(element));
        } else if (type.equals(Type.XPATH))
        {
            ele = DriverFactory.getDriver().findElements(By.xpath(element));
        } else if (type.equals(Type.ID))
        {
            ele = DriverFactory.getDriver().findElements(By.id(element));
        } else if (type.equals(Type.PARTIALLINK))
        {
            ele = DriverFactory.getDriver().findElements(By.partialLinkText(element));
        } else if (type.equals(Type.NAME))
        {
            ele = DriverFactory.getDriver().findElements(By.name(element));
        }
        return ele;
    }

    public static List<WebElement> getAllElements(ExcelBean bean)
    {
        String type = bean.getType();
        String element = bean.getValue();
        List<WebElement> ele = null;
        if (type.equals(Type.CLASSNAME.name()))
        {
            ele = DriverFactory.getDriver().findElements(By.className(element));
        } else if (type.equals(Type.CSSSELECTOR.name()))
        {
            ele = DriverFactory.getDriver().findElements(By.cssSelector(element));
        } else if (type.equals(Type.LINKTEXT.name()))
        {
            ele = DriverFactory.getDriver().findElements(By.linkText(element));
        } else if (type.equals(Type.XPATH.name()))
        {
            ele = DriverFactory.getDriver().findElements(By.xpath(element));
        } else if (type.equals(Type.ID.name()))
        {
            ele = DriverFactory.getDriver().findElements(By.id(element));
        } else if (type.equals(Type.PARTIALLINK.name()))
        {
            ele = DriverFactory.getDriver().findElements(By.partialLinkText(element));
        } else if (type.equals(Type.NAME.name()))
        {
            ele = DriverFactory.getDriver().findElements(By.name(element));
        }
        return ele;
    }

    public static WebElement fluentWaitElements(Type type, String element)
    {
        WebElement element1 = null;
        if (type.equals(Type.CSSSELECTOR))
        {
            element1 = fluentwaitElement(By.className(element), type + " ==== " + element);
        } else if (type.equals(Type.CLASSNAME))
        {
            element1 = fluentwaitElement(By.className(element), type + " ==== " + element);
        } else if (type.equals(Type.ID))
        {
            element1 = fluentwaitElement(By.id(element), type + " ==== " + element);
        } else if (type.equals(Type.LINKTEXT))
        {
            element1 = fluentwaitElement(By.linkText(element), type + " ==== " + element);
        } else if (type.equals(Type.NAME))
        {
            element1 = fluentwaitElement(By.name(element), type + " ==== " + element);
        } else if (type.equals(Type.PARTIALLINK))
        {
            element1 = fluentwaitElement(By.partialLinkText(element), type + " ==== " + element);
        } else if (type.equals(Type.XPATH))
        {
            element1 = fluentwaitElement(By.xpath(element), type + " ==== " + element);
        }
        return element1;
    }

    public static WebElement fluentWaitElements(ExcelBean bean)
    {
        String type = bean.getType();
        String element = bean.getValue();
        WebElement element1 = null;
        if (type.equals(Type.CSSSELECTOR.name()))
        {
            element1 = fluentwaitElement(By.cssSelector(element), type + " ==== " + element);
        } else if (type.equals(Type.CLASSNAME.name()))
        {
            element1 = fluentwaitElement(By.className(element), type + " ==== " + element);
        } else if (type.equals(Type.ID.name()))
        {
            element1 = fluentwaitElement(By.id(element), type + " ==== " + element);
        } else if (type.equals(Type.LINKTEXT.name()))
        {
            element1 = fluentwaitElement(By.linkText(element), type + " ==== " + element);
        } else if (type.equals(Type.NAME.name()))
        {
            element1 = fluentwaitElement(By.name(element), type + " ==== " + element);
        } else if (type.equals(Type.PARTIALLINK.name()))
        {
            element1 = fluentwaitElement(By.partialLinkText(element), type + " ==== " + element);
        } else if (type.equals(Type.XPATH.name()))
        {
            element1 = fluentwaitElement(By.xpath(element), type + " ==== " + element);
        }
        return element1;
    }

    public static Select fluentElementDropDown(Type type, String element)
    {
        Select sel = null;
        if (type.equals(Type.CLASSNAME))
        {
            sel = new Select(fluentwaitElement(By.className(element), element));
        } else if (type.equals(Type.CSSSELECTOR))
        {
            sel = new Select(fluentwaitElement(By.cssSelector(element), element));
        } else if (type.equals(Type.LINKTEXT))
        {
            sel = new Select(fluentwaitElement(By.linkText(element), element));
        } else if (type.equals(Type.PARTIALLINK))
        {
            sel = new Select(fluentwaitElement(By.partialLinkText(element), element));
        } else if (type.equals(Type.NAME))
        {
            sel = new Select(fluentwaitElement(By.name(element), element));
        } else if (type.equals(Type.ID))
        {
            sel = new Select(fluentwaitElement(By.id(element), element));
        } else if (type.equals(Type.XPATH))
        {
            sel = new Select(fluentwaitElement(By.xpath(element), element));
        }
        return sel;
    }

    public static Select fluentElementDropDown(ExcelBean bean)
    {
        String type = bean.getType();
        String element = bean.getValue();
        Select sel = null;
        if (type.equals(Type.CLASSNAME.name()))
        {
            sel = new Select(fluentwaitElement(By.className(element), element));
        } else if (type.equals(Type.CSSSELECTOR.name()))
        {
            sel = new Select(fluentwaitElement(By.cssSelector(element), element));
        } else if (type.equals(Type.LINKTEXT.name()))
        {
            sel = new Select(fluentwaitElement(By.linkText(element), element));
        } else if (type.equals(Type.PARTIALLINK.name()))
        {
            sel = new Select(fluentwaitElement(By.partialLinkText(element), element));
        } else if (type.equals(Type.NAME.name()))
        {
            sel = new Select(fluentwaitElement(By.name(element), element));
        } else if (type.equals(Type.ID.name()))
        {
            sel = new Select(fluentwaitElement(By.id(element), element));
        } else if (type.equals(Type.XPATH.name()))
        {
            sel = new Select(fluentwaitElement(By.xpath(element), element));
        }
        return sel;
    }

    public static List<WebElement> fluentwaitElements(WebDriver driver, final By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        List<WebElement> ele = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        return ele;
    }
}
