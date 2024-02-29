package stepDefinitions;

import dataProvider.DataProvider;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

import java.util.HashMap;

public class BuyProductSteps extends BaseStep {
    CartPage cartPage;
    CheckoutOnePage checkoutOnePage;
    CheckoutSecondPage checkoutSecondPage;
    CheckoutCompletePage checkoutCompletePage;
    @Given("I select products")
    public void selectProducts() {
        homePage.addProductOneToCart();
        homePage.addProductTwoToCart();
        homePage.addProductThreeToCart();
    }
    @Given("I select the cart icon")
    public void selectCartIcon() {
        cartPage = homePage.clickOnShoppingCartIcon();
    }
    @And("I select the checkout button")
    public void selectCheckoutButton() {
        checkoutOnePage = cartPage.clickOnCheckoutButton();
    }
    @When("I am in the checkout page fill the fields First name, Last name and Zip code")
    public void fillFormsField() {
        //Consultar info
        checkoutOnePage.fieldInputsCheckout((String) getData().get("First Name"), (String) getData().get("Last Name"),
                (String) getData().get("Zip Code"));
    }
    @And("Select the Continue button")
    public void selectContinueButton() {
        checkoutSecondPage = checkoutOnePage.clickOnContinueButton();
    }
    @And("I am in the checkout overview for click in the Finish button")
    public void clickOnFinishButton() {
        checkoutCompletePage = checkoutSecondPage.clickOnFinishButton();
    }
    @Then("The message is shown in the finish page")
    public void ValidateTheMessageOnTheFinishPage() {
        checkoutCompletePage.isTheTitleTheSame((String) getData().get("Successful Buy Message"));
    }
}
