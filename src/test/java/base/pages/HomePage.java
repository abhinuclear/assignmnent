package base.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;

public class HomePage {

    Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    public void clickMobileCovers() {
        page.getByRole(AriaRole.LINK,
            new Page.GetByRoleOptions()
                    .setName("Mobile Cases & Covers")
                    .setExact(true))
            .click();

    page.waitForLoadState();
    }

    public void searchAndSelectIphone16Pro() {

        page.getByPlaceholder("Search your phone model").fill("iphone 16 pro");
        page.waitForTimeout(500);

        String[] otherBrands = {"Samsung", "Vivo", "OnePlus", "Oppo", "Realme", "Redmi"};
        for (String brand : otherBrands) {
            Assert.assertEquals(
                    page.locator("button:has-text('" + brand + "')").count(), 0,
                    brand + " should not be visible"
            );
        }
        page.getByRole(AriaRole.LINK,
                        new Page.GetByRoleOptions().setName("iPhone 16 Pro").setExact(true))
                .click();

        page.waitForLoadState();
    }
}
