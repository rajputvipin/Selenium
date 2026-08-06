package Day9;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {

    public static void main(String[] args) {

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Open the application
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // Maximize browser window
        driver.manage().window().maximize();

        // ==========================================================
        // 1) Handle Simple Alert (Only OK button)
        // ==========================================================

        // Click the button to display the Simple Alert
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

        // Switch WebDriver control from the webpage to the alert
        Alert simpleAlert = driver.switchTo().alert();

        // Capture the alert message
        String simpleAlertMsg = simpleAlert.getText();

        // Print the alert message
        System.out.println("Simple Alert Message: " + simpleAlertMsg);

        // Click the OK button
        simpleAlert.accept();

        // ==========================================================
        // 2) Handle Confirmation Alert (OK & Cancel buttons)
        // ==========================================================

        // Click the button to display the Confirmation Alert
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();

        // Switch to the confirmation alert
        Alert confirmationAlert = driver.switchTo().alert();

        // Capture and print the alert message
        System.out.println("Confirmation Alert Message: " + confirmationAlert.getText());

        // Click the OK button
        confirmationAlert.accept();

        // OR Click the Cancel button
        // confirmationAlert.dismiss();

        // ==========================================================
        // 3) Handle Prompt Alert (Input box + OK & Cancel buttons)
        // ==========================================================

        // Click the button to display the Prompt Alert
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

        // Switch to the Prompt Alert
        Alert promptAlert = driver.switchTo().alert();

        // Print the alert message
        System.out.println("Prompt Alert Message: " + promptAlert.getText());

        // Enter text into the input box
        promptAlert.sendKeys("Welcome");

        // Click the OK button
        promptAlert.accept();

        // OR Click the Cancel button
        // promptAlert.dismiss();

        // Close all browser windows
        driver.quit();

        /*
         * ==========================================================
         * Frequently Used Methods for Handling Alerts
         * ==========================================================
         *
         * switchTo().alert()
         * ------------------
         * Switches WebDriver control from the webpage
         * to the currently displayed JavaScript alert.
         * Returns an Alert object.
         *
         * accept()
         * --------
         * Clicks the "OK" or "Accept" button.
         * Used with:
         * - Simple Alert
         * - Confirmation Alert
         * - Prompt Alert
         *
         * dismiss()
         * ---------
         * Clicks the "Cancel" or "Dismiss" button.
         * Used with:
         * - Confirmation Alert
         * - Prompt Alert
         *
         * getText()
         * ---------
         * Returns the message displayed on the alert.
         *
         * sendKeys(String text)
         * ---------------------
         * Enters text into the input box of a Prompt Alert.
         * Applicable only for Prompt Alerts.
         *
         * ==========================================================
         * Types of JavaScript Alerts
         * ==========================================================
         *
         * 1. Simple Alert
         * ----------------
         * - Contains only an OK button.
         * - Methods used:
         *      getText()
         *      accept()
         *
         * 2. Confirmation Alert
         * ----------------------
         * - Contains OK and Cancel buttons.
         * - Methods used:
         *      getText()
         *      accept()
         *      dismiss()
         *
         * 3. Prompt Alert
         * ----------------
         * - Contains a textbox along with OK and Cancel buttons.
         * - Methods used:
         *      getText()
         *      sendKeys()
         *      accept()
         *      dismiss()
         *
         * ==========================================================
         * ExpectedConditions Used with Alerts
         * ==========================================================
         *
         * alertIsPresent()
         * ----------------
         * Waits until an alert is displayed before interacting with it.
         *
         * Example:
         *
         * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         * Alert alert = wait.until(ExpectedConditions.alertIsPresent());
         *
         * ==========================================================
         * Common Alert Operations
         * ==========================================================
         *
         * // Switch to alert
         * Alert alert = driver.switchTo().alert();
         *
         * // Read alert message
         * String msg = alert.getText();
         *
         * // Click OK
         * alert.accept();
         *
         * // Click Cancel
         * alert.dismiss();
         *
         * // Enter text into Prompt Alert
         * alert.sendKeys("Welcome");
         *
         * ==========================================================
         * Exceptions Related to Alerts
         * ==========================================================
         *
         * NoAlertPresentException
         * -----------------------
         * Occurs when Selenium tries to switch to an alert
         * but no alert is currently displayed.
         *
         * UnhandledAlertException
         * -----------------------
         * Occurs when Selenium tries to perform operations
         * on the webpage while an alert is still open.
         *
         * ==========================================================
         * Important Interview Points
         * ==========================================================
         *
         * 1. Alerts are JavaScript pop-ups and are not part of the HTML DOM.
         *
         * 2. Selenium cannot locate alerts using XPath, CSS Selector,
         *    ID, Name, Class Name, Tag Name, or Link Text.
         *
         * 3. Before performing any operation on an alert,
         *    driver.switchTo().alert() must be called.
         *
         * 4. Once accept() or dismiss() is executed,
         *    the alert is closed permanently.
         *
         * 5. After an alert is closed,
         *    calling switchTo().alert() again throws
         *    NoAlertPresentException.
         *
         * 6. Always call getText() before accept() or dismiss()
         *    if you need to read the alert message.
         *
         * 7. sendKeys() works only for Prompt Alerts.
         *
         * 8. alertIsPresent() is the preferred Explicit Wait
         *    condition for alerts.
         *
         * 9. Alerts block interaction with the webpage
         *    until they are accepted or dismissed.
         *
         * 10. Selenium supports only JavaScript alerts.
         *     Browser authentication pop-ups and OS-level dialogs
         *     require different handling techniques.
         *
         * ==========================================================
         * Best Practices
         * ==========================================================
         *
         * ✓ Use Explicit Wait (alertIsPresent()) instead of Thread.sleep().
         *
         * ✓ Store the Alert object if multiple operations
         *   (getText(), sendKeys(), accept(), dismiss()) are required.
         *
         * ✓ Read the alert text before closing the alert.
         *
         * ✓ Perform only ONE action:
         *      accept() OR dismiss()
         *   because the alert no longer exists afterward.
         *
         * ✓ Use accept() when you want to proceed.
         *
         * ✓ Use dismiss() when you want to cancel the operation.
         *
         * ==========================================================
         * Commonly Used Classes
         * ==========================================================
         *
         * Alert
         * -----
         * Represents a JavaScript alert.
         *
         * WebDriver
         * ---------
         * Controls the browser.
         *
         * By
         * --
         * Used to locate the button that opens the alert.
         *
         * WebDriverWait
         * -------------
         * Used for Explicit Waits.
         *
         * ExpectedConditions
         * ------------------
         * Provides predefined waiting conditions such as
         * alertIsPresent().
         *
         * ==========================================================
         * Easy Formula
         * ==========================================================
         *
         * Alert alert = driver.switchTo().alert();
         *
         * String text = alert.getText();
         *
         * alert.accept();          // Click OK
         *
         * alert.dismiss();         // Click Cancel
         *
         * alert.sendKeys("Text");  // Prompt Alert only
         *
         * Explicit Wait:
         *
         * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         * Alert alert = wait.until(ExpectedConditions.alertIsPresent());
         *
         * ==========================================================
         */
    }
}