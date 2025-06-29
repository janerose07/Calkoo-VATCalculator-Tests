package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.WebDriverManager;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        System.out.println("Starting scenario: " + scenario.getName());
        WebDriverManager.initializeDriver(); // No parameter needed now
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("Finished scenario: " + scenario.getName());
        WebDriverManager.quitDriver();
    }
}