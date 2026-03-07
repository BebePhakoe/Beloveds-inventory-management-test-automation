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
        // 1️⃣ Navigate to the site
        driver.get("https://ndosisimplifiedautomation.vercel.app/");

        // 2️⃣ Initialize LoginPage and perform login
        LoginPage login = new LoginPage(driver);
        login.loginToSite("Bibiphakoe@gmail.com", "B%%loved19");

        // 3️⃣ Navigate to Learning Materials
        LearningMaterialsPage materials = new LearningMaterialsPage(driver);
        materials.navigateToAdvanceSection();
        System.out.println("Successfully navigated to Web Automation Advance!");
        materials.clickWebAutomationAdvance();

        // 4️⃣ Verify the page title
        String pageTitle = driver.getTitle();
        System.out.println("Arrived at: " + pageTitle);

        // 5️⃣ Initialize InventoryPage
        InventoryPage inventory = new InventoryPage(driver);

        // Step 3: Select Phone and assert brand enabled
        inventory.selectPhone();
        Assert.assertTrue(inventory.brandIsEnabled(), "Brand dropdown should be enabled");

        // Step 4: Select Apple
        inventory.selectApple();

        // Step 5: Click 128GB
        inventory.click128GB();

        // Step 6: Select Blue color
        inventory.selectBlueColor();

        // Step 7: Set Quantity to 2
        inventory.setQuantityToTwo();
        System.out.println("Quantity set to 2 successfully!");

        // Step 8: Enter address and click Next
        inventory.enterAddressAndClickNext("123 Test Street");
        System.out.println("Inventory and Address steps completed successfully!");

        // ✅ NEW: CheckOutPage steps added here
        CheckOutPage checkout = new CheckOutPage(driver);

        // Select shipping and warranty extras
        checkout.selectExtras();

        // Step9: Apply discount code
        checkout.applyDiscount("SAVE10");

        // Step10: Confirm purchase
        checkout.clickConfirmPurchase();
        System.out.println("Checkout flow completed successfully!");

        // Step11: Confirm purchase
        checkout.clickConfirmPurchase();

        // Step 12: Click View Invoice
        if (InvoicePage.isOrderSuccessful()) {
            System.out.println("Order was successful, clicking invoice...");

            // 3. Call the method to click the button
            InvoicePage.clickViewInvoice();
        } else {
            System.out.println("Order popup did not appear.");
        }
    }



    }

