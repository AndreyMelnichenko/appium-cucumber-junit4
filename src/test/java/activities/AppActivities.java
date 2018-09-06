package activities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Waits;

import java.util.List;

/**
 * created by Andrey Melnichenko at 10:31 06-09-2018
 */

public class AppActivities {

    public void isFirstLogoDisplayed(AppiumDriver driver){
        Waits.assertElementPresent(driver,
                                By.xpath("//*[@resource-id='de.modern_paper:id/logo']"),
                                "Cannot find MDP Logo");
    }

    public void isHelloMessage(AppiumDriver driver){
        Waits.assertElementPresent(driver,
                By.xpath("//*[@resource-id='de.modern_paper:id/modernPaperHerzlicText']"),
                "Hello message not found");
        Waits.waitForElementAndCheckText(driver,
                By.xpath("//*[@resource-id='de.modern_paper:id/modernPaperHerzlicText']"),
                "Hello message not found",
                5,
                "ProcessCoach 4 Welcome!");
    }

    public void isInputServerKey(AppiumDriver driver){
        Waits.assertElementPresent(driver,
                By.xpath("//*[@resource-id='de.modern_paper:id/editTextServerUri']"),
                "Cannot find input server credentials field");
    }

    public void enterLoginAndPassword(AppiumDriver driver, String login){
        Waits.waitForElementPresent(driver,
                By.xpath("//*[@resource-id='de.modern_paper:id/editTextUser']"),
                "Cannot find login field",
                5).clear();
        Waits.waitForElementAndSendKeys(driver,
                By.xpath("//*[@resource-id='de.modern_paper:id/editTextUser']"),
                login,
                "Cannot find login field",
                5);
    }

    public void enterLoginAndPassword(AppiumDriver driver, String login, String pasword){
        enterLoginAndPassword(driver,login);
        Waits.waitForElementAndSendKeys(driver,
                By.xpath("//*[@resource-id='de.modern_paper:id/editTextPassword']"),
                pasword,
                "Cannot find password field",
                5);
    }

    public List<WebElement> waitForWebElementCollectionPresent(AppiumDriver driver, By by, int timeOut){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.withMessage("\n\n\n Element Collection not found \n\n\n");
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void enterToApp(AppiumDriver driver, String cred, String login, String pass){
        Waits.waitForElementAndSendKeys(driver,
                By.xpath("//*[@resource-id='de.modern_paper:id/editTextServerUri']"),
                cred,
                "Cannot find input server credentials field",
                5);
        Waits.waitForElementAndClick(driver,
                By.className("android.widget.Button"),
                "Cannot find ACTIVATE button",
                5);
        enterLoginAndPassword(driver,login, pass);
        Waits.waitForElementAndClick(driver,
                By.xpath("//*[@resource-id='de.modern_paper:id/multyDownloadCheckBox']"),
                "Cannot find check box",
                5);
        Waits.waitForElementAndClick(driver,
                By.xpath("//*[@resource-id='de.modern_paper:id/buttonLogin']"),
                "Cannot find/click on button",
                5);
    }

    public void enterToFolder(AppiumDriver driver, String folderName){
        Waits.waitForElementAndClick(driver,
                By.xpath("//*[@text='"+folderName+"']"),
                "Cannot find folder "+folderName,
                15);
    }

    public void openDocument(AppiumDriver driver, String docName){
        Waits.waitForElementAndClick(driver,
                By.xpath("//*[@text='"+docName+"']"),
                "Cannot find folder "+docName,
                15);
    }

    public void tapOnField(AppiumDriver driver){
        Waits.waitForElementPresent(driver,
                By.xpath("//*[@resource-id='de.modern_paper:id/read_docview_ly']"),
                "Cannot find document",
                15);
        int x = 685;
        int y = 290;
        TouchAction action = new TouchAction(driver);
        action.press(x,y).release().perform();
        Waits.waitForElementAndSendKeys(driver,
                By.className("android.widget.EditText"),
                "Test text by Andrey",
                "Cannot find text area",
                15);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}