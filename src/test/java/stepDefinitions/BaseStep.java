package stepDefinitions;

import dataProvider.DataProvider;
import io.cucumber.java.After;
import myDriver.MyDriver;
import org.testng.annotations.*;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.HashMap;

public class BaseStep {
    protected static MyDriver driver;
    protected static HomePage homePage;
    private String url = "https://www.saucedemo.com/";
    public void initialize() {
        driver = new MyDriver();
        driver.getDriver().manage().window().maximize();
        navigateTo();
    }
    public String navigateTo() {
        driver.getDriver().get(url);
        return url;
    }
    public LoginPage loadFirstPage(){
        return new LoginPage(driver.getDriver());
    }
    public void quit (){
       driver.getDriver().quit();
   }
   public HashMap getData(){
   HashMap<String ,String> hashMap = DataProvider.data();
   return hashMap;
   }
}
