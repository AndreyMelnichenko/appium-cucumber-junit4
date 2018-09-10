package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * created by Andrey Melnichenko at 14:23 29-08-2018
 */

public class Waits {

    public static WebElement waitForElementPresent(AppiumDriver driver, By by, String errMessage, int timeOut){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.withMessage("\n\n\n"+errMessage+"\n\n\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static boolean waitForElementNotPresent(AppiumDriver driver, By by, String errMessage, int timeOut){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.withMessage("\n\n\n"+errMessage+"\n\n\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public static void assertElementPresent(AppiumDriver driver, By by, String errorMessage){
        if(!driver.findElement(by).isDisplayed()){
            String message = "An elements ["+by.toString()+"] not present";
            throw new AssertionError(message+" "+errorMessage);
        }
    }

    public static WebElement waitForElementAndClick(AppiumDriver driver, By by, String errMessage, int timeOut){
        WebElement element = waitForElementPresent(driver,by,errMessage,timeOut);
        element.click();
        return element;
    }

    public static WebElement waitForElementAndSendKeys(AppiumDriver driver, By by, String value, String errMessage, int timeOut){
        WebElement element = waitForElementPresent(driver,by,errMessage,timeOut);
        element.clear();
        element.sendKeys(value);
        return element;
    }
    public static boolean waitForElementAndCheckText(AppiumDriver driver, By by, String errMessage, int timeOut, String expectedText){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.withMessage("\n\n\n"+errMessage+"\n\n\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by)).getAttribute("text").equals(expectedText);
    }

    public static List<WebElement> waitForWebElementCollectionPresent(AppiumDriver driver, By by, int timeOut){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.withMessage("\n\n\n Element Collection not found \n\n\n");
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
}
