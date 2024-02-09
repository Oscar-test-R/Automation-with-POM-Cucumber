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
        /*waitElementBeClickable(removeButton);
        removeButton.click();
        getWait().until(ExpectedConditions.invisibilityOf(removeButton));*/
        /*List<WebElement> list = listCartProducts.findElements(By.cssSelector(".cart_item"));
        System.out.println(list + " \n"+ " " + list.size());
        for(int i = 0; i < list.size(); i++){
            System.out.println(removeButton);
            removeButton = list.get(i);
            System.out.println("Eliminando elemento: " + removeButton);
            try {
                waitElementBeClickable(removeButton);
                if(removeButton.isDisplayed() && removeButton.isEnabled()){
                    Actions action = new Actions(getDriver());
                    action.moveToElement(removeButton).click().perform();
                    //action.click(removeButton);
                    ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", removeButton);
                    ((JavascriptExecutor)getDriver()).executeScript("arguments[0].checked = true;", removeButton);
                    //removeButton.click();
                    System.out.println("Flag 1");
                    //getWait().until(ExpectedConditions.stalenessOf(removeButton));
                    getWait().until(ExpectedConditions.invisibilityOf(removeButton));

                    System.out.println("Flag 2");
                }else {
                    System.out.println("Elemento no visible o no habilitado");
                }
            }catch (TimeoutException e){
                e.printStackTrace();
                System.out.println("The element can not be clicked");
            }
        }
        if(list.size() == 0){
            System.out.println("The cart is empty");
        }else {
            System.out.println(list + "\n" + "The cart has " + list.size());
        }*/
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
