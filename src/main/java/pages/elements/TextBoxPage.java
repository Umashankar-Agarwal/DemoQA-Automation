package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.reusuables;

public class TextBoxPage extends CardAccessPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class='element-list collapse show']//ul[@class = 'menu-list']//li[@id='item-0']")
    private WebElement TextBoxItem;
    @FindBy(id = "userName")
    private WebElement fullName;
    @FindBy(id = "userEmail")
    private WebElement userEmail;
    @FindBy(id = "currentAddress")
    private WebElement currentAddress;
    @FindBy(id = "permanentAddress")
    private WebElement permanentAddress;
    @FindBy(id = "submit")
    private WebElement submitButton;
    @FindBy(id = "output")
    private WebElement output;

    public TextBoxPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public TextBoxPage textboxSetup() {
        elementsCard();
        TextBoxItem.click();
        return this;
    }

    public TextBoxPage fillFullName(String name) {
        fullName.sendKeys(name);
        return this;
    }

    public TextBoxPage fillEmail(String email) {
        userEmail.sendKeys(email);
        return this;
    }

    public TextBoxPage fillCurrentAddress(String addressCurrent) {
        currentAddress.sendKeys(addressCurrent);
        return this;
    }

    public void fillPermanentAddress(String addressPermanent) {
        permanentAddress.sendKeys(addressPermanent);
    }

    public void submit() {
        reusuables.scrollIntoView(submitButton, driver);
        submitButton.click();
    }

    public String outputOfForm() {
        return output.getText();
    }


}
