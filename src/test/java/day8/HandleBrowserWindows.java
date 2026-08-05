package day8;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowserWindows {

    public static void main(String[] args) {

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Open OrangeHRM application
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Maximize browser window
        driver.manage().window().maximize();

        // Click on the "OrangeHRM, Inc" link (opens a new browser window/tab)
        driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();

        // Returns the IDs of all open browser windows/tabs
        // Return type is Set<String> because window IDs are unique
        Set<String> windowIds = driver.getWindowHandles();

        // Set does not support indexing (get()), so we cannot access
        // parent and child window IDs directly.

        // =========================
        // Approach 1: Convert Set to List
        // =========================

        // Convert Set into List so that we can access window IDs using index
        List<String> windowList = new ArrayList<>(windowIds);

        // First window ID (Parent window)
        String parentId = windowList.get(0);

        // Second window ID (Child window)
        String childId = windowList.get(1);

        // Switch to parent window
        driver.switchTo().window(parentId);

        // Switch to child window
        driver.switchTo().window(childId);

        // =========================
        // Approach 2: Using Loop
        // =========================

        // Loop through all window IDs
        for (String winId : windowIds) {

            // Switch to each window one by one
            driver.switchTo().window(winId);

            // Print the title of the current window
            System.out.println(driver.getTitle());
        }

        /*
         * Window Handle Methods
         *
         * getWindowHandle()
         * -----------------
         * Returns the ID of the current browser window.
         * Return type: String
         *
         * getWindowHandles()
         * ------------------
         * Returns the IDs of all open browser windows/tabs.
         * Return type: Set<String>
         *
         * switchTo().window(windowId)
         * ---------------------------
         * Switches WebDriver control to the specified browser window.
         */

        // Close all browser windows
        driver.quit();
    }
}