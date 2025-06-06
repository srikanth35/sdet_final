package tests;

import base.BaseClass;
//import utils.ConfigurationReader;
import utils.ScreenshotUtility;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SauceDemoTest extends BaseClass {

    @Test(priority = 1)
    public void verifyTitle() {
        driver.get("https://www.saucedemo.com/");
        Assert.assertEquals(driver.getTitle(), "Swag Labs", "Title does not match");
    }

    @Test(priority = 2)
    @Parameters({"validUsername", "validPassword"})
    public void positiveLoginTest(String username, String password) {
        driver.get(baseUrl);
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "Login failed!");
        Assert.assertTrue(driver.getTitle().equals("Swag Labs"));
        ScreenshotUtility.captureScreenshot(driver, "positiveLogin");
    }

    @Test(priority = 3)
    @Parameters({"invalidUsername", "invalidPassword"})
    public void negativeLoginTest(String username, String password) {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        boolean errorVisible = driver.findElement(By.cssSelector("[data-test='error']")).isDisplayed();
        Assert.assertTrue(errorVisible, "Error message not displayed");
        Assert.assertTrue(driver.getTitle().equals("Swag Labs"));
        ScreenshotUtility.captureScreenshot(driver, "negativeLogin");
    }
}
