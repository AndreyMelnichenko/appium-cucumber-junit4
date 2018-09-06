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

    @Then("^I open \"([^\"]*)\" document$")
    public void openDocumnte(String docName){
        activities.openDocument(driver,docName);
    }

    @And("^Tap on some field$")
    public void tapOnField(){
        activities.tapOnField(driver);
    }
}
