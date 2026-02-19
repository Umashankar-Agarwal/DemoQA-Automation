package utils;

import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Screenshot extends BaseTest {
    public static String captureScreenshot(WebDriver driver, String testName) throws IOException {

        String timeStamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy.MM.dd.HH.mm.ss"));

        String screenshotPath = System.getProperty("user.dir")
                + "/reports/screenshots/" + testName + "_" + timeStamp + ".png";

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(screenshotPath);

        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshotPath; // Important for Extent
    }
}
