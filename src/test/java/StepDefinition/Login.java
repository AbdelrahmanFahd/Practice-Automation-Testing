package StepDefinition;

import Pages.HomePage;
import Pages.MyAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertTrue;

public class Login {
    HomePage homePage;
    static MyAccountPage myAccountPage;

    @Given("User go to MyAccount Page")
    public void goToMyAccountPage() {
        homePage = new HomePage(Hooks.driver);
        myAccountPage = homePage.clickMyAccount();

    }

    @When("^User Enter \"(.*)\" for UserName and \"(.*)\" for Password$")
    public void enterCredentials(String username, String password) {

        myAccountPage.enterUsername(username);
        myAccountPage.enterPassword(password);
        myAccountPage.clickLoginButton();
    }

    @When("User Enter Password")
    public void enterPassword() {
        myAccountPage.enterPassword("555sa");
    }

    @Then("successfully login")
    public void successfullyLogin() {
        assertTrue(myAccountPage.getWelcomeText().contains("Hello"), "Login is Fail");
    }

    @Then("successfully logout")
    public void successfullyLogout() {
        assertTrue(myAccountPage.getLoginLabel().contains("Login"), "Logout is Fail");
    }

    @Then("Error Message displayed Invalid UserName")
    public void invalidUserName() {
        assertTrue(myAccountPage.getErrorText().contains("is not registered on this site"), "Could Login");
    }

    @Then("Error Message displayed Password required")
    public void passwordRequired() {
        assertTrue(myAccountPage.getErrorText().contains("Password is required."), "Could Login");
    }

    @Then("Error Message displayed Username required")
    public void usernameRequired() {
        assertTrue(myAccountPage.getErrorText().contains("Username is required."), "Could Login");
    }

    @Then("Password must be Masked")
    public void assertMaskedPassword() {

        assertTrue(myAccountPage.getPasswordAttribute("type").contains("password"), "Password not protected");
    }

    @And("User Sign out And press Back")
    public void signOutAndBack() {
        myAccountPage.clickLogoutButton();
        Hooks.driver.navigate().back();
    }

    @Then("Home Page Must be visible")
    public void assertHomepage() {
        assertTrue(Hooks.driver.getCurrentUrl().contains("https://practice.automationtesting.in/"), "User not in home page");
    }
}
