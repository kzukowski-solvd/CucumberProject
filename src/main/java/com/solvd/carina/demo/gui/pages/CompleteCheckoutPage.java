package com.solvd.carina.demo.gui.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CompleteCheckoutPage extends AbstractPage {
    @FindBy(css = ".complete-header")
    private ExtendedWebElement header;
    protected CompleteCheckoutPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(header);
    }

    public String getHeader() {
        return header.getText();
    }
}
