package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * created by Andrey Melnichenko at 14:23 29-08-2018
 */

public class Waits {

    public static WebElement waitForElementPresent(AppiumDriver driver, By by, String errMessage, int timeOut){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.withMessage("\n\n\n"+errMessage+"\n\n\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void assertElementPresent(AppiumDriver driver, By by, String errorMessage){
        if(!driver.findElement(by).isDisplayed()){
            String message = "An elements ["+by.toString()+"] not present";
            throw new AssertionError(message+" "+errorMessage);
        }
    }
}
