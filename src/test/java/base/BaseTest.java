package base;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public static Playwright playwright;
    public static Browser browser;
    public static Page page;

    @BeforeMethod
    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        BrowserContext context = browser.newContext(
                new Browser.NewContextOptions().setViewportSize(1280, 720)
        );
        page = context.newPage();
        page.navigate("https://casekaro.com/");
        while (page.locator("button[aria-label='Remove item']").count() > 0) {
            page.locator("button[aria-label='Remove item']").first().click();
        }

    }


    @AfterMethod
    public void tearDown() {
        page.close();
        browser.close();
        playwright.close();
    }
}