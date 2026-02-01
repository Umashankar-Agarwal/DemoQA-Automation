package Elements;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.elements.TextBoxPage;

public class TextBoxTest extends BaseTest {

    @Test
    public void veriyTextBox() {

        // Creating the object of the page class
        TextBoxPage text = new TextBoxPage(driver);

        text.textboxSetup()
                .fillFullName("Uma Shankar")
                .fillEmail("umashankar.123@automation.com")
                .fillCurrentAddress("Gurgaon, Haryana , India")
                .fillPermanentAddress("Sheopur, Madhya Pradesh India");
        text.submit();
        System.out.println(text.outputOfForm());
    }
}
