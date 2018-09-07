package activities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Waits;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static utils.StringReformate.cutString;

/**
 * created by Andrey Melnichenko at 10:31 06-09-2018
 */

public class AppActivities {
    private static String enteredText;

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

    public void tapOnFieldAndSendKeys(AppiumDriver driver, String text){
        Waits.waitForElementPresent(driver,
                By.xpath("//*[@resource-id='de.modern_paper:id/read_docview_ly']"),
                "Cannot find document",
                15);
        int x = 685;
        int y = 290;
        TouchAction action = new TouchAction(driver);
        action.press(x,y).release().perform();
        enteredText=text+new SimpleDateFormat("_dd_MM_yy_HH_mm").format(Calendar.getInstance().getTime());
        Waits.waitForElementAndSendKeys(driver,
                By.className("android.widget.EditText"),
                enteredText,
                "Cannot find text area",
                15);
    }

    public void clickDone(AppiumDriver driver){
        Waits.waitForElementAndClick(driver,
                By.xpath("//*[@resource-id='de.modern_paper:id/rv_form_finish'][1]"),
                "Cannot find BACK button",
                5);
    }

    public void backToDocumentsList(AppiumDriver driver){
        List<WebElement> buttonList = Waits.waitForWebElementCollectionPresent(driver,
                By.xpath("//*[@resource-id='de.modern_paper:id/read_top_bar_ly']/*[@class='android.widget.LinearLayout']/*[@class='android.widget.RelativeLayout']/*[@class='android.widget.LinearLayout']/*[@class='android.widget.LinearLayout']/*[@class='android.widget.ImageView']"),
                5);
        //System.out.println(buttonList.size());
        buttonList.get(0).click();
    }

    public void clickToSave(AppiumDriver driver){
        Waits.waitForElementAndClick(driver,
                By.xpath("//*[@text='Save']"),
                "Cannot find a SAVE button",
                5);
    }

    public void clickOnUpload(AppiumDriver driver){
        Waits.waitForElementAndClick(driver,
                By.xpath("//*[@text='Upload']"),
                "Cannot find a Upload button",
                5);
    }

    public void isListOfDocumentsAppeared(AppiumDriver driver){
        Waits.assertElementPresent(driver,
                By.xpath("//*[@resource-id='de.modern_paper:id/folderNameTxt']"),
                "Cannot find documents list in folder");
    }

    public void backToItenList(AppiumDriver driver){
        Waits.waitForElementAndClick(driver,
                By.xpath("//*[@resource-id='de.modern_paper:id/toolbarDocuments']/*[@class='android.widget.ImageButton']"),
                "Cannot find BACK button", 5);
    }

    public void goToNeedMenuItem(AppiumDriver driver, String menuItem){
        Waits.waitForElementAndClick(driver,
                By.xpath("//*[@text='"+menuItem+"']"),
                "Cannot find drafts item",
                5);
    }

    public void getDocsName(AppiumDriver driver){
        List<WebElement> allDocs = Waits.waitForWebElementCollectionPresent(driver,
                By.xpath("//*[@resource-id='de.modern_paper:id/postedDocumentName']"),10);
        List<String> allNames = new ArrayList<>();
        System.out.println(enteredText);
        allDocs.forEach(a-> System.out.println("["+a.getAttribute("text")+"]"));
        allDocs.forEach(a->{
                    if(a.getAttribute("text").contains(enteredText)){
                        allNames.add(a.getAttribute("text"));
                    }
                });
        Assert.assertTrue(allNames.size()>0);
    }

    public void checkEnteredText(AppiumDriver driver){
        String text = Waits.waitForElementPresent(driver,
                By.xpath("//*[@resource-id='de.modern_paper:id/documentInWorkDraftFields']"),
                "Cannot find entered text",5).getAttribute("text");
        Assert.assertEquals(enteredText.trim(),text.trim().replace(",",""));
    }
}
