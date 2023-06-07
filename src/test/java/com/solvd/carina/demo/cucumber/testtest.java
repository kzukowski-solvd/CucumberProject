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

import java.util.List;

public class testtest implements IAbstractTest {

    @Test
    void myTest(){
        UserService userService = new UserService();
        User user = userService.getById(1);
        UserOrderService userOrderService = new UserOrderService();
        List<UserOrder> ordersForUser = userOrderService.getById(user.getId());
        ordersForUser.forEach(System.out::println);
/*

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        ProductListPage productListPage = loginPage.login("standard_user", "secret_sauce");
        productListPage.addToCartButton(0);
        productListPage.addToCartButton(1);
        CheckoutPage checkoutPage = productListPage.goToCart().goToCheckout();
        checkoutPage.fillInDetails("a", "a", "a");
        String header = checkoutPage.goToStepTwo().finish().getHeader();
        Assert.assertEquals(header, "Thank you for your order!");*/
    }

}
