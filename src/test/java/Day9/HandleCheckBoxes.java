package Day9;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckBoxes {

    public static void main(String[] args) throws InterruptedException {

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Open the application
        driver.get("https://testautomationpractice.blogspot.com/");

        // Maximize browser window
        driver.manage().window().maximize();

        // ==========================================================
        // 1) Select a specific checkbox
        // ==========================================================

        // Select only the Sunday checkbox
        // driver.findElement(By.xpath("//input[@id='sunday']")).click();

        // ==========================================================
        // 2) Capture all checkboxes
        // ==========================================================

        // findElements() returns all matching checkboxes in the form of
        // List<WebElement>
        List<WebElement> checkboxes = driver.findElements(
                By.xpath("//input[@class='form-check-input' and @type='checkbox']"));

        // Print the total number of checkboxes
        System.out.println("Total Number of Checkboxes: " + checkboxes.size());

        // ==========================================================
        // 3) Select all checkboxes
        // ==========================================================

        /*
        // Using normal for loop
        for (int i = 0; i < checkboxes.size(); i++) {
            checkboxes.get(i).click();
        }
        */

        /*
        // Using enhanced for loop
        for (WebElement checkbox : checkboxes) {
            checkbox.click();
        }
        */

        // ==========================================================
        // 4) Select the last 3 checkboxes
        // Formula:
        // Starting Index = Total Checkboxes - Number of Checkboxes to Select
        // ==========================================================

        /*
        for (int i = checkboxes.size() - 3; i < checkboxes.size(); i++) {
            checkboxes.get(i).click();
        }
        */

        // ==========================================================
        // 5) Select the first 3 checkboxes
        // ==========================================================

        /*
        for (int i = 0; i < 3; i++) {
            checkboxes.get(i).click();
        }
        */

        // ==========================================================
        // 6) Select checkboxes in a given range
        // Example: Select checkboxes from index 2 to 4
        // ==========================================================

        /*
        for (int i = 2; i <= 4; i++) {
            checkboxes.get(i).click();
        }
        */

        // ==========================================================
        // 7) Unselect only the selected checkboxes
        // ==========================================================

        /*
        for (WebElement checkbox : checkboxes) {

            // Check whether the checkbox is already selected
            if (checkbox.isSelected()) {

                // Unselect the checkbox
                checkbox.click();
            }
        }
        */

        // Pause execution for 5 seconds
        Thread.sleep(5000);

        // Close all browser windows
        driver.quit();

        /*
         * ==========================================================
         * Frequently Used Methods for Handling Checkboxes
         * ==========================================================
         *
         * click()
         * -------
         * Selects or unselects a checkbox.
         *
         * isSelected()
         * ------------
         * Returns true if the checkbox is selected,
         * otherwise returns false.
         *
         * isDisplayed()
         * -------------
         * Returns true if the checkbox is visible on the webpage.
         *
         * isEnabled()
         * -----------
         * Returns true if the checkbox is enabled (clickable),
         * otherwise returns false.
         *
         * getText()
         * ---------
         * Returns the visible text of an element.
         * Note:
         * For checkboxes (<input>), this usually returns an empty string.
         * Use it on the associated <label> element instead.
         *
         * getAttribute("attributeName")
         * -----------------------------
         * Returns the value of the specified attribute.
         * Examples:
         * checkbox.getAttribute("id");
         * checkbox.getAttribute("value");
         * checkbox.getAttribute("type");
         * checkbox.getAttribute("checked");
         *
         * findElement(By locator)
         * -----------------------
         * Returns the first matching checkbox.
         * Throws NoSuchElementException if the element is not found.
         *
         * findElements(By locator)
         * ------------------------
         * Returns all matching checkboxes as List<WebElement>.
         * Returns an empty list if no elements are found.
         *
         * size()
         * ------
         * Returns the total number of checkboxes in the List.
         *
         * get(index)
         * ----------
         * Returns the checkbox present at the specified index.
         *
         * ==========================================================
         * Common Looping Techniques
         * ==========================================================
         *
         * // Select all checkboxes
         * for(WebElement checkbox : checkboxes)
         *
         * // Select first N checkboxes
         * for(int i = 0; i < N; i++)
         *
         * // Select last N checkboxes
         * for(int i = checkboxes.size() - N; i < checkboxes.size(); i++)
         *
         * // Select checkboxes within a range
         * for(int i = startIndex; i <= endIndex; i++)
         *
         * // Unselect only selected checkboxes
         * if(checkbox.isSelected())
         *
         * ==========================================================
         * Important Interview Points
         * ==========================================================
         *
         * 1. click() toggles the checkbox state.
         *
         * 2. isSelected() checks whether the checkbox is selected.
         *
         * 3. findElement() returns only one WebElement.
         *
         * 4. findElements() returns List<WebElement>.
         *
         * 5. findElement() throws NoSuchElementException if
         *    the element is not found.
         *
         * 6. findElements() never throws NoSuchElementException.
         *    It simply returns an empty List.
         *
         * 7. List<WebElement> is used when multiple checkboxes
         *    are present on the webpage.
         *
         * 8. WebElement is used when handling a single checkbox.
         *
         * 9. size() returns the total number of checkboxes
         *    available in the List.
         *
         * 10. isDisplayed() checks visibility,
         *     isEnabled() checks whether the checkbox can be clicked,
         *     and isSelected() checks whether it is currently selected.
         *
         * ==========================================================
         * Easy Formulas
         * ==========================================================
         *
         * First N Checkboxes:
         * for(int i = 0; i < N; i++)
         *
         * Last N Checkboxes:
         * for(int i = checkboxes.size() - N; i < checkboxes.size(); i++)
         *
         * Check Whether Checkbox is Selected:
         * if(checkbox.isSelected())
         *
         * ==========================================================
         */
    }
}