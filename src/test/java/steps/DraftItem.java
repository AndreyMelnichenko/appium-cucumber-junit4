package steps;

import activities.AppActivities;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.appium.java_client.AppiumDriver;
import utils.AppTestBase;
import utils.Waits;

/**
 * created by Andrey Melnichenko at 16:54 12-09-2018
 */

public class DraftItem {
    private AppiumDriver driver;
    AppActivities activities = new AppActivities();

    public DraftItem(){
        this.driver = AppTestBase.getDriver();
    }

    @Then("^Stop test$")
    public void stopTest(){
        Waits.sleepTest(5);
    }

    @And("^Click on Delete button$")
    public void clickOnDeleteButton() {
        activities.clickOnDeleteFromDraft(driver);
    }

    @And("^Confirm Delete$")
    public void confirmDelete() {
        activities.confirmDelete(driver);
    }
}
