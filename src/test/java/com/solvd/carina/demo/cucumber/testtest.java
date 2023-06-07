package com.solvd.carina.demo.cucumber;

import com.solvd.carina.demo.gui.pages.CheckoutPage;
import com.solvd.carina.demo.gui.pages.LoginPage;
import com.solvd.carina.demo.gui.pages.ProductListPage;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testtest implements IAbstractTest {

    @Test
    void myTest(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        ProductListPage productListPage = loginPage.login("standard_user", "secret_sauce");
        productListPage.addToCartButton(0);
        productListPage.addToCartButton(1);
        CheckoutPage checkoutPage = productListPage.goToCart().goToCheckout();
        checkoutPage.fillInDetails("a", "a", "a");
        String header = checkoutPage.goToStepTwo().finish().getHeader();
        Assert.assertEquals(header, "Thank you for your order!");
    }

}
