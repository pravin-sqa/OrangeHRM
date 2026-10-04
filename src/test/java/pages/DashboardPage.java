package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class DashboardPage {

    private final Page page;
    private final Locator userDropdown;
    private final Locator logoutButton;

    public DashboardPage(Page page){

        this.page = page;
        this.userDropdown = page.locator(".oxd-userdropdown-name");
        this.logoutButton = page.getByRole(AriaRole.MENUITEM,new Page.GetByRoleOptions().setName("Logout"));

    }

    public void logout() {
        userDropdown.click();
        logoutButton.click();
    }
    

}
