package com.solvd.carina.demo.gui.pages;

import com.solvd.carina.demo.gui.components.Product;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AbstractPage.class)
public class ProductListPage extends AbstractPage {

    @FindBy(className = "inventory_item_name")
    private List<ExtendedWebElement> title;

    @FindBy(className = "inventory_item_price")
    private List<ExtendedWebElement> price;

    @FindBy(className = "btn btn_primary btn_small btn_inventory")
    private List<ExtendedWebElement> addToCartButton;

    protected ProductListPage(WebDriver driver) {
        super(driver);
    }

    public String getTitlee(int id) {
        return title.get(id).getText();
    }

    public Integer getPrice(int id) {
        return Integer.valueOf(price.get(id).getText());
    }

    public void addToCartButton(int id){
        addToCartButton.get(id).click();
    }

}
