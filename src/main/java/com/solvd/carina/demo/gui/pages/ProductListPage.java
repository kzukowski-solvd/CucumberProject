package com.solvd.carina.demo.gui.pages;


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

    @FindBy(css = ".inventory_item .btn_inventory")
    private List<ExtendedWebElement> addToCartButton;

    @FindBy(className = "shopping_cart_link")
    private ExtendedWebElement goToCartButton;


    protected ProductListPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(goToCartButton);
    }

    public String getTitlee(int id) {
        return title.get(id).getText();
    }

    public Double getPrice(int id) {
        return Double.valueOf(price.get(id).getText().replace("$","").replace("\"",""));
    }

    public void addToCartButton(int id){
        addToCartButton.get(id).click();
    }

    public CartPage goToCart(){
        goToCartButton.click();
        return new CartPage(driver);
    }


}
