package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (id = "checkout")
    private WebElement checkoutButton;
    @FindBy (css = "div.cart_list")
    private WebElement listCartProducts;
    @FindBy (css = ".cart_list .btn_secondary")
    private WebElement removeButton;
    public CartPage getProductList () {
        List<WebElement> list = listCartProducts.findElements(By.cssSelector(".cart_item"));
        for(int i = 0; i < list.size(); i++){
            waitElementBeClickable(removeButton);
            removeButton.click();
        }
        return this;
    }
    public boolean validateEmptyList(){
        List<WebElement> list = listCartProducts.findElements(By.cssSelector(".cart_item"));
        if (list.size() == 0){
            System.out.println("The cart is empty");
            return true;
        }else {
            System.out.println("The cart has " + list.size());
            return false;
        }
    }
    public CheckoutOnePage clickOnCheckoutButton(){
        waitElementBeClickable(checkoutButton);
        checkoutButton.click();
        return new CheckoutOnePage(super.getDriver());
    }
}
