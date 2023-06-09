package com.solvd.carina.demo.cucumber.steps;

import com.solvd.carina.demo.gui.models.User;
import com.solvd.carina.demo.gui.models.UserOrder;
import com.solvd.carina.demo.gui.pages.CheckoutPage;
import com.solvd.carina.demo.gui.pages.LoginPage;
import com.solvd.carina.demo.gui.pages.ProductListPage;
import com.solvd.carina.demo.gui.services.UserOrderService;
import com.solvd.carina.demo.gui.services.UserService;
import com.zebrunner.carina.webdriver.IDriverPool;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyStepdefs implements IDriverPool {
    private UserService userService;
    private User user;
    private ProductListPage productListPage;
    private CheckoutPage checkoutPage;
    private String header;

    @Given("a user with ID {int}")
    public void aUserWithID(int userId) {
        userService = new UserService();
        user = userService.getById(userId);
    }

    @When("the user logs in with valid credentials")
    public void theUserLogsInWithValidCredentials() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        productListPage = loginPage.login(user.getName(), user.getPassword());
    }

    @And("the user navigates to the product list page")
    public void theUserNavigatesToTheProductListPage() {
        // No additional code.
    }

    @And("the user adds the matching products to the cart")
    public void theUserAddsTheMatchingProductsToTheCart() {
        UserOrderService userOrderService = new UserOrderService();
        List<String> list = userOrderService.getById(user.getId())
                .stream()
                .map(UserOrder::getProductName)
                .collect(Collectors.toList());

        List<String> titles = productListPage.getTitles();
        List<Integer> matchingIds = getMatchingIds(list, titles);

        for (Integer id : matchingIds) {
            productListPage.addToCartButton(id);
        }
    }

    @And("the user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        productListPage.goToCart();
        checkoutPage = productListPage.goToCart().goToCheckout();
    }

    @And("the user fills in the shipping details with:")
    public void theUserFillsInTheShippingDetailsWith(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String firstName = data.get(0).get("First Name");
        String lastName = data.get(0).get("Last Name");
        String address = data.get(0).get("Address");

        checkoutPage.fillInDetails(firstName, lastName, address);
        header = checkoutPage.goToStepTwo().finish().getHeader();
    }


    @And("the user completes the order")
    public void theUserCompletesTheOrder() {
        // No additional code.
    }

    @Then("the user sees the header message {string}")
    public void theUserSeesTheHeaderMessage(String expectedHeader) {
        Assert.assertEquals(expectedHeader, header);
    }
    private static List<Integer> getMatchingIds(List<String> firstList, List<String> secondList) {
        List<Integer> matchingIds = new ArrayList<>();

        for (String element : secondList) {
            if (firstList.contains(element)) {
                matchingIds.add(secondList.indexOf(element));
            }
        }

        return matchingIds;
    }

}
