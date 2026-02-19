package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getReportInstance() {

        if (extent == null) {

            String timeStamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy.MM.dd.HH.mm.ss"));

            String path = System.getProperty("user.dir")
                    + "/reports/ExtentReport_" + timeStamp + ".html";


            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
            sparkReporter.config().setDocumentTitle("Demo QA : Automation Project E2E"); // Title of report
            sparkReporter.config().setReportName("Functional Testing"); // name of the report
            sparkReporter.config().setTheme(Theme.DARK);

            extent = new ExtentReports();
            // This will map the required details to be added on the report
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Website", "Demo : QA ");
            extent.setSystemInfo("Tester Name", "Uma Shankar Agarwal");
            extent.setSystemInfo("os", "Windows11");
            extent.setSystemInfo("Browser name", "Chrome");
        }

        return extent;
    }
}