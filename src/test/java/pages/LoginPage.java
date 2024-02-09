package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "user-name")
    private WebElement txtUserName;
    @FindBy(id = "password")
    private WebElement txtPassword;
    @FindBy(css = "input.submit-button")
    private WebElement loginButton;
    @FindBy(className = "login_logo")
    private WebElement titleLoginPage;
    public LoginPage typeCredentials (String userName, String password){
        waitElementBeClickable(txtUserName);
        txtUserName.sendKeys(userName);
        txtPassword.sendKeys(password);
        return this;
    }
    public HomePage clickLoginButton (){
        loginButton.click();
        return new HomePage(super.getDriver());
    }
    public String validateTitlePage (){
        getWait().until(ExpectedConditions.visibilityOf(titleLoginPage));
        return titleLoginPage.getText();
    }
}
