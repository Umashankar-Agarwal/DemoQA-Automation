package Elements;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.elements.WebTablePage;

public class WebTableTest extends BaseTest {

    @Test
    public void webTableAdd() {

        WebTablePage webTable = new WebTablePage(driver);

        webTable.webTableSetup();
        webTable.webTableAddRecord("Uma Shankar", "Agarwal", "umaWebTable@agarwal.com", "25", "50000", "IT Department");

    }
}
