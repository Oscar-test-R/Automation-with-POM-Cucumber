package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutCompletePage extends BasePage{
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }
    @FindBy (css = "h2.complete-header")
    private WebElement thankYouTitle;
    public boolean isTheTitleTheSame(String title){
        getWait().until(ExpectedConditions.visibilityOf(thankYouTitle));
        return thankYouTitle.isDisplayed() && thankYouTitle.getText().equals(title);
    }
}
