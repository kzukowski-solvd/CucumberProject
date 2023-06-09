package com.solvd.carina.demo.cucumber;

import com.solvd.carina.demo.gui.models.User;
import com.solvd.carina.demo.gui.models.UserOrder;
import com.solvd.carina.demo.gui.pages.CheckoutPage;
import com.solvd.carina.demo.gui.pages.LoginPage;
import com.solvd.carina.demo.gui.pages.ProductListPage;
import com.solvd.carina.demo.gui.services.UserOrderService;
import com.solvd.carina.demo.gui.services.UserService;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VanillaTest implements IAbstractTest {

    @Test
    void myTest(){
        UserService userService = new UserService();
        User user = userService.getById(1);
        UserOrderService userOrderService = new UserOrderService();
        List<String> list = userOrderService.getById(user.getId()).stream().map(UserOrder::getProductName).collect(Collectors.toList());

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        ProductListPage productListPage = loginPage.login(user.getName(), user.getPassword());
        List<String> titles = productListPage.getTitles();
        List<Integer> matchingIds = getMatchingIds(list, titles);
        matchingIds.forEach(productListPage::addToCartButton);
        CheckoutPage checkoutPage = productListPage.goToCart().goToCheckout();
        checkoutPage.fillInDetails("a", "a", "a");
        String header = checkoutPage.goToStepTwo().finish().getHeader();
        Assert.assertEquals(header, "Thank you for your order!");
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
