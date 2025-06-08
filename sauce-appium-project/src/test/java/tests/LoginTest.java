package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;
import utils.TestDataUtil;

@Listeners(utils.ExtentTestNGListener.class)
public class LoginTest extends BaseTest {

	@DataProvider(name = "loginData")
	public Object[][] getLoginData() {
		return TestDataUtil.getAllUserData("src/test/resources/loginTestData.csv");
	}

	@Test(dataProvider = "loginData")
	public void testLogin(String username, String password, boolean isValid) {

		
		ExtentTest test = extent.createTest("Login Test - " + username, "Testing login with username: " + username);
		test.info("username is:"+username);
	    // Test steps
	  
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		if (isValid) {
			HomePage homePage = new HomePage(driver);
			Assert.assertTrue(homePage.isProductsHeaderDisplayed(), "Login failed for: " + username);
			  test.pass("Login successful for user: " + username);

			LogoutPage logoutPage=new LogoutPage(driver);
			logoutPage.logout();}
		else {
			Assert.assertTrue(loginPage.isErrorMessageVisible(), "Error message not shown for invalid login");
		}}
}