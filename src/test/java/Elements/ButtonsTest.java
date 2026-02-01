package Elements;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.elements.ButtonsPage;

public class ButtonsTest extends BaseTest {

    @Test
    public void buttonActionTest(){
        ButtonsPage btnPage = new ButtonsPage(driver);
        btnPage.buttonSetup();
        btnPage.buttonActions();
    }

}
