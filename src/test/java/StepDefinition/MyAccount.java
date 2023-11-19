package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Hook;
import org.openqa.selenium.By;

import static org.testng.Assert.assertTrue;

public class MyAccount {

    @When("Click on Orders Button")
    public void clickOrderButton() {

        Login.myAccountPage.clickOrdersButton();

    }

    @When("Click on View Button")
    public void clickViewButton() {

        Login.myAccountPage.clickOrderViewButton();

    }

    @When("Click on Addresses")
    public void clickAddressesButton() {

        Login.myAccountPage.clickAddressButton();

    }

    @When("Click on Account Detail")
    public void clickAccountDetailButton() {

        Login.myAccountPage.clickAccountDetailButton();

    }

    @When("Click on Log out")
    public void clickLogOutButton() {

        Login.myAccountPage.clickLogoutButton();

    }

    @And("Click on Edit ShippingAddress")
    public void clickEditShipping() {
        Login.myAccountPage.clickEditShippingAddressButton();

    }

    @Then("view orders successfully")
    public void viewOrder() {
        assertTrue(Login.myAccountPage.gettableTitle().contains("Order"), "User Can not view orders");
    }

    @Then("view Account Detail successfully")
    public void viewAccountDetail() {
        assertTrue(Login.myAccountPage.getPasswordChangeLabel().contains("Password Change"), "User Can not view Account Detail");
    }

    @Then("view order detail successfully")
    public void viewOrderDetail() {
        assertTrue(Login.myAccountPage.getPageTitle().contains("Order Details"), "User Can not view order Details");
    }

    @Then("view order detail orderNum, data, state successfully")
    public void viewOrderDetailNumDataState() {

        assertTrue(Login.myAccountPage.getPageTitle().contains("Order Details"), "User Can not view order Details");
    }

    @Then("view Address Title successfully")
    public void viewAddressTitle() {
        var addressTitle = Login.myAccountPage.getAddressTitle();
        assertTrue(addressTitle[0].getText().contains("Billing Address"), "User Can not view Address Page");
    }

    @Then("view Edit Page successfully")
    public void viewEditePageTitle() {
        var addressTitle = Login.myAccountPage.getAddressTitle();
        assertTrue(Login.myAccountPage.getShippingAddressTitle().contains("Shipping Address"), "User Can not view edit Address Page");
    }


}
