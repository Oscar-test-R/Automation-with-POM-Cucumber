package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutSecondPage extends BasePage{
    public CheckoutSecondPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (id = "finish")
    private WebElement finishButton;
    public CheckoutCompletePage clickOnFinishButton (){
        waitElementBeClickable(finishButton);
        finishButton.click();
        return new CheckoutCompletePage(super.getDriver());
    }
}
