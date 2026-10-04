package tests;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import utils.JsonReader;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.login("Admin", "admin123");
        assertThat(page).hasURL(Pattern.compile(".*dashboard.*"));
    }

    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() {
        List<Map<String, String>> rows = JsonReader.read("testdata/login.json");
        Object[][] data = new Object[rows.size()][3];
        for (int i = 0; i < rows.size(); i++) {
            data[i][0] = rows.get(i).get("username");
            data[i][1] = rows.get(i).get("password");
            data[i][2] = rows.get(i).get("expectedMessage");
        }
        return data;
    }

    @Test(dataProvider = "invalidLoginData")
    public void invalidLogin(String user, String pass, String expectedMessage) {
        LoginPage loginPage = new LoginPage(page);
        loginPage.login(user, pass);
        assertThat(loginPage.getMessage(expectedMessage)).isVisible();
        System.out.println(expectedMessage);
    }
}
