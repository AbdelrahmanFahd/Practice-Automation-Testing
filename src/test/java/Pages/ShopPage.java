package Pages;

import StepDefinition.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ShopPage {
    WebDriver driver;

    public ShopPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "ui-slider-handle")
    List<WebElement> slidersSpan;
    @FindBy(css = ".price_label .to")
    WebElement priceLabel;
    @FindBy(css = ".cat-item a")
    WebElement androidButton;
    @FindBy(className = "woocommerce-breadcrumb")
    WebElement pathWeb;

    @FindBy(className = "orderby")
    WebElement sortDropDown;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/ul/li[1]/a[1]/img")
    WebElement androidGuide;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/ul/li[1]/a[2]")
    WebElement addBasket;
    @FindBy(css = "a[href=\"https://practice.automationtesting.in/basket/\"]")
    WebElement viewBasket;
    @FindBy(css = "#wpmenucartli a")
    WebElement menuCart;

    public void putSlider() {
        WebElement[] object = new WebElement[slidersSpan.size()];
        slidersSpan.toArray(object);
        Actions actions = new Actions(Hooks.driver);
        actions.dragAndDropBy(object[1], -28, 0).build().perform();
    }

    public String getPrice() {
        return priceLabel.getText();
    }

    public void clickAndroidButton() {
        androidButton.click();
    }

    public String getPathWeb() {
        return pathWeb.getText();
    }

    public void sortSelect(String value) {
        Select select = new Select(sortDropDown);
        select.selectByValue(value);
    }

    public String getSelectedSort() {
        Select select = new Select(sortDropDown);
        return select.getAllSelectedOptions().get(0).getText();

    }

    public ProductPage clickAndroidGuid() {
        androidGuide.click();
        return new ProductPage(Hooks.driver);
    }

    public void clickOnAddBasket() {
        addBasket.click();
    }

    public CartPage clickViewBasket() {
        viewBasket.click();
        return new CartPage(Hooks.driver);
    }

    public CartPage clickOnCart() {
        menuCart.click();
        return new CartPage(Hooks.driver);
    }


}