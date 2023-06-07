package com.solvd.carina.demo.cucumber.steps;

import com.solvd.carina.demo.gui.pages.CheckoutPage;
import com.solvd.carina.demo.gui.pages.LoginPage;
import com.solvd.carina.demo.gui.pages.ProductListPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import static com.zebrunner.agent.core.webdriver.RemoteWebDriverFactory.getDriver;

public class OrderPlacementSteps {
    LoginPage loginPage;
    ProductListPage productListPage;
    CheckoutPage checkoutPage;
    String header;

    @Given("I am on the login page")
    public void navigateToLoginPage() {
        loginPage = new LoginPage(getDriver());
        loginPage.open();
    }

    @When("I log in with username {string} and password {string}")
    public void login(String username, String password) {
        productListPage = loginPage.login(username, password);
    }

    @And("I add the first and second items to the cart")
    public void addItemsToCart() {
        productListPage.addToCartButton(0);
        productListPage.addToCartButton(1);
    }

    @And("I proceed to checkout")
    public void proceedToCheckout() {
        checkoutPage = productListPage.goToCart().goToCheckout();
    }

    @And("I fill in the details with first name {string}, last name {string}, and postal code {string}")
    public void fillInDetails(String firstName, String lastName, String postalCode) {
        checkoutPage.fillInDetails(firstName, lastName, postalCode);
    }

    @And("I complete the order")
    public void completeOrder() {
        header = checkoutPage.goToStepTwo().finish().getHeader();
    }

    @Then("I should see the header {string}")
    public void verifyHeader(String expectedHeader) {
        Assert.assertEquals(expectedHeader, header);
    }
}
