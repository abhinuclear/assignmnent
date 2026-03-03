package stepdefinitions;

import base.pages.CartPage;
import base.pages.HomePage;
import base.pages.ProductPage;
import io.cucumber.java.en.*;

import static base.BaseTest.page;

public class CaseSteps  {

    HomePage home;
    ProductPage product;
    CartPage cart;

    @Given("I navigate to casekaro website")
    public void navigateToWebsite() {
        home = new HomePage(page);
        product = new ProductPage(page);
        cart = new CartPage(page);
    }

    @When("I click on Mobile Covers")
    public void clickMobileCovers() {
        home.clickMobileCovers();
    }

    @And("I search for iPhone 16 Pro")
    public void searchPhone() {
        home.searchAndSelectIphone16Pro();
    }

    @And("I add Hard material")
    public void addHardMaterial() {
        product.chooseFirstItem();
        product.addHard();
    }

    @And("I add Soft material")
    public void addSoftMaterial() {
        product.chooseFirstItem();
        product.addSoft();
    }

    @And("I add Glass material")
    public void addGlassMaterial() {
        product.chooseFirstItem();
        product.addGlass();
    }

    @Then("I open the cart")
    public void openCart() {
        cart.openCart();
    }

    @And("I validate 3 items are added")
    public void validateItems() {
        cart.validateItems();
    }

    @And("I print cart details")
    public void printDetails() {
        cart.printDetails();
    }
}