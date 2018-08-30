package Api;

import Response.RegKeyRS;
import core.ApiTestBase;
import io.qameta.allure.Epic;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/**
 * created by Andrey Melnichenko at 11:03 28-08-2018
 */

@Epic("API tests")
public class ApiTest extends ApiTestBase {
    private String url = "https://goto.my-mobile.services/license/appreg.php?key=";

    @Test
    public void getAppKey(){
        String key = "mobox.ua";
        RegKeyRS appKey = getResource(url+key,200,RegKeyRS.class);
        Assert.assertEquals(key,appKey.getRegkey());
        Assert.assertEquals("https://goto.my-mobile.services/ProcessCoach/app/",appKey.getServer());
    }


}