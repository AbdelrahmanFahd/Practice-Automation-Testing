package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;
    MyAccountPage myAccountPage;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "menu-item-50")
    public WebElement myAccountButton;
    @FindBy(id = "menu-item-40")
    public WebElement shopButton;

    public MyAccountPage clickMyAccount() {
        myAccountButton.click();
        return new MyAccountPage(driver);
    }
    public ShopPage clickShop() {
        shopButton.click();
        return new ShopPage(driver);
    }
}
