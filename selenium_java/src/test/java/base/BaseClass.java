package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static String baseUrl;

	@BeforeSuite
	public void setupSuite() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		baseUrl = "https://www.saucedemo.com/";
		System.out.println("Base URL initialized: " + baseUrl);
	}

	@AfterSuite
	public void tearDownSuite() {
		if (driver != null) {
			driver.quit();
		}
	}
}
