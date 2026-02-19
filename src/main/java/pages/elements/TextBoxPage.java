package pages.elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import pages.Consonants;
import utils.Reusuables;

@Log4j2
public class TextBoxPage extends CardAccessPage {

    private final WebDriver driver;

    @FindBy(xpath = "//a[@href='/text-box']")
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
        log.info("Click on Text Box Item");
        TextBoxItem.click();
        return this;
    }

    public TextBoxPage fillFullName(String name) {
        log.info("Enter your Name");
        fullName.sendKeys(name);
        return this;
    }

    public TextBoxPage fillEmail(String email) {
        log.info("Enter your Email");
        userEmail.sendKeys(email);
        return this;
    }

    public TextBoxPage fillCurrentAddress(String addressCurrent) {
        log.info("Enter your current Address");
        currentAddress.sendKeys(addressCurrent);
        return this;
    }

    public void fillPermanentAddress(String addressPermanent) {
        log.info("Enter your permanent address");
        permanentAddress.sendKeys(addressPermanent);
    }

    public void submit() {
        log.info("Scroll down");
        Reusuables.scrollIntoView(submitButton, driver);
        log.info("click on Submit Button");
        submitButton.click();
    }

    public String outputOfForm() {
        log.info("Taking the output");
        return output.getText();
    }
}
