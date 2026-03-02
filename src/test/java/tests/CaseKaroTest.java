/*package tests;

import base.BaseTest;
import base.pages.CartPage;
import base.pages.HomePage;
import base.pages.ProductPage;
import org.testng.annotations.Test;

public class CaseKaroTest extends BaseTest {

    @Test
    public void addAppleCase() {

        HomePage home = new HomePage(page);
        ProductPage product = new ProductPage(page);
        CartPage cart = new CartPage(page);


        home.clickMobileCovers();
        home.searchAndSelectIphone16Pro();

        product.validateFirstProductVisible();
        product.chooseFirstItem();
        product.addHard();

        product.chooseFirstItem();
        product.addSoft();

        product.chooseFirstItem();
        product.addGlass();

        cart.openCart();
        cart.validateItems();
        cart.printDetails();

    }
}

 */