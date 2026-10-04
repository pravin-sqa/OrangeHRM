package base;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeMethod
    public void setUp() {
        playwright = Playwright.create();

        boolean headless = Boolean.parseBoolean(ConfigReader.get("headless"));
        browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(headless));

        context = browser.newContext();

        page = context.newPage();
        page.navigate(ConfigReader.get("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {
        page.close();
        context.close();

        browser.close();
        playwright.close();
    }
}