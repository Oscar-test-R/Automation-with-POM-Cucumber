package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/appFeatures", glue = {"stepDefinitions", "BaseTest"})
public class FlowsShoppingCart extends AbstractTestNGCucumberTests {

}
