package Elements;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.elements.RadioButtonPage;

public class RadioButtonTest extends BaseTest {

    @Test
    public void checkRadioButton(){
        RadioButtonPage radio = new RadioButtonPage(driver);
        radio.radioButtonSetup()
                .updateRadioButton();

        System.out.println(radio.resultRadioButton());

    }
}
