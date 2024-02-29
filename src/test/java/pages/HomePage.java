package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy (css = ".bm-burger-button")
    private WebElement burguerButton;
    @FindBy (id = "logout_sidebar_link")
    private WebElement logoutOption;
    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    private WebElement addProductThreeToCartButton;
    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCartIcon;
    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement addProductTwoToCartButton;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addProductOneToCartButton;
    @FindBy(className = "app_logo")
    private WebElement homePageTitle;
    public LoginPage selectLogoutOption(){
        waitElementBeClickable(burguerButton);
        burguerButton.click();
        waitElementBeClickable(logoutOption);
        logoutOption.click();
        return new LoginPage(super.getDriver());
    }
    public HomePage addProductOneToCart(){
        waitElementBeClickable(addProductOneToCartButton);
        addProductOneToCartButton.click();
        return this;
    }
    public HomePage addProductTwoToCart(){
        waitElementBeClickable(addProductTwoToCartButton);
        addProductTwoToCartButton.click();
        return this;
    }
    public HomePage addProductThreeToCart(){
        waitElementBeClickable(addProductThreeToCartButton);
        addProductThreeToCartButton.click();
        return this;
    }
    public CartPage clickOnShoppingCartIcon (){
        shoppingCartIcon.click();
        return new CartPage(super.getDriver());
    }
    public boolean isHomeTitleCorrect (String titlePage){
        getWait().until(ExpectedConditions.visibilityOf(homePageTitle));
        return homePageTitle.isDisplayed() &&
                homePageTitle.getText().equals(titlePage);
    }
}
