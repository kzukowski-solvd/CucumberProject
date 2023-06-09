package com.solvd.carina.demo.gui.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {
    @FindBy(css = "#checkout")
    private ExtendedWebElement goToCheckoutButton;
    protected CartPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(goToCheckoutButton);
    }

    public CheckoutPage goToCheckout (){
        goToCheckoutButton.click();
        return new CheckoutPage(driver);
    }

}
