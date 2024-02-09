package tests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import myDriver.MyDriver;
import org.testng.annotations.*;
import pages.LoginPage;

public class BaseTest {
    protected MyDriver driver;
    private String url = "https://www.saucedemo.com/";
    @BeforeMethod
    public void beforeMethod() {
        driver = new MyDriver();
        driver.getDriver().manage().window().maximize();
        navigateTo();
        //driver.getDriver().get(url);
    }
    public String navigateTo() {
        driver.getDriver().get(url);
        return url;
    }
    public LoginPage loadFirstPage(){
        return new LoginPage(driver.getDriver());
    }
   @AfterMethod
   public void afterMethod (){
       driver.getDriver().quit();
   }
    @DataProvider(name = "data")
    public Object[][] loginData(){
        return new Object[][]{
                {"standard_user", "secret_sauce"}
        };
    }
}
