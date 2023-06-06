package com.solvd.carina.demo.cucumber;

import com.solvd.carina.demo.gui.pages.LoginPage;
import com.solvd.carina.demo.gui.pages.ProductListPage;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.annotations.Test;

public class testtest implements IAbstractTest {

    @Test
    void myTest(){

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();

        ProductListPage productListPage = loginPage.login("standard_user", "secret_sauce");
        System.out.println(productListPage.getTitlee(0));

    }

}
