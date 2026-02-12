package base;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Log4j2
public class BaseTest  {

    protected WebDriver driver;
    @Parameters({"url"})
    @BeforeMethod
    public void setup(String url) {

        driver = new ChromeDriver();
        log.info("Initiating the browser instance");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        log.info("Navigating to the {} URL: ", url);
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
