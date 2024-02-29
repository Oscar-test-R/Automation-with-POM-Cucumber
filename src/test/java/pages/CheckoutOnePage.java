package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOnePage extends BasePage{
    public CheckoutOnePage(WebDriver driver) {
        super(driver);
    }
    @FindBy (css = "input[name='firstName']")
    private WebElement txtFirstName;
    @FindBy(id = "last-name")
    private WebElement txtLastName;
    @FindBy (id = "postal-code")
    private WebElement txtPostalCode;
    @FindBy (css = "input[type='submit']")
    private WebElement continueButton;
    public CheckoutOnePage fieldInputsCheckout (String firstName, String lastName, String postalCode){
        waitElementBeClickable(txtFirstName);
        txtFirstName.sendKeys(firstName);
        txtLastName.sendKeys(lastName);
        txtPostalCode.sendKeys(postalCode);
        return this;
    }
    public CheckoutSecondPage clickOnContinueButton(){
        continueButton.click();
        return new CheckoutSecondPage(super.getDriver());
    }
}
