package stepDefinitions;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.VATCalculatorPage;

public class VATCalculatorSteps {
    
    private VATCalculatorPage vatCalculatorPage;
    
    public VATCalculatorSteps() {
        this.vatCalculatorPage = new VATCalculatorPage();
    }
    
    @Given("User navigate to the VAT calculator page")
    public void navigateToVATCaclculatorUrl() {
        vatCalculatorPage.navigateToVATCalculator();
    }
    
    @When("User selects {string} as the country")
    public void userSelectsCountry(String country) {
        vatCalculatorPage.selectCountry(country);
    }

    @Then("User should see {string} as available tax rates")
    public void availableTaxRateValidation(String expectedRates) {
        List<String> expected = Arrays.asList(expectedRates.split(","));
        List<String> actual = vatCalculatorPage.getAvailableTaxRates();
        Assert.assertTrue(actual.containsAll(expected));
    }

    
    @And("User enters {string} as the net amount")
    public void userEntersNetAmount(String amount) throws InterruptedException {
        vatCalculatorPage.enterNetAmount(amount);
    }
    
    
    @Then("the gross amount should be calculated as {string}")
    public void grossAmountCalculation(String expectedAmount) {
        String actualAmount = vatCalculatorPage.getGrossAmount();
        Assert.assertEquals(actualAmount, expectedAmount, 
            "Gross amount calculation is incorrect");
    }
    
    @And("the VAT amount should be calculated as {string}")
    public void vatAmountCalculation(String expectedAmount) {
        String actualAmount = vatCalculatorPage.getVATAmount();
        Assert.assertEquals(actualAmount, expectedAmount, 
            "VAT amount calculation is incorrect");
    }    
}