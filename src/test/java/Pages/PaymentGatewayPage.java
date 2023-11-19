package Pages;

import StepDefinition.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentGatewayPage {

    WebDriver driver;

    public PaymentGatewayPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "billing_first_name")
    WebElement firstName;

    @FindBy(id = "billing_last_name")
    WebElement lastName;

    @FindBy(id = "billing_email")
    WebElement email;
    @FindBy(id = "billing_phone")
    WebElement phone;

    @FindBy(id = "billing_address_1")
    WebElement address1;

    @FindBy(id = "billing_city")
    WebElement city;

    @FindBy(id = "billing_postcode")
    WebElement postCode;
    @FindBy(id = "billing_state")
    WebElement state;

    @FindBy(id = "payment_method_bacs")
    WebElement directBankTransfer;
    @FindBy(id = "place_order")
    WebElement placeOrder;


    public void enterFirstName(String text) {
        firstName.sendKeys(text);
    }

    public void enterLastName(String text) {
        lastName.sendKeys(text);
    }

    public void enterEmail(String text) {
        email.sendKeys(text);
    }

    public void enterPhone(String text) {
        phone.sendKeys(text);
    }

    public void enterAddress(String text) {
        address1.sendKeys(text);
    }

    public void enterCity(String text) {
        city.sendKeys(text);
    }

    public void enterPostCode(String text) {
        postCode.sendKeys(text);
    }

    public void enterState(String text) {
        state.sendKeys(text);
    }

    public void clickDirectBankTransfer() {
        directBankTransfer.click();
    }

    public OrderConfirmationPage clickPlaceOrder() {
        placeOrder.click();
        return new OrderConfirmationPage(Hooks.driver);
    }


}
