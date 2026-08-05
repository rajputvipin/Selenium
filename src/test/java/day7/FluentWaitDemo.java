package day7;

// Imports Duration class to specify wait time
import java.time.Duration;

// Imports Function interface used by Fluent Wait
import java.util.function.Function;

// Selenium locator class
import org.openqa.selenium.By;

// Exception to ignore while waiting
import org.openqa.selenium.NoSuchElementException;

// Selenium WebDriver interface
import org.openqa.selenium.WebDriver;

// Represents a web element (textbox, button, etc.)
import org.openqa.selenium.WebElement;

// Chrome browser driver
import org.openqa.selenium.chrome.ChromeDriver;

// FluentWait class
import org.openqa.selenium.support.ui.FluentWait;

// Wait interface
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitDemo {

    public static void main(String[] args) {

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Create Fluent Wait object
        Wait<WebDriver> mywait = new FluentWait<>(driver)

                // Maximum time Selenium will wait
                .withTimeout(Duration.ofSeconds(30))

                // Check for the element every 5 seconds
                .pollingEvery(Duration.ofSeconds(5))

                // Ignore NoSuchElementException while waiting
                .ignoring(NoSuchElementException.class);

        // Maximize browser window
        driver.manage().window().maximize();

        // Open OrangeHRM login page
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Apply Fluent Wait on Username textbox
        WebElement txtUsername = mywait.until(new Function<WebDriver, WebElement>() {

            // This method is called repeatedly every 5 seconds
            @Override
            public WebElement apply(WebDriver driver) {

                // Try to locate the Username textbox
                // If not found, Fluent Wait waits and retries
                return driver.findElement(By.xpath("//input[@placeholder='Username']"));
            }
        });

        // Type "Admin" into the Username textbox
        txtUsername.sendKeys("Admin");

        // Close the browser
        driver.quit();

        /*
         * ========================= PROGRAM FLOW =========================
         *
         * 1. Launch Chrome browser.
         * 2. Create a Fluent Wait object.
         *    - Maximum wait time = 30 seconds.
         *    - Polling interval = 5 seconds.
         *    - Ignore NoSuchElementException.
         * 3. Open the OrangeHRM login page.
         * 4. until() starts waiting for the Username textbox.
         * 5. apply() is executed immediately.
         * 6. If the textbox is found, it is returned and waiting stops.
         * 7. If not found, NoSuchElementException is ignored.
         * 8. Selenium waits for 5 seconds and tries again.
         * 9. This repeats until:
         *      - The element is found, OR
         *      - 30 seconds are completed (TimeoutException is thrown).
         * 10. Once found, "Admin" is entered into the textbox.
         * 11. Browser is closed.
         *
         * Easy Formula:
         * Fluent Wait = Maximum Wait Time + Polling Interval + Ignore Exceptions
         * ================================================================
         */
    }
}