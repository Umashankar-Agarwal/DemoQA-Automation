package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class reusuables {


    public static void scrollIntoView(WebElement element, WebDriver driver){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scrolls the element into view, aligning it to the top of the viewport (true)
        js.executeScript("arguments[0].scrollIntoView(true)",element);



    }
}
