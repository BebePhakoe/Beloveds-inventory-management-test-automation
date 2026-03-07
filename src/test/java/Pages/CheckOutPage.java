package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckOutPage {

    private WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By expressShipping = By.xpath("//label[contains(., 'Express')]");
    private final By oneYearWarranty = By.xpath("//label[contains(., '1 Year')]");
    private final By discountField = By.xpath("//input[@data-testid='discount-code']"); // changed from CSS to XPath
    private final By applyButton = By.xpath("//button[text()='Apply']");
    private final By confirmPurchaseButton = By.xpath("//button[contains(text(), 'Confirm Purchase')]");

    // Constructor
    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Select shipping and warranty extras
    public void selectExtras() {
        wait.until(ExpectedConditions.elementToBeClickable(expressShipping)).click();
        wait.until(ExpectedConditions.elementToBeClickable(oneYearWarranty)).click();
    }

    // Apply discount code (works with your loginTest call)
    public void applyDiscount(String code) {
        // Change this line to wait for the input field itself
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(discountField));
        input.clear();
        input.sendKeys(code);

        // Then click apply
        driver.findElement(By.xpath("//button[text()='Apply']")).click();
    }

    // Optional: fixed SAVE10 version if needed
    public void applyDiscount() {
        applyDiscount("SAVE10");
    }

    // Confirm purchase
    public void clickConfirmPurchase() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmPurchaseButton)).click();
    } // <-- removed trailing comma, fixes red errors
}