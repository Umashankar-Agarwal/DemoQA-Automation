package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.reusuables.scrollIntoView;

public class CardAccessPage {

    private final WebDriver driver;

    public CardAccessPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class = 'category-cards']/div[1]")
    protected WebElement elementCard;

    public void elementsCard() {
        scrollIntoView(elementCard,driver);
        elementCard.click();
    }
}
