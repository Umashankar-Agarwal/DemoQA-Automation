package utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestListeners implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        // Assume 'driver' is accessible from your base test class
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("WebDriver");
        try {
            Screenshot.ScreenshotUtils.capture(driver, result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

