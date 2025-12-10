package Elements;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.elements.CheckBoxPage;

public class CheckBoxTest extends BaseTest {

    @Test
    public void checkBoxTest(){
        CheckBoxPage check = new CheckBoxPage(driver);
        check.checkBoxSetup()
                .checkTheBox();
        System.out.println(check.checkBoxOut());
    }
}
