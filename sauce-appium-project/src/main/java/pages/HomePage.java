package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;



public class HomePage extends BasePage {

	// XPath for the PRODUCTS header
	private By productsHeaderLocator = By.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]");

	public HomePage(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isProductsHeaderDisplayed() {

		try {
			MobileElement productsHeader = (MobileElement) wait.until(
					ExpectedConditions.visibilityOfElementLocated(productsHeaderLocator)
					);
			return productsHeader.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}

