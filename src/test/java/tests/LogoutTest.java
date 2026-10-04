package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class LogoutTest extends BaseTest {
    @Test
        public void Logout()
    {
        LoginPage loginPage = new LoginPage(page);
        loginPage.login("Admin", "admin123");

        DashboardPage dashboardPage = new DashboardPage(page);
        dashboardPage.logout();

        assertThat(page).hasURL(Pattern.compile(".*auth/login.*"));

    }



}
