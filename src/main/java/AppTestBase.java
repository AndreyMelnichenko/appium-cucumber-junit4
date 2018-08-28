import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

/**
 * created by Andrey Melnichenko at 17:20 28-08-2018
 */

public class AppTestBase {

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","androidTestDevice");
        capabilities.setCapability("platformVersion","5.1");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","de.modern_paper");
        capabilities.setCapability("appActivity",".ui.activity.ActivationActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
