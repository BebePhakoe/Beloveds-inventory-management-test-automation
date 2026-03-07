package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class InvoicePage {
    private static WebDriver driver;
    private static WebDriverWait wait = null;

    // Locators based on the "Order Successful" popup
    private static final By successToast = By.xpath("//h2[contains(text(), 'ORDER SUCCESSFUL')]");
    private final By successMessage = By.xpath("//p[contains(text(), 'your order was purchased successfully')]");
    private static final By viewInvoiceButton = By.xpath("//button[normalize-space()='View Invoice']");

    public InvoicePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static boolean isOrderSuccessful() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(successToast)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public static void clickViewInvoice() {
        // 1. Wait for the button to be present
        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(viewInvoiceButton));

        // 2. Scroll it into the center of the screen (not just the top)
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", button);

        // 3. Move the real mouse cursor to the element first
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
        actions.moveToElement(button).perform();

        try {
            // 4. Try a "Native" click
            button.click();
        } catch (Exception e) {
            // 5. Hard Force: JavaScript click if native fails
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        }
    }
        }

