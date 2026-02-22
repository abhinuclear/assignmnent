package base.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.Assert;

public class CartPage {

    Page page;

    public CartPage(Page page) {
        this.page = page;
    }

    public void openCart() {
        page.locator("#cart-icon-bubble").click();
        page.waitForTimeout(1500);
    }

    public void validateItems() {
        Locator cartItems = page.locator(".cart-item");
        int count = cartItems.count();
        System.out.println("Cart item count: " + count);
        Assert.assertEquals(count, 3, "Expected 3 items in cart but found " + count);
    }

    public void printDetails() {
        Locator cartItems = page.locator(".cart-item");
        int count = cartItems.count();

        for (int i = 0; i < count; i++) {
            Locator item = cartItems.nth(i);

            String link = item.locator("a.cart-item__name").getAttribute("href");

            String price = item.locator(".price").first().innerText().trim();

            String materialFull = item.locator("dl").innerText().trim();
            String material = materialFull.contains(":") ? materialFull.split(":")[1].trim() : materialFull;

            System.out.println("=============");
            System.out.println("Material : " + material);
            System.out.println("Price    : " + price);
            System.out.println("Link     : https://casekaro.com" + link);
        }
    }
}