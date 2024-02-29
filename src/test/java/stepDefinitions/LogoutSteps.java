package stepDefinitions;

import dataProvider.DataProvider;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;

import java.util.HashMap;

public class LogoutSteps extends BaseStep {
    LoginPage loginPage;
    @Given("user has already logged in to application with {string} and password {string}")
    public void userLogged(String userName, String password) {
        loginPage = loadFirstPage();
        loginPage.typeCredentials(userName, password);
        homePage = loginPage.clickLoginButton();
    }
    @When("Clicks on the logout option in burger menu")
    public void clicksOnTheLogoutOption() {
        homePage.selectLogoutOption();
    }
    @Then("Then Redirect to the login page without credentials")
    public void validateLogoutCorrectly() {
        Assert.assertTrue(loginPage.validateTitlePage((String) getData().get("Logout Message")), "The title is not the same");
    }
}
