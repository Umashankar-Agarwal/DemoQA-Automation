package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Consonants;
import utils.reusuables;

public class WebTablePage extends CardAccessPage {

    public final WebDriver driver;

    public WebTablePage(WebDriver driver) {
        this.driver = driver;
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = Consonants.elementList + "//li[@id='item-3']")
    WebElement webTableButton;
    @FindBy(css = ".web-tables-wrapper")
    WebElement webTable;
    @FindBy(id = "addNewRecordButton")
    WebElement addNewRecordButton;
    @FindBy(id = "firstName")
    WebElement firstName;
    @FindBy(id = "lastName")
    WebElement lastName;
    @FindBy(id = "userEmail")
    WebElement userEmail;
    @FindBy(id = "age")
    WebElement age;
    @FindBy(id = "salary")
    WebElement salary;
    @FindBy(id = "department")
    WebElement department;
    @FindBy(id = "submit")
    WebElement submit;

    public void webTableSetup() {
        elementsCard();
        webTableButton.click();
        reusuables.scrollIntoView(webTable, driver);
    }

    public void webTableAddRecord(String userFirstName, String userLastName, String email, String userAge, String userSalary, String userDepartment) {
        addNewRecordButton.click();
        firstName.sendKeys(userFirstName);
        lastName.sendKeys(userLastName);
        userEmail.sendKeys(email);
        age.sendKeys(userAge);
        salary.sendKeys(userSalary);
        department.sendKeys(userDepartment);
        submit.click();
    }


}
