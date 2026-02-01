package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {

    public class ScreenshotUtils {
        public static String capture(WebDriver driver, String name) throws IOException {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = System.getProperty("user.dir") + "/Screenshots/" + name + ".png";
            FileUtils.copyFile(scrFile, new File(path));
            return path;
        }
    }
}
