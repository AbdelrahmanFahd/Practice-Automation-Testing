package StepDefinition;

import Pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class shop {
    HomePage homePage;
    ShopPage shopPage;
    ProductPage productPage;
    CartPage cartPage;
    PaymentGatewayPage paymentGatewayPage;
    OrderConfirmationPage orderConfirmationPage;

    @Given("User go to Shop Page")
    public void goToShopPage() {
        homePage = new HomePage(Hooks.driver);
        shopPage = homePage.clickShop();

    }

    @When("Adjust the filter by price between 150 to 450 rps")
    public void filterBySlider() {
        shopPage.putSlider();

    }

    @Then("successfully Filter Shop")
    public void filterShop() {
        assertFalse(shopPage.getPrice().contains("500"), "Filter dose not work");
    }


    @When("Click on Android")
    public void clickAndroid() {
        shopPage.clickAndroidButton();
    }

    @Then("View only that Android products")
    public void viewAndroidProducts() {
        assertTrue(shopPage.getPathWeb().contains("Android"));
    }

    @When("Select sort by Popularity")
    public void sortByPopularity() {
        shopPage.sortSelect("popularity");
    }

    @Then("View the popular products only")
    public void viewPopularProducts() {
        assertTrue(shopPage.getSelectedSort().contains("Sort by popularity"), "Not Sort By popularity");
    }

    @When("Select sort by Rating")
    public void sortByRating() {
        shopPage.sortSelect("rating");
    }

    @Then("View the Rating products only")
    public void viewRatingProducts() {
        assertTrue(shopPage.getSelectedSort().contains("Sort by average rating"), "Not Sort By Rating");
    }

    @When("Select sort by Newness")
    public void sortByNewness() {
        shopPage.sortSelect("date");
    }

    @Then("View the Newness products only")
    public void viewNewnessProducts() {
        assertTrue(shopPage.getSelectedSort().contains("Sort by newness"), "Not Sort By Newness");
    }

    @When("Select sort by Price")
    public void sortByPrice() {
        shopPage.sortSelect("price");
    }

    @Then("View the Price products only")
    public void viewPriceProducts() {
        assertTrue(shopPage.getSelectedSort().contains("Sort by price: low to high"), "Not Sort By Price");
    }

    @When("Select sort by PriceDesc")
    public void sortByPriceDesc() {
        shopPage.sortSelect("price-desc");
    }

    @Then("View the PriceDesc products only")
    public void viewPriceDescProducts() {
        assertTrue(shopPage.getSelectedSort().contains("Sort by price: high to low"), "Not Sort By PriceDesc");
    }

    @When("Click on Sale written product")
    public void ClickOnSaleProduct() {
        productPage = shopPage.clickAndroidGuid();
    }

    @Then("View the actual price with old price")
    public void ViewActualPriceAndOldPrice() {
        assertEquals(productPage.getNumberOfPrices(), 2, "There is not two prices");
    }

    @When("Click on Add to Basket")
    public void clickAddBasket() throws InterruptedException {
        shopPage.clickOnAddBasket();

        // wait for adding item to cart
        waitUntilElementBeVisible(By.cssSelector("a[title=\"View Basket\"]"));

        cartPage = shopPage.clickOnCart();
    }

    @And("Complete The process")
    public void completeProcess() throws InterruptedException {
        paymentGatewayPage = cartPage.clickOnCheckOut();
        paymentGatewayPage.enterFirstName("hello");
        paymentGatewayPage.enterLastName("hello");
        paymentGatewayPage.enterEmail("hello@gmail.com");
        paymentGatewayPage.enterPhone("0125645689465");
        paymentGatewayPage.enterAddress("hello");
        paymentGatewayPage.enterCity("hello");
        paymentGatewayPage.enterPostCode("55465456");
//        paymentGatewayPage.enterState("hello");
        Thread.sleep(3000);
        paymentGatewayPage.clickDirectBankTransfer();

        orderConfirmationPage = paymentGatewayPage.clickPlaceOrder();


//      waiting for loading page
    }

    @Then("Order has been received")
    public void orderReceived() {
        assertTrue(orderConfirmationPage.getOrderMessage().contains("Thank you. Your order has been received."), "Order Has not Received");
    }

    private void waitUntilElementBeVisible(By by) {
        var webDriverWait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(30));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
