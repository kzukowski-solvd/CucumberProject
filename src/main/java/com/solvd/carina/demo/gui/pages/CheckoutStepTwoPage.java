package com.solvd.carina.demo.gui.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutStepTwoPage extends AbstractPage {
    @FindBy(css = "#finish")
    private ExtendedWebElement finishButton;
    protected CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(finishButton);
    }

    public CompleteCheckoutPage finish() {
        finishButton.click();
        return new CompleteCheckoutPage(driver);
    }

}
