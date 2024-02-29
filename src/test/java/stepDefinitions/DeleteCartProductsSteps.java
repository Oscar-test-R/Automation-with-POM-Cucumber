package stepDefinitions;

import dataProvider.DataProvider;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myDriver.MyDriver;
import org.testng.Assert;
import pages.CartPage;

import java.util.HashMap;

public class DeleteCartProductsSteps extends BaseStep{
    CartPage cartPage;
    @When("I select the remove button")
    public void selectRemoveButton() {
        System.out.println(cartPage);
        cartPage.getProductList();
    }
    @Then("The product should be removed")
    public void productShouldBeRemoved() {
        HashMap <String, String> hashMap  = DataProvider.data();
        Assert.assertTrue(cartPage.validateEmptyList(),hashMap.get("Cart Empty Message"));
    }
}
