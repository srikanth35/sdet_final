package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtility {
    public static void captureScreenshot(WebDriver driver, String fileName) {
        try {
            File screenshotDir = new File("screenshots");
            screenshotDir.mkdirs(); // Create the folder if it doesn't exist

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(screenshotDir, fileName + "_" + timestamp + ".png");

            Files.copy(src.toPath(), dest.toPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
