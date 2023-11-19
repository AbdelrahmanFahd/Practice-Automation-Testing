package Pages;

import StepDefinition.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".cart-subtotal .woocommerce-Price-amount")
    WebElement subTotalPrice;
    @FindBy(css = ".order-total .woocommerce-Price-amount")
    WebElement totalPrice;
    @FindBy(css = "a[href=\"https://practice.automationtesting.in/checkout/\"]")
    WebElement proceedToCheckout;

    public PaymentGatewayPage clickOnCheckOut() {
        proceedToCheckout.click();
        return new PaymentGatewayPage(Hooks.driver);
    }

    public String getSubTotalPrice() {
        return subTotalPrice.getText();
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }

}
