// BasePage.java
package pages;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BasePage {
    protected AppiumDriver<MobileElement> driver;
    protected WebDriverWait wait;
    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
    }
}