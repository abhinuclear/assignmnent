package base.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.testng.Assert;


public class ProductPage {

    Page page;

    public ProductPage(Page page) {
        this.page = page;
    }

    public void validateProductVisible() {

        Assert.assertTrue(page.locator(".card__heading").count() > 0);
    }

    public void chooseFirstItem() {

        page.locator("text=Choose options").first().click();

    }

    public void addHard() {
        selectAndAdd("Hard");
    }

    public void addSoft() {
        selectAndAdd("Soft");
    }

    public void addGlass() {
        selectAndAdd("Glass");
    }

    public void selectAndAdd(String material) {

        Locator productModel = page.getByRole(AriaRole.DIALOG);
        productModel.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));

        String inputId = productModel
                .locator("input[value='" + material + "']")
                .first()
                .getAttribute("id");

        productModel.locator("label[for='" + inputId + "']").first().click();
        page.waitForLoadState();

        productModel.getByText("Add to cart").click();


       page.locator("h2.drawer__heading").isVisible();

        page.locator("button[aria-label='Close']")
                .first()
                .click();


    }
}