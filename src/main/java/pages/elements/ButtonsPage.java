package pages.elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Consonants;
import utils.Reusuables;

@Log4j2
public class ButtonsPage extends CardAccessPage {

    public final WebDriver driver;

    public ButtonsPage(WebDriver driver) {
        this.driver = driver;
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/buttons']")
    WebElement buttonElement;
    @FindBy(css = "#doubleClickBtn")
    WebElement doubleClickButton;
    @FindBy(css = "#rightClickBtn")
    WebElement rightClickButton;
    @FindBy(xpath = "//button[text() = 'Click Me']")
    WebElement clickMeButton;
    @FindBy(css = "#doubleClickMessage")
    WebElement doubleClickMessage;
    @FindBy(css = "#rightClickMessage")
    WebElement rightClickMessage;
    @FindBy(css = "#dynamicClickMessage")
    WebElement dynamicClickMessage;

    public void buttonSetup() {
        elementsCard();
        Reusuables.waitElementClickable(buttonElement,driver,5);
        log.info("Click on button element");
        buttonElement.click();
        Reusuables.scrollIntoView(buttonElement, driver);
    }

    public void buttonActions() {
        Actions buttonAction = new Actions(driver);
        log.info("Testing the Double Click button");
        buttonAction.doubleClick(doubleClickButton).build().perform();
        System.out.println(doubleClickMessage.getText());
        log.info("Testing the Right Click button");
        buttonAction.contextClick(rightClickButton).build().perform();
        System.out.println(rightClickMessage.getText());
        log.info("Testing ClickMe button");
        Reusuables.hiddenElementClick(driver, clickMeButton);
        System.out.println(dynamicClickMessage.getText());
    }
}
