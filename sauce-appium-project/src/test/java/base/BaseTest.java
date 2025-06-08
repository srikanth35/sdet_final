package base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.*;
import utils.DriverManager;

public class BaseTest {
    protected AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setup() {
        driver = DriverManager.getDriver();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {  driver.quit();}
    }
}
