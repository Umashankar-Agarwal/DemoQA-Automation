package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pages.Consonants.elementList;
import static utils.reusuables.scrollIntoView;

public class RadioButtonPage extends CardAccessPage {

    private final WebDriver driver;
    @FindBy(xpath = elementList + "//li[@id = 'item-2']")
    WebElement radioButtonitem;
    @FindBy(xpath = "//*[text() = 'Yes']")
    WebElement yesRadio;
    @FindBy(xpath = "//p[@class='mt-3']")
    WebElement result;

    public RadioButtonPage(WebDriver driver) {
        this.driver = driver;
        super(driver);
        PageFactory.initElements(driver, this);

    }

    public RadioButtonPage radioButtonSetup() {
        elementsCard();
        radioButtonitem.click();
        return this;
    }

    public void updateRadioButton() {
        scrollIntoView(yesRadio, driver);
        yesRadio.click();
    }

    public String resultRadioButton() {
        return result.getText();
    }


}
