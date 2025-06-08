package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

	// Locators
	private By usernameFieldLocator = By.xpath("//android.widget.EditText[@content-desc='test-Username']");
	private By passwordFieldLocator = By.xpath("//android.widget.EditText[@content-desc='test-Password']");
	private By loginButtonLocator = By.xpath("//android.view.ViewGroup[@content-desc='test-LOGIN']");
	private By errorMessageLocator=By.xpath("//android.widget.TextView[@text='Username and password do not match any user in this service.']");


	public LoginPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver = driver;
	}

	public void login(String username, String password) {
		MobileElement usernameField = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(usernameFieldLocator));
		MobileElement passwordField = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFieldLocator));
		MobileElement loginButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));

		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();
	}

	public boolean isErrorMessageVisible() {
		try {
			return driver.findElement(errorMessageLocator).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}

