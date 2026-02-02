package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseTest  {

    protected WebDriver driver;
    //LogManager used
    private static final Logger log = LogManager.getLogger(BaseTest.class);
    @Parameters({"url"})
    @BeforeMethod
    public void setup(String url) {

        driver = new ChromeDriver();
        log.info("Initiating the browser instance");
        driver.manage().window().maximize();
        log.info("Navigating to the {} URL: ", url);
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
