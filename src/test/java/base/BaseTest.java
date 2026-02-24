package base;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

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

    }


    @AfterMethod
    public void tearDown() {
        page.waitForTimeout(3000);
        page.close();
        browser.close();
        playwright.close();
    }
}