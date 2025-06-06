package utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    @SuppressWarnings("deprecation")
	public static AndroidDriver<MobileElement> getDriver() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        caps.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/apps/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
//        caps.setCapability(MobileCapabilityType.AP, "UiAutomator2");
        caps.setCapability("appium:appPackage", "com.swaglabsmobileapp");
        caps.setCapability("appium:appActivity", "com.swaglabsmobileapp.MainActivity");

        try {
            return new AndroidDriver<>(new URL("http://127.0.0.1:4723"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}