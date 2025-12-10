package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class reusuables {


    public static void scrollIntoView(WebElement element, WebDriver driver) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scrolls the element into view, aligning it to the top of the viewport (true)
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public static void scrollToBottom(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void elementClickable(WebElement element, WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

}
