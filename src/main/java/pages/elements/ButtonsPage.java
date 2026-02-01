package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Consonants;
import utils.Reusuables;

public class ButtonsPage extends CardAccessPage {


    public final WebDriver driver;

    public ButtonsPage(WebDriver driver) {
        this.driver = driver;
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = Consonants.elementList + "//li[@id='item-4']")
    WebElement buttonElement;
    @FindBy(id = "doubleClickBtn")
    WebElement doubleClickButton;
    @FindBy(id = "rightClickBtn")
    WebElement rightClickButton;
    @FindBy(xpath = "//button[text() = 'Click Me']")
    WebElement clickMeButton;
    @FindBy(id = "doubleClickMessage")
    WebElement doubleClickMessage;
    @FindBy(id = "rightClickMessage")
    WebElement rightClickMessage;
    @FindBy(id = "dynamicClickMessage")
    WebElement dynamicClickMessage;

    public void buttonSetup() {
        elementsCard();
        buttonElement.click();
        Reusuables.scrollIntoView(buttonElement, driver);
    }

    public void buttonActions() {
        Actions buttonAction = new Actions(driver);
        buttonAction.doubleClick(doubleClickButton).perform();
        System.out.println(doubleClickMessage.getText());
        buttonAction.contextClick(rightClickButton).perform();
        System.out.println(rightClickMessage.getText());
        Reusuables.hiddenElementClick(driver, clickMeButton);
        System.out.println(dynamicClickMessage.getText());
    }
}
