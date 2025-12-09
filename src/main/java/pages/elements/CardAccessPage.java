package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CardAccessPage {

    public CardAccessPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class = 'category-cards']/div[1]")
    protected WebElement elementCard;

    public void elementsCard() {
        elementCard.click();
    }
}
