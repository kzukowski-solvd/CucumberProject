package com.solvd.carina.demo.gui.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends AbstractPage {
    @FindBy(css = "#first-name")
    private ExtendedWebElement firstNameField;

    @FindBy(css = "#last-name")
    private ExtendedWebElement lastNameField;

    @FindBy(css = "#postal-code")
    private ExtendedWebElement postalCodeField;

    @FindBy(css = "#continue")
    private ExtendedWebElement continueButton;

    protected CheckoutPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(continueButton);
    }

    public void fillInDetails(String firstName, String lastName, String postalCode) {
        firstNameField.type(firstName);
        lastNameField.type(lastName);
        postalCodeField.type(postalCode);
    }

    public CheckoutStepTwoPage goToStepTwo(){
        continueButton.click();
        return new CheckoutStepTwoPage(driver);
    }

}
