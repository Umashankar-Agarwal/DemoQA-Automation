package pages.elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static utils.Reusuables.*;

@Log4j2
public class CardAccessPage {

    private final WebDriver driver;

    public CardAccessPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(@href, 'elements')]")
    protected WebElement elementCard;

    public void elementsCard() {
        scrollIntoView(elementCard,driver);
        log.info("Click on Element Card");
        elementCard.click();
    }
}
