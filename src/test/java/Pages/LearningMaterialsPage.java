package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LearningMaterialsPage {
    WebDriver driver;
    WebDriverWait wait;

    public LearningMaterialsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Locators
    By userProfileName = By.xpath("//span[text()='bibi']");
    By learnDropdown = By.xpath("//span[text()='Learn']");
    By learningMaterialsOption = By.xpath("//span[text()='Learning Materials']");
    By webAutomationAdvanceHeader = By.xpath("//span[contains(text(),'Web Automation Advance')]");

    public void navigateToAdvanceSection() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userProfileName));

        // Now it's safe to interact with the dropdown
        wait.until(ExpectedConditions.elementToBeClickable(learnDropdown)).click();

        // 3. Click the 'Learning Materials' span
        wait.until(ExpectedConditions.visibilityOfElementLocated(learningMaterialsOption)).click();

        //  Wait for the 'Web Automation Advance' to be visible and clickable
        wait.until(ExpectedConditions.elementToBeClickable(webAutomationAdvanceHeader)).click();
    }

    public void clickWebAutomationAdvance() {
        // Scroll to the element if it's not in view
        WebElement webAutomationAdvanceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(webAutomationAdvanceHeader));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webAutomationAdvanceElement);

        // Click the element
        webAutomationAdvanceElement.click();
    }
}


