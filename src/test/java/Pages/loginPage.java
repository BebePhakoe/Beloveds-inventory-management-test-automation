package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class loginPage {

    WebDriver driver;
    inventoryPage inventory = new inventoryPage(driver);
    @Test
    public void validateLoginPageElements() {

        driver = new ChromeDriver();
        driver.get("https://ndosisimplifiedautomation.vercel.app/");

    //login button
        driver.findElement(By.xpath("//button[span[text()='Login']]")).click();

    //email field
        driver.findElement(By.xpath("//*[@id='login-email']")).sendKeys("Bibiphakoe@gmail.com");

    //password field
        driver.findElement(By.xpath("//*[@id='login-password']")).sendKeys("B%%loved19");

    //Login submit button
        driver.findElement(By.xpath("//*[@id='login-submit']")).click();

        // Define the wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // Wait until the "Bibi" profile button is visible
        WebElement userProfile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='\uD83D\uDC64']")));

    // Verify that it is displayed
        Assert.assertTrue(userProfile.isDisplayed(), "Login failed: User profile 'Bibi' not found!");

    // Optional: Print a confirmation
        System.out.println("Login Successful: User " + userProfile.getText().trim() + " is logged in.");

    //Learning Drop Down
        driver.findElement(By.xpath("//span[contains(text(), 'Learn')]")).click();

    //Navigate to learning page
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Learning Materials')]")))
                .click();

    //click on Web Automation Advance
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Web Automation Advance']")))
                .click();







    }
}