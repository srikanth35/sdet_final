package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.TestDataUtil;

public class AddToCartTest extends BaseTest {

	@DataProvider(name = "cartUserData")
	public Object[][] getLoginData() {
		return TestDataUtil.getCartUserData("standard_user","src/test/resources/loginTestData.csv");
	}

	@Test(dataProvider = "cartUserData")
	public void testAddToCart(String username, String password, boolean isValid) {
		ExtentTest test = extent.createTest("Add to cart test- " + username);
		test.info("username is:"+username);
		// Test steps

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		HomePage homePage=new HomePage(driver);
		homePage.addToCartItem();
		Assert.assertTrue(homePage.isProductAddedToCart(), "Product not added to cart" );
		test.pass("Item added to cart successfully");
	}


}
