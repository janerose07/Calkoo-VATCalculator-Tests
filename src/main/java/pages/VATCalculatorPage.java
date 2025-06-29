package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WebDriverManager;

public class VATCalculatorPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "Country")
    private WebElement countryDropdown;

    @FindBy(id = "NetPrice")
    private WebElement netAmountField;

    @FindBy(id = "Price")
    private WebElement grossAmountField;

    @FindBy(id = "VATsum")
    private WebElement vatAmountField;

    @FindBy(xpath = "//a[contains(text()='Agree & Close')]")
    private WebElement consentAgree;

    @FindBy(xpath = "//button[@aria-label='Consent']")
    private WebElement consentButton;

    public VATCalculatorPage() {
        this.driver = WebDriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void navigateToVATCalculator() {
        driver.get(utils.ConfigReader.getBaseUrl());
        handleCookieConsent();
        wait.until(ExpectedConditions.visibilityOf(countryDropdown));
    }

    public void handleCookieConsent() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(consentAgree));
            consentAgree.click();
            wait.until(ExpectedConditions.elementToBeClickable(consentButton));
            consentButton.click();
        } catch (Exception e) {
            System.out.println("Cookie consent not found or already accepted.");
        }
    }

    public void selectCountry(String country) {
        wait.until(ExpectedConditions.elementToBeClickable(countryDropdown));
        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByVisibleText(country);
    }

    public void enterNetAmount(String amount) {
        wait.until(ExpectedConditions.elementToBeClickable(netAmountField));
        netAmountField.clear();
        netAmountField.sendKeys(amount);
    }

    public String getGrossAmount() {
        wait.until(ExpectedConditions.visibilityOf(grossAmountField));
        return grossAmountField.getAttribute("value");
    }

    public String getVATAmount() {
        wait.until(ExpectedConditions.visibilityOf(vatAmountField));
        return vatAmountField.getAttribute("value");
    }

    public List<String> getAvailableTaxRates() {
        List<WebElement> vatElements = driver.findElements(By.xpath("//input[@type='radio' and @name='VAT']"));
        List<String> vatRates = new ArrayList<>();
        for (WebElement element : vatElements) {
            vatRates.add(element.getAttribute("value"));
        }
        return vatRates;
    }
}