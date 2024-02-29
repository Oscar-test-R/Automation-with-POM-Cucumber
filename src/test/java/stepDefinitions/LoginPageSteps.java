package stepDefinitions;

import dataProvider.DataProvider;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myDriver.MyDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

import java.util.HashMap;

public class LoginPageSteps extends BaseStep{
    LoginPage loginPage;
    HomePage homePage;
    protected MyDriver driver;

    @Given ("I am on the login page")
    public void theLoginPage() {
        loginPage = loadFirstPage();
    }
    @When("I enter valid credentials {string} and password {string}")
    public void enterValidCredentials(String userName, String password){
        loginPage.typeCredentials(userName, password);
    }
    @And ("I click on the login button")
    public void IClickOnTheLoginButton(){
        homePage = loginPage.clickLoginButton();
    }
    @Then ("message is displayed to confirm the user is on the home page")
    public void IShouldBeOnTheHomePage (){
        Assert.assertTrue(homePage.isHomeTitleCorrect((String) getData().get("Login Message")), "The title is not the same");
    }
}
