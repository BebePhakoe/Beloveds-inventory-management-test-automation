package Tests;

import Base.BaseTest;
import Pages.CheckOutPage;
import Pages.InventoryPage;
import Pages.InvoicePage;
import Pages.LearningMaterialsPage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class loginTest extends BaseTest { // extends BaseTest is required

    @Test
    public void verifyUserCanLogin() {
        // Step1: Navigate to the site
        driver.get("https://ndosisimplifiedautomation.vercel.app/");

        // Step2: Initialize LoginPage and perform login
        LoginPage login = new LoginPage(driver);
        login.loginToSite("Bibiphakoe@gmail.com", "B%%loved19");

        // Step3: Navigate to Learning Materials
        LearningMaterialsPage materials = new LearningMaterialsPage(driver);
        materials.navigateToAdvanceSection();
        System.out.println("Successfully navigated to Web Automation Advance!");
        materials.clickWebAutomationAdvance();

        // Step4: Verify the page title
        String pageTitle = driver.getTitle();
        System.out.println("Arrived at: " + pageTitle);

        // Step5: Initialize InventoryPage
        InventoryPage inventory = new InventoryPage(driver);

        // Step6: Select Phone and assert brand enabled
        inventory.selectPhone();
        Assert.assertTrue(inventory.brandIsEnabled(), "Brand dropdown should be enabled");

        // Step7: Select Apple
        inventory.selectApple();

        // Step8: Click 128GB
        inventory.click128GB();

        // Step9: Select Blue color
        inventory.selectBlueColor();

        // Step10: Set Quantity to 2
        inventory.setQuantityToTwo();
        System.out.println("Quantity set to 2 successfully!");

        // Step11: Enter address and click Next
        inventory.enterAddressAndClickNext("123 Test Street");
        System.out.println("Inventory and Address steps completed successfully!");

        //Step12: CheckOutPage steps added here
        CheckOutPage checkout = new CheckOutPage(driver);

        // Step13: Select shipping and warranty extras
        checkout.selectExtras();

        // Step14: Apply discount code
        checkout.applyDiscount("SAVE10");

        // Step15: Confirm purchase
        checkout.clickConfirmPurchase();
        System.out.println("Checkout flow completed successfully!");

        // Step16: Confirm purchase
        checkout.clickConfirmPurchase();

        // Step 17: Click View Invoice
        if (InvoicePage.isOrderSuccessful()) {
            System.out.println("Order was successful, clicking invoice...");

            // 3. Call the method to click the button
            InvoicePage.clickViewInvoice();
        } else {
            System.out.println("Order popup did not appear.");
        }
    }



    }

