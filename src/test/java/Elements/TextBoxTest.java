package Elements;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.elements.TextBoxPage;

public class TextBoxTest extends BaseTest {

    @Test
    public void veriyTextBox() {

        // Creating the object of the page class
        TextBoxPage text = new TextBoxPage(driver);

        /*
        We are here to write the the method which will pass the values to the
        to the TextBoxPage Class method to perform the action.
         */

        text.textboxSetup()
                .fillFullName("Uma Shankar")
                .fillEmail("abc.123@company.com")
                .fillCurrentAddress("Gurgaon, Haryana , India")
                .fillPermanentAddress("Sheopur, Madhya Pradesh India");
        text.submit();
        System.out.println(text.outputOfForm());




    }


}
