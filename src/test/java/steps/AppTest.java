package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        System.out.println("======Run App======");
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
        WebElement element = Waits.waitForElementPresent(driver,
                By.className("android.widget.Button"),
                "Cannot find input field description",
                5);
        Assert.assertEquals(element.getAttribute("text"), "Activate");
    }

    //----------------------------------------------------------------------------------------------

    @Then("^I clear input field$")
    public void clearInputField() {
        Waits.waitForElementAndSendKeys(driver,
                By.xpath("//*[@resource-id='de.modern_paper:id/editTextServerUri']"),
                "",
                "Cannot find input server credentials field",
                5);
    }

    @Then(("^I click to ACTIVATE button$"))
    public void clickToActivate(){
        Waits.waitForElementAndClick(driver,
                By.className("android.widget.Button"),
                "Cannot find ACTIVATE button",
                5);
    }

    @And("^Watch error message$")
    public void watchErrorMessage() {
        WebElement element = Waits.waitForElementPresent(driver,
                By.xpath("//*[@text='Server uri cannot be empty']"),
                "Cannot find error message",
                5);
        Assert.assertEquals(element.getAttribute("text"),"Server uri cannot be empty");
    }

    @And("^I try enter with \"([^\"]*)\"$")
    public void enterWithBadCredentials(String cred) {
        Waits.waitForElementAndSendKeys(driver,
                By.xpath("//*[@resource-id='de.modern_paper:id/editTextServerUri']"),
                cred,
                "Cannot find input server credentials field",
                5);
    }

    @And("^I watch error pop-up$")
    public void errorPopUp(){
        WebElement element = Waits.waitForElementPresent(driver,
                By.xpath("//*[@resource-id='de.modern_paper:id/errorHeaderText']"),
                "Cannot find error message 1",
                5);
        WebElement element2 = Waits.waitForElementPresent(driver,
                By.xpath("//*[@resource-id='de.modern_paper:id/errorDescriptionText']"),
                "Cannot find error message 2",
                5);
        Assert.assertEquals(element.getAttribute("text"),"not valid key");
        Assert.assertEquals(element2.getAttribute("text"),"This activation key ist not valid");
    }

    //----------------------------------------------------------------------------------------------

    @When("^I fill credentials field with \"([^\"]*)\"$")
    public void fillCredentials(String cred) throws Throwable{
        Waits.waitForElementAndSendKeys(driver,
                By.xpath("//*[@resource-id='de.modern_paper:id/editTextServerUri']"),
                cred,
                "Cannot find input server credentials field",
                5);
    }

    @Given("^I am watch second screen$")
    public void iAmWatchSecondScreen() {
        Waits.assertElementPresent(driver,
                By.xpath("//*[@resource-id='de.modern_paper:id/logo']"),
                "Cannot find LOGO");
    }

    @And("^CheckBox click$")
    public void checkboxCkick() {
        Waits.waitForElementAndClick(driver,
                By.xpath("//*[@resource-id='de.modern_paper:id/multyDownloadCheckBox']"),
                "Cannot find check box",
        5);
    }

    @And("^Try to enter with empty fields$")
    public void emptyLogPassEnter(){
        Waits.waitForElementPresent(driver,
                By.xpath("//*[@resource-id='de.modern_paper:id/editTextUser']"),
                "Cannot find login field",
                5).clear();
        clearPasswordField();
        clickLogin();
    }
    @And("^Watch error message as \"([^\"]*)\"$")
    public void emptyUserNameError(String textError){
        String actuelErrorText = Waits.waitForElementPresent(driver,
                By.xpath("//*[@resource-id='de.modern_paper:id/textinput_error']"),
                "Cannot find error message",
                5).getAttribute("text");
        Assert.assertEquals("Error mesages not equals", textError, actuelErrorText);
    }

    @When("^I go to second screen with \"([^\"]*)\"$")
    public void goToSeconScreen(String cred) throws Throwable {
        fillCredentials(cred);
        clickToActivate();
    }

    @And("^I fill login \"([^\"]*)\"$")
    public void fillLogin(String login){
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

    @Then("^I click to LOGIN button$")
    public void clickLogin(){
        Waits.waitForElementAndClick(driver,
                By.xpath("//*[@resource-id='de.modern_paper:id/buttonLogin']"),
                "Cannot find/click on button",
                5);
    }

    @And("^I clear password field$")
    public void clearPasswordField(){
        Waits.waitForElementPresent(driver,
                By.xpath("//*[@resource-id='de.modern_paper:id/editTextPassword']"),
                "Cannot find password field",
                5).clear();
    }
}
