package listeners;

import base.BaseTest;
import com.aventstack.extentreports.*;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentReportManager;
import utils.Screenshot;

import java.io.IOException;

public class ExtentListeners implements ITestListener {

    private static ExtentReports extent = ExtentReportManager.getReportInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed ");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());

        // Get test class instance
        Object currentClass = result.getInstance();

        // Cast to BaseTest
        WebDriver driver = ((BaseTest) currentClass).getDriver();

        String screenshotPath;
        try {
            screenshotPath = Screenshot.captureScreenshot(driver, result.getMethod().getMethodName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        test.get().addScreenCaptureFromPath(screenshotPath);
    }

    // When Test Skipped
    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("⚠ Test Skipped");
    }

    //  Flush Report After Execution
    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
