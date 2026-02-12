package utils;

import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class ExtentReportManager extends BaseTest implements ITestListener {
    public ExtentSparkReporter sparkReporter; // UI of the report
    public ExtentReports extent; //populate common info on the report
    public ExtentTest test; // creating test case entries in the report and update status of the test methods

    public void onStart(ITestContext context) {

        // UI of the Report
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/myReport.html");//speci
        sparkReporter.config().setDocumentTitle("Demo QA : Automation Project E2E"); // Title of report
        sparkReporter.config().setReportName("Functional Testing"); // name of the report
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Website", "Demo : QA ");
        extent.setSystemInfo("Tester Name", "Uma Shankar Agarwal");
        extent.setSystemInfo("os", "Windows11");
        extent.setSystemInfo("Browser name", "Chrome");
    }

    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getName()); //create the entry in the report
        test.log(Status.PASS, "Test Case Passed is :" + result.getName());  // update the status
    }

    public void onTestFailure(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE){
            String screenShotPath = null;
            try {
                screenShotPath = Screenshot.captureScreenshot(driver, result.getName());
            } catch (IOException e) {
                throw new RuntimeException("Screenshot was not captured");
            }
            test.fail("Test Case Failed: " + result.getName());
            test.fail(result.getThrowable());
            test.addScreenCaptureFromPath(screenShotPath);
        }
    }

    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName()); //create the entry in the report
        test.log(Status.SKIP, "Test Case skipped is :" + result.getName());  // update the status
    }

    public void onFinish(ITestContext context) {
        extent.flush();

    }
}

