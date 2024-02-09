package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

//@CucumberOptions(features = "src/test/resources/appFeatures/LoginPage.feature", glue = {"stepDefinitions", "BaseTest"})
public class FlowsShoppingCart extends BaseTest{
    LoginPage loginPage;
    HomePage homePage;
    CartPage cartPage;
    CheckoutOnePage checkoutOnePage;
    CheckoutSecondPage checkoutSecondPage;
    CheckoutCompletePage checkoutCompletePage;
    @Test (dataProvider = "data")
    public void logOut (String userName, String password){
        loginPage = loadFirstPage();
        loginPage.typeCredentials(userName, password);
        homePage = loginPage.clickLoginButton();
        homePage.selectLogoutOption();
        Assert.assertEquals(driver.getDriver().getCurrentUrl(), navigateTo());
        Assert.assertEquals(loginPage.validateTitlePage(), "Swag Labs");
    }
    @Test (dataProvider = "data")
    public void purchaseAProduct (String userName, String password){
        loginPage = loadFirstPage();
        loginPage.typeCredentials(userName, password);
        homePage = loginPage.clickLoginButton();
        homePage.addProductOneToCart();
        cartPage = homePage.clickOnShoppingCartIcon();
        checkoutOnePage = cartPage.clickOnCheckoutButton();
        checkoutOnePage.fieldInputsCheckout();
        checkoutSecondPage = checkoutOnePage.clickOnContinueButton();
        checkoutCompletePage = checkoutSecondPage.clickOnFinishButton();
        Assert.assertTrue(checkoutCompletePage.isTheTitleTheSame(),"The title is not the same.");
    }
    @Test (dataProvider = "data")
    public void deleteCartProducts (String userName, String password){
        loginPage = loadFirstPage();
        loginPage.typeCredentials(userName, password);
        homePage = loginPage.clickLoginButton();
        homePage.addProductOneToCart();
        homePage.addProductTwoToCart();
        homePage.addProductThreeToCart();
        cartPage = homePage.clickOnShoppingCartIcon();
        cartPage.getProductList();
        Assert.assertTrue(cartPage.validateEmptyList(),"The shopping cart is empty");
    }
}
