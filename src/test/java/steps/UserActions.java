package steps;

import activities.AppActivities;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import utils.AppTestBase;

/**
 * created by Andrey Melnichenko at 16:25 06-09-2018
 */

public class UserActions {
    private AppiumDriver driver;
    private AppActivities activities = new AppActivities();

    public UserActions(){
        this.driver = AppTestBase.getDriver();
    }

    @Given("^I entered into \"([^\"]*)\" login \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void enterToApp(String cred, String login, String pass){
        activities.enterToApp(driver, cred, login, pass);
    }

    @When("^I open \"([^\"]*)\" folder$")
    public void enterToFolder(String folderName){
        activities.enterToFolder(driver,folderName);
    }

    @And("^I open \"([^\"]*)\" document$")
    public void openDocumnte(String docName){
        activities.openDocument(driver,docName);
    }

    @And("^Tap on some field and send keys with \"([^\"]*)\"$")
    public void tapOnField(String text){
        activities.tapOnFieldAndSendKeys(driver, text);
    }

    @And("^Tap Done button$")
    public void clickDone(){
        activities.clickDone(driver);
    }

    @And("^Upload and Back to docs list$")
    public void uploadDoc(){
        activities.backToDocumentsList(driver);
        activities.clickOnUpload(driver);
    }

    @And("^Save and Back to docs list$")
    public void saveDoc(){
        activities.backToDocumentsList(driver);
        activities.clickToSave(driver);
    }

    @Then("^I back to main screen$")
    public void amIinFolder(){
        activities.isListOfDocumentsAppeared(driver);
        activities.backToItenList(driver);
    }

    @Given("^User enter into App$")
    public void goToTestFolder(){
        enterToApp("mobox.ua", "admin@mobox.ua", "12341234");
    }

    @And("^User go to \"([^\"]*)\"$")
    public void goToNeedMenuItem(String menuItem){
        activities.goToNeedMenuItem(driver,menuItem);
    }

    @And("^Check entered text$")
    public void checkEnetredText(){
        activities.checkEnteredText(driver);
    }

    @And("^Check Posted document$")
    public void checkPostedDoc(){
        activities.getDocsName(driver);
    }
}
