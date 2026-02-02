package utils;

import org.testng.annotations.DataProvider;

public class TestData {

  @DataProvider(name = "TextBoxData")
    public static Object[][] TextBoxDataProvider() {
        return new Object[][]{
                {"Uma Shankar", "umatest1@gmail.com", "Gurgaon, Haryana", "Sheopur, Madhya Pradesh"},
                {"Ravi2", "Ravitest2@yahoo.com", "Chennai", "Kota"}
        };
    }

}
