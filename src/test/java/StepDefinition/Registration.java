package StepDefinition;

import Pages.HomePage;
import Pages.MyAccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertTrue;

public class Registration {
    HomePage homePage;
    MyAccountPage myAccountPage;

    @Given("Click MyAccount Page")
    public void goToMyAccountPage() {
        homePage = new HomePage(Hooks.driver);
        myAccountPage = homePage.clickMyAccount();
    }

    @When("^User Enter \"(.*)\" for email and \"(.*)\" for Password$")
    public void enterCredentials(String email, String password) {

        myAccountPage.enterEmail(email);
        myAccountPage.enterRegPassword(password);
        myAccountPage.enterRegPassword(password);
        myAccountPage.regPasswordTextBox.submit();

    }

    @Then("successfully login into Website")
    public void successfullyLogin() throws InterruptedException {
        Thread.sleep(3000);

        assertTrue(myAccountPage.getWelcomeText().contains("Hello"), "Login is Fail");
    }

    @Then("Error Message displayed You must enter valid email")
    public void errorMessageValidEmail() throws InterruptedException {
        Thread.sleep(1000);

        assertTrue(myAccountPage.getErrorText().contains("Please provide a valid email address."), "Registration complete");
    }

    @Then("Error Message displayed You must enter Password")
    public void errorMessageEnterPassword() throws InterruptedException {
        Thread.sleep(1000);
        assertTrue(myAccountPage.getErrorText().contains("Please enter an account password."), "Registration complete");
    }


}
