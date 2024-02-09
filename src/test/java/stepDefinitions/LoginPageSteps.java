package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import tests.BaseTest;

public class LoginPageSteps {
    BaseTest baseTest;
    LoginPage loginPage;
    HomePage homePage;
    @Given ("I am on the login page")
    public void IAmOnTheLoginPage() {
        loginPage = baseTest.loadFirstPage();
    }
    @When("I enter valid credentials username {string} and password {string}")
    public void IEnterValidCredentials(String userName, String password){
        loginPage.typeCredentials(userName, password);
    }
    @And ("I click on the login button")
    public void IClickOnTheLoginButton(){
        homePage = loginPage.clickLoginButton();
    }
    @Then ("{string} message is displayed to confirm the user is on the home page")
    public void IShouldBeOnTheHomePage (String title){
        Assert.assertTrue(homePage.isHomeTitleCorrect(title), "The title is not the same");
    }
}
