package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;



public class HomePage extends BasePage {

	// XPath for the PRODUCTS header
	private By productsHeaderLocator = By.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]");
	private By addToCartLocator=MobileBy.AndroidUIAutomator("new UiSelector().text(\"ADD TO CART\").instance(0)");
	private By cartLocator=MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(3)");
	private By itemAddedLocator = By.xpath("//android.widget.TextView[@text=\"Sauce Labs Backpack\"]");

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

	public void addToCartItem() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartLocator)).click();
	}

	public boolean isProductAddedToCart() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(cartLocator)).click();
		try {
			MobileElement itemLocator = (MobileElement) wait.until(
					ExpectedConditions.visibilityOfElementLocated(itemAddedLocator)
					);
			return itemLocator.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}

