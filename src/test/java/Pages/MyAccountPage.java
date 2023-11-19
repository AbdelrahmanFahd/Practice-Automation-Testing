package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyAccountPage {
    WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    WebElement usernameTextBox;
    @FindBy(id = "reg_email")
    WebElement emailTextBox;
    @FindBy(id = "password")
    WebElement passwordTextBox;
    @FindBy(id = "reg_password")
    public WebElement regPasswordTextBox;
    @FindBy(css = "input[name=\"login\"]")
    WebElement loginButton;
    @FindBy(css = "input[name=\"register\"]")
    WebElement registerButton;
    @FindBy(css = ".woocommerce-MyAccount-content p")
    WebElement welcomeText;

    @FindBy(css = ".order-number span")
    WebElement titleTable;
    @FindBy(className = "button")
    WebElement orderDetailButton;
    @FindBy(css = ".woocommerce-MyAccount-content h2")
    WebElement pageOrderDetailTitle;
    @FindBy(css = "a[href=\"https://practice.automationtesting.in/my-account/edit-address/shipping\"]")
    WebElement editShippingAddress;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/form/h3")
    WebElement titleShippingAddress;

    @FindBy(css = ".woocommerce-error li")
    WebElement errorText;
    @FindBy(css = "a[href=\"https://practice.automationtesting.in/my-account/orders/\"]")
    WebElement ordersButton;
    @FindBy(css = "a[href=\"https://practice.automationtesting.in/my-account/edit-address/\"]")
    WebElement addressButton;
    @FindBy(css = "a[href=\"https://practice.automationtesting.in/my-account/edit-account/\"]")
    WebElement accountDetail;
    @FindBy(css = ".woocommerce-EditAccountForm > fieldset> legend")
    WebElement passwordChange;

    @FindBy(css = "a[href=\"https://practice.automationtesting.in/my-account/customer-logout/\"]")
    WebElement logoutButton;
    @FindBy(css = ".u-column1 h2")
    WebElement loginTitle;


    public WebElement[] getAddressTitle() {
        List<WebElement> elements = driver.findElements(By.cssSelector(".woocommerce-Address-title h3"));
        WebElement[] webElements = new WebElement[elements.size()];
        elements.toArray(webElements);
        return webElements;
    }

    public void enterUsername(String username) {
        usernameTextBox.sendKeys(username);
    }

    public void enterEmail(String email) {
        emailTextBox.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordTextBox.sendKeys(password);
    }

    public void enterRegPassword(String regPassword) {
        regPasswordTextBox.sendKeys(regPassword);
//        regPasswordTextBox.submit();
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickOrderViewButton() {
        orderDetailButton.click();
    }

    public void clickAccountDetailButton() {
        accountDetail.click();
    }

    public void clickEditShippingAddressButton() {
        editShippingAddress.click();
    }

    public void clickAddressButton() {
        addressButton.click();
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public String getWelcomeText() {
        return welcomeText.getText();
    }

    public String gettableTitle() {
        return titleTable.getText();
    }

    public String getPasswordChangeLabel() {
        return passwordChange.getText();
    }

    public String getLoginLabel() {
        return loginTitle.getText();
    }

    public String getShippingAddressTitle() {
        return titleShippingAddress.getText();
    }

    public String getPageTitle() {
        return pageOrderDetailTitle.getText();
    }

    public String getErrorText() {
        return errorText.getText();
    }

    public String getPasswordAttribute(String attribute) {
        return passwordTextBox.getAttribute(attribute);
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }

    public void clickOrdersButton() {
        ordersButton.click();
    }
}
