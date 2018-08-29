package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utils.AppTestBase;
import utils.Waits;

/**
 * created by Andrey Melnichenko at 17:33 28-08-2018
 */

public class AppTest {
    private AppiumDriver driver;

    public AppTest(){
        this.driver = AppTestBase.getDriver();
    }

    @Given("^I am open app$")
    public void runApp(){
        System.out.println("Run App");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("^I watch logo$")
    public void isLogoDisplayed(){
        Assert.assertTrue(Waits.waitForElementPresent(driver,
                By.xpath("//*[@resource-id='de.modern_paper:id/logo']"),
                "Cannot find MDP Logo",
                5).isDisplayed());
    }

    @Then("^I watch Hello message$")
    public void isHelloMessage(){
        Waits.assertElementPresent(driver,
                By.xpath("//*[@resource-id='de.modern_paper:id/modernPaperHerzlicText']"),
                "Hello message not found");
    }

    @Then("^I watch input server credentials field$")
    public void inputForm(){
        Waits.assertElementPresent(driver,
                By.xpath("//*[@resource-id='de.modern_paper:id/editTextServerUri']"),
                "Cannot find input server credentials field");
    }

    @Then("^I watch input field description$")
    public void inputFormDescr(){
        Waits.assertElementPresent(driver,
                By.xpath("//*[@text='Your server credentials']"),
                "Cannot find input field description");
    }

    @Then("^I watch ACTIVATE button$")
    public void activateButton(){
        Waits.assertElementPresent(driver,
                By.xpath("//*[resource-id='de.modern_paper:id/buttonActivateServerUrl']"),
                "Cannot find ACTIVATE button");
    }
}
