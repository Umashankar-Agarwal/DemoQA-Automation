package pages.elements;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Consonants;

import static utils.reusuables.scrollToBottom;

public class CheckBoxPage extends CardAccessPage {

    private final WebDriver driver;

    @FindBy(xpath = Consonants.elementList + "//li[@id='item-1']")
    WebElement checkBoxItem;
    @FindBy(xpath = "//span[@class= 'rct-checkbox']")
    WebElement checkBox;
    @FindBy(xpath = "//div[@id='result']")
    WebElement resultCheckBox;


    public CheckBoxPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CheckBoxPage checkBoxSetup() {
        elementsCard();
        checkBoxItem.click();
        return this;
    }

    public void checkTheBox() {
        checkBox.click();
    }

    public String checkBoxOut() {
        scrollToBottom(driver);
        return resultCheckBox.getText();
    }
}
