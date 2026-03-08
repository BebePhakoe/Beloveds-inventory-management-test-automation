package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InventoryPage {

    WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By selectColorDropdown = By.xpath("//select[@data-testid='color-select']");
    By blueOption = By.xpath("//option[@value='blue']");

    // Step 6: Select Phone
    public void selectPhone() {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='deviceType']")));
        dropdown.selectByVisibleText("Phone");
    }

    // Check if Brand is enabled
    public boolean brandIsEnabled() {
        return driver.findElement(By.id("brand")).isEnabled();
    }

    // Step 7:Select Apple
    public void selectApple() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement brandElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("brand")));
        Select dropdown = new Select(brandElement);
        dropdown.selectByVisibleText("Apple");
    }

    // Step 8:Click 128GB
    public void click128GB() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement storageRadio = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='storage-128GB']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", storageRadio);

        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    // Step 9:Select Blue color
    public void selectBlueColor() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(selectColorDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(blueOption)).click();
    }

    // Step 10:Set Quantity to two
    public void setQuantityToTwo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement quantityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='number']")));
        quantityInput.clear();
        quantityInput.sendKeys("2");
        ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('change'))", quantityInput);
    }

    // Step 11:Input address and click next
    public void enterAddressAndClickNext(String address) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addressField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Enter address']")));
        addressField.clear();
        addressField.sendKeys(address);

        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Next']")));
        nextButton.click();
    }
} // <-- closing brace for InventoryPage class