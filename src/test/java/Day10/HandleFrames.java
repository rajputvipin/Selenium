```java
package Day10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames {

    public static void main(String[] args) {

        // ============================================================
        // 1. Launch Browser
        // ============================================================

        WebDriver driver = new ChromeDriver();

        // Implicit wait:
        // Selenium will wait up to 10 seconds while locating elements.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open application
        driver.get("https://ui.vision/demo/webtest/frames/");

        // Maximize browser window
        driver.manage().window().maximize();


        // ============================================================
        // WHAT IS A FRAME / IFRAME?
        // ============================================================

        /*
         * A frame or iframe is an HTML document embedded inside another
         * HTML document.
         *
         * Selenium cannot directly interact with elements inside a frame
         * while the driver is still focused on the main page.
         *
         * Therefore, we must first switch Selenium's focus to the frame.
         *
         * Syntax:
         *
         * driver.switchTo().frame(frameElement);
         *
         * Selenium provides three common ways to switch to a frame:
         *
         * 1. Using frame index
         *      driver.switchTo().frame(0);
         *
         * 2. Using frame WebElement
         *      driver.switchTo().frame(frameElement);
         *
         * 3. Using frame name or ID
         *      driver.switchTo().frame("frameName");
         *
         * Using WebElement is generally preferred when the frame can be
         * located reliably using XPath/CSS.
         */


        // ============================================================
        // FRAME 1
        // ============================================================

        // Locate Frame 1 as a WebElement
        WebElement frame1 = driver.findElement(
                By.xpath("//frame[@src='frame_1.html']")
        );

        // Switch Selenium's focus from the main page to Frame 1
        driver.switchTo().frame(frame1);

        /*
         * Now Selenium's current context is Frame 1.
         *
         * Any element searched using driver.findElement() will now be
         * searched inside Frame 1.
         *
         * Example:
         *
         * driver.findElement(By.xpath("//input")).sendKeys("Test");
         */


        // ------------------------------------------------------------
        // Return from Frame 1 to the MAIN PAGE
        // ------------------------------------------------------------

        /*
         * defaultContent() moves Selenium directly back to the
         * top-level/main HTML document.
         */
        driver.switchTo().defaultContent();


        // ============================================================
        // FRAME 2
        // ============================================================

        // Locate Frame 2
        WebElement frame2 = driver.findElement(
                By.xpath("//frame[@src='frame_2.html']")
        );

        // Switch to Frame 2
        driver.switchTo().frame(frame2);

        // Locate textbox inside Frame 2 and enter text
        driver.findElement(
                By.xpath("//input[@name='mytext2']")
        ).sendKeys("selenium");


        // ------------------------------------------------------------
        // Important:
        // We are currently inside Frame 2.
        // To access another top-level frame, first return to main page.
        // ------------------------------------------------------------

        driver.switchTo().defaultContent();


        // ============================================================
        // FRAME 3
        // ============================================================

        // Locate Frame 3
        WebElement frame3 = driver.findElement(
                By.xpath("//frame[@src='frame_3.html']")
        );

        // Switch to Frame 3
        driver.switchTo().frame(frame3);

        // Enter text into textbox inside Frame 3
        driver.findElement(
                By.xpath("//input[@name='mytext3']")
        ).sendKeys("JAVA");


        // ============================================================
        // INNER IFRAME
        // ============================================================

        /*
         * Frame 3 contains an INNER IFRAME.
         *
         * This creates a nested frame structure:
         *
         * Main Page
         *     |
         *     +---- Frame 3
         *              |
         *              +---- Inner IFrame
         *
         * To access the inner iframe:
         *
         * Step 1: Switch to Frame 3
         * Step 2: Locate/switch to the inner iframe
         *
         * We are already inside Frame 3 at this point.
         */


        // ------------------------------------------------------------
        // Switch to Inner IFrame using index
        // ------------------------------------------------------------

        /*
         * frame(0) means the first frame/iframe inside the current
         * frame context.
         *
         * IMPORTANT:
         * The index is relative to the CURRENT frame.
         */
        driver.switchTo().frame(0);


        // ============================================================
        // INTERACT WITH ELEMENT INSIDE INNER IFRAME
        // ============================================================

        /*
         * Example:
         * The following XPath identifies a radio button inside the
         * Google Form contained in the iframe.
         */

        WebElement rdbutton = driver.findElement(
                By.xpath("//div[@id='i8']//div[@class='AB7Lab Id5V1']")
        );

        // Normal Selenium click
        rdbutton.click();


        // ============================================================
        // JAVASCRIPT EXECUTOR
        // ============================================================

        /*
         * JavascriptExecutor allows Selenium to execute JavaScript
         * directly in the browser.
         *
         * Syntax:
         *
         * JavascriptExecutor js = (JavascriptExecutor) driver;
         *
         * js.executeScript("JavaScript code", arguments);
         *
         * JavaScriptExecutor can be useful when:
         *
         * - Normal Selenium click does not work
         * - An element is hidden/overlapped
         * - We need to scroll the page
         * - We need to execute JavaScript in the browser
         *
         * IMPORTANT:
         * Normal Selenium methods should generally be preferred.
         * JavaScript should be used when there is a genuine need.
         */


        // Create JavascriptExecutor object
        JavascriptExecutor js = (JavascriptExecutor) driver;

        /*
         * JavaScript click:
         *
         * arguments[0] represents the WebElement passed as the second
         * argument to executeScript().
         */
        js.executeScript("arguments[0].click();", rdbutton);


        // ============================================================
        // JAVASCRIPT SCROLL EXAMPLE
        // ============================================================

        /*
         * Scroll the page until the specified element is visible.
         *
         * Example:
         *
         * js.executeScript(
         *     "arguments[0].scrollIntoView(true);",
         *     rdbutton
         * );
         */


        // ============================================================
        // PARENT FRAME
        // ============================================================

        /*
         * parentFrame() moves Selenium one level UP in the frame
         * hierarchy.
         *
         * Current structure:
         *
         * Main Page
         *     |
         *     +---- Frame 3
         *              |
         *              +---- Inner IFrame  <-- CURRENT
         *
         * After parentFrame():
         *
         * Main Page
         *     |
         *     +---- Frame 3  <-- CURRENT
         *
         * Use parentFrame() when you want to move only one level up.
         */

        driver.switchTo().parentFrame();


        // ============================================================
        // DEFAULT CONTENT
        // ============================================================

        /*
         * defaultContent() takes Selenium directly back to the
         * MAIN / TOP-LEVEL PAGE.
         *
         * Example:
         *
         * Main Page
         *     |
         *     +---- Frame 3
         *              |
         *              +---- Inner IFrame
         *
         * defaultContent() returns to:
         *
         * Main Page  <-- CURRENT
         */

        driver.switchTo().defaultContent();


        // ============================================================
        // DIFFERENCE BETWEEN parentFrame() AND defaultContent()
        // ============================================================

        /*
         * parentFrame()
         * ----------------
         * Moves one level up.
         *
         * Example:
         *
         * Main -> Frame 3 -> Inner IFrame
         *
         * parentFrame()
         *
         * Main -> Frame 3
         *
         *
         * defaultContent()
         * ----------------
         * Moves directly to the main/top-level page.
         *
         * Example:
         *
         * Main -> Frame 3 -> Inner IFrame
         *
         * defaultContent()
         *
         * Main
         */


        // ============================================================
        // FRAME SWITCHING USING INDEX
        // ============================================================

        /*
         * You can switch to a frame using its index:
         *
         * driver.switchTo().frame(0);
         *
         * However, frame indexes can change when the HTML structure
         * changes. Therefore, using a WebElement is usually more
         * reliable.
         *
         * Example:
         *
         * WebElement frame =
         *     driver.findElement(By.xpath("//iframe"));
         *
         * driver.switchTo().frame(frame);
         */


        // ============================================================
        // FRAME SWITCHING USING NAME OR ID
        // ============================================================

        /*
         * If a frame has a name or ID:
         *
         * <iframe id="myFrame" name="myFrame"></iframe>
         *
         * We can use:
         *
         * driver.switchTo().frame("myFrame");
         *
         * This is another convenient way to switch to a frame.
         */


        // ============================================================
        // COMMON FRAME EXCEPTIONS
        // ============================================================

        /*
         * 1. NoSuchFrameException
         *
         *    Occurs when Selenium cannot find the frame or iframe
         *    you are trying to switch to.
         *
         *
         * 2. NoSuchElementException
         *
         *    Occurs when Selenium cannot find an element inside the
         *    current frame/page.
         *
         *
         * 3. StaleElementReferenceException
         *
         *    Occurs when the frame/element was found earlier but the
         *    DOM has changed and the reference is no longer valid.
         *
         *
         * 4. ElementClickInterceptedException
         *
         *    Occurs when another element is blocking the element
         *    you are trying to click.
         *
         *    In some situations JavaScript click can be used as an
         *    alternative, although fixing the underlying page/
         *    synchronization issue is preferable.
         */


        // ============================================================
        // IMPORTANT FRAME HANDLING RULE
        // ============================================================

        /*
         * Always remember:
         *
         * Main Page
         *    |
         *    +---- Frame 1
         *    |
         *    +---- Frame 2
         *    |
         *    +---- Frame 3
         *             |
         *             +---- Inner IFrame
         *
         * If you are inside Frame 2 and want to access Frame 3:
         *
         * 1. defaultContent()
         * 2. Locate Frame 3
         * 3. switchTo().frame(frame3)
         *
         * You cannot directly locate Frame 3 while Selenium is
         * still inside Frame 2.
         */


        // ============================================================
        // CLOSE BROWSER
        // ============================================================

        /*
         * close()
         * --------
         * Closes the current browser window.
         *
         * quit()
         * -------
         * Closes all browser windows opened by Selenium and ends
         * the WebDriver session.
         *
         * Prefer quit() at the end of a test/program.
         */

        driver.quit();
    }
}
```
