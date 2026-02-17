package Elements;

import base.BaseTest;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.elements.TextBoxPage;
import utils.TestData;

@Log4j2
public class TextBoxTest extends BaseTest {

    @Test(dataProvider = "TextBoxData", dataProviderClass = TestData.class)
    // Links test to the external 'TextBoxData' provider for parameterization
    public void verifyTextBox(String fullName, String email, String currentAdd, String permanentAdd) {
        // Creating the object of the page class
        TextBoxPage text = new TextBoxPage(driver);

        log.info("Running the test");
        text.textboxSetup()
                .fillFullName(fullName)
                .fillEmail(email)
                .fillCurrentAddress(currentAdd)
                .fillPermanentAddress(permanentAdd);
        text.submit();
        String output = text.outputOfForm();
        Assert.assertTrue(output.contains(fullName), "Full name missing in output");
        Assert.assertTrue(output.contains(email), "Email missing in output");
        Assert.assertTrue(output.contains(currentAdd), "Current Address missing in output");
        Assert.assertTrue(output.contains(permanentAdd), "Permanent Address missing in output");
    }
}
