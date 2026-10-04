package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage {
    private final Page page;
    private final Locator username;
    private final Locator password;
    private final Locator loginButton;

    public LoginPage(Page page) {
        this.page = page;
        this.username = page.getByPlaceholder("Username");
        this.password = page.getByPlaceholder("Password");
        this.loginButton = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Login"));
    }

    public void login(String user, String pass) {
        username.fill(user);
        password.fill(pass);
        loginButton.click();
    }

    public Locator getMessage(String text) {
        return page.getByText(text, new Page.GetByTextOptions().setExact(true)).first();
    }
}