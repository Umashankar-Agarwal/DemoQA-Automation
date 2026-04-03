package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Reusuables {
    
    public static void scrollIntoView(WebElement element, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scrolls the element into view, aligning it to the top of the viewport (true)
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public static void scrollToBottom(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void hiddenElementClick(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",element);
    }

    public static void scrollTo500(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 500)");
    }

    public static void scrollToTop(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
    }


    public static void waitElementClickable(WebElement element, WebDriver driver,int seconds){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
