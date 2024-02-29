package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseStep {
    @Before()
    public void before(){
        initialize();
    }
    @After()
    public void after(){
        quit();
    }
}
