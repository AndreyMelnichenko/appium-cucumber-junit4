package steps;

import activities.AppActivities;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import utils.AppTestBase;

/**
 * created by Andrey Melnichenko at 15:20 10-09-2018
 */

public class DataSearch {
    private AppiumDriver driver;
    private AppActivities activities = new AppActivities();

    public DataSearch(){
        this.driver = AppTestBase.getDriver();
    }

    @When("^I am in Data Search item$")
    public void isDataSearchItem(){
        Assert.assertTrue(activities.checkDataSearchItem(driver));
    }

    @And("^I am click on \"([^\"]*)\"$")
    public void iAmClickOn(String item) {
        activities.clickElementByName(driver,item);
    }

    @And("^I am put into fielad \"([^\"]*)\" a search pattern \"([^\"]*)\"$")
    public void iAmPutIntoFieladASearchPattern(String firma, String pattern) {
        //activities.clickElementByName(driver,firma);
        activities.sendKeysToElementByText(driver,firma,pattern);
        activities.clickElementByName(driver,"Search");
    }

    @Then("^I am watch search result by \"([^\"]*)\"$")
    public void iAmWatchSearchResult(String elementName) {
        activities.isOnScreenByElementName(driver,elementName);
    }

    @And("^All found elements should contain \"([^\"]*)\"$")
    public void allFoundElementsShouldContain(String searchedText) {
        activities.isContainedText(driver,searchedText);
    }

    @And("^Click on random doc$")
    public void clickOnRandomDoc() {
        activities.clickOnRandomsearchResult(driver);
    }

    @And("^Click on associated doc$")
    public void clickOnAssociatedDoc() {
        activities.clickOnAssociatedDoc(driver);
    }
}
