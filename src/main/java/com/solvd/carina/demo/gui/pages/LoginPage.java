package com.solvd.carina.demo.gui.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(css = "#user-name")
    private ExtendedWebElement usernameField;

    @FindBy(css = "#password")
    private ExtendedWebElement passwordField;

    @FindBy(css = "#login-button")
    private ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(loginButton);
    }

    public ProductListPage login(String username, String password) {
        usernameField.type(username);
        passwordField.type(password);
        loginButton.click();
        return new ProductListPage(driver);
    }

}
