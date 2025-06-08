package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class LogoutPage extends BasePage {

	public LogoutPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver = driver;
	}

	// Wait for and click on the menu button


	private MobileElement testMenu = driver.findElement(MobileBy.AccessibilityId("test-Menu"));
	By logoutButton = MobileBy.AndroidUIAutomator("new UiSelector().text(\"LOGOUT\")");

	public void logout() {

		wait.until(ExpectedConditions.elementToBeClickable(testMenu)).click();


		// Wait for and click on Logout
		wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();

	}
}
