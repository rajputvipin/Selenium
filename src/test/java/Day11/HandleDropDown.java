package Day11;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropDown {

    public static void main(String[] args)
            throws NoSuchElementException, InterruptedException {

        // ============================================================
        // BROWSER SETUP
        // ============================================================

        WebDriver driver = new ChromeDriver();

        // Implicit wait
        // Selenium will wait up to 10 seconds when trying to locate
        // an element.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();


        // ============================================================
        // 1. SELECT DROPDOWN
        // ============================================================

        /*
         * A standard HTML dropdown is created using the <select> tag.
         *
         * Example HTML:
         *
         * <select id="country">
         *     <option value="india">India</option>
         *     <option value="japan">Japan</option>
         *     <option value="usa">USA</option>
         * </select>
         *
         * Selenium provides the Select class to handle standard
         * <select> dropdowns.
         *
         * IMPORTANT:
         * Select class works ONLY when the dropdown is implemented
         * using the HTML <select> tag.
         */

        /*
        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement drpCountryEle = driver.findElement(
                By.xpath("//select[@id='country']")
        );

        // Create Select object
        Select drpCountry = new Select(drpCountryEle);


        // ============================================================
        // SELECT BY VISIBLE TEXT
        // ============================================================

        /*
         * Selects the option based on the text visible to the user.
         *
         * Example:
         *
         * <option value="india">India</option>
         *
         * Code:
         *
         * drpCountry.selectByVisibleText("India");
         */

        // drpCountry.selectByVisibleText("India");


        // ============================================================
        // SELECT BY VALUE
        // ============================================================

        /*
         * Selects the option using the value attribute.
         *
         * Example:
         *
         * <option value="japan">Japan</option>
         *
         * Code:
         *
         * drpCountry.selectByValue("japan");
         */

        // drpCountry.selectByValue("japan");


        // ============================================================
        // SELECT BY INDEX
        // ============================================================

        /*
         * Selects an option based on its index.
         *
         * Index starts from 0.
         *
         * Example:
         *
         * 0 -> India
         * 1 -> Japan
         * 2 -> USA
         *
         * Code:
         *
         * drpCountry.selectByIndex(2);
         */

        // drpCountry.selectByIndex(2);


        // ============================================================
        // GET ALL OPTIONS
        // ============================================================

        /*
         * getOptions()
         *
         * Returns all options from the dropdown as a List<WebElement>.
         */

        List<WebElement> options = drpCountry.getOptions();

        System.out.println(
                "Number of options in dropdown: " + options.size()
        );


        // ============================================================
        // PRINT ALL OPTIONS - NORMAL FOR LOOP
        // ============================================================

        for (int i = 0; i < options.size(); i++) {

            System.out.println(
                    "Option " + i + " : " + options.get(i).getText()
            );
        }


        // ============================================================
        // PRINT ALL OPTIONS - ENHANCED FOR LOOP
        // ============================================================

        /*
         * Enhanced for loop is generally easier to read.
         */

        for (WebElement opt : options) {

            System.out.println(opt.getText());
        }


        // ============================================================
        // GET SELECTED OPTION
        // ============================================================

        /*
         * getFirstSelectedOption()
         *
         * Returns the currently selected option.
         */

        WebElement selectedOption =
                drpCountry.getFirstSelectedOption();

        System.out.println(
                "Selected option: " + selectedOption.getText()
        );


        // ============================================================
        // CHECK WHETHER MULTIPLE OPTIONS CAN BE SELECTED
        // ============================================================

        /*
         * isMultiple()
         *
         * Returns true if multiple options can be selected.
         */

        System.out.println(
                "Is dropdown multiple select? "
                        + drpCountry.isMultiple()
        );
        */


        // ============================================================
        // 2. BOOTSTRAP DROPDOWN
        // ============================================================

        /*
         * Bootstrap/custom dropdowns are NOT necessarily created
         * using the <select> tag.
         *
         * Therefore:
         *
         * Select drp = new Select(element);
         *
         * should NOT be used for these dropdowns.
         *
         * Instead:
         *
         * 1. Click the dropdown
         * 2. Locate the options
         * 3. Click the required option
         *
         * Example:
         */

        /*
        driver.get(
            "https://www.jquery-az.com/boots/demo.php?ex=63.0_2"
        );

        // Open Bootstrap dropdown
        driver.findElement(
                By.xpath("//button[contains(@class,'multiselect')]")
        ).click();


        // ============================================================
        // SELECT SINGLE OPTION
        // ============================================================

        // Select JAVA
        driver.findElement(
                By.xpath("//input[@value='JAVA']")
        ).click();


        // ============================================================
        // CAPTURE ALL OPTIONS
        // ============================================================

        List<WebElement> options =
                driver.findElements(
                    By.xpath(
                        "//ul[contains(@class,'multiselect')]//label"
                    )
                );

        System.out.println(
                "Number of options: " + options.size()
        );


        // Print all options
        for (WebElement op : options) {

            System.out.println(op.getText());
        }


        // ============================================================
        // SELECT MULTIPLE OPTIONS
        // ============================================================

        /*
         * Since this is a multi-select dropdown, we can select
         * multiple values.
         */

        for (WebElement op : options) {

            String optionText = op.getText();

            if (optionText.equals("JAVA")
                    || optionText.equals("MySQL")) {

                op.click();
            }
        }
        */


        // ============================================================
        // 3. CUSTOM / HIDDEN DROPDOWN
        // ============================================================

        /*
         * Some modern web applications do not use the <select> tag
         * for dropdowns.
         *
         * Examples:
         *
         * - React dropdowns
         * - Angular dropdowns
         * - Bootstrap dropdowns
         * - Material UI dropdowns
         * - OrangeHRM custom dropdowns
         *
         * These are often called:
         *
         * Custom Dropdown
         * Hidden Dropdown
         * Non-select Dropdown
         *
         * For these dropdowns, the Select class cannot be used.
         */


        // Open OrangeHRM
        driver.get(
                "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"
        );


        // ============================================================
        // LOGIN
        // ============================================================

        driver.findElement(
                By.name("username")
        ).sendKeys("Admin");

        driver.findElement(
                By.name("password")
        ).sendKeys("admin123");

        driver.findElement(
                By.xpath("//button[normalize-space()='Login']")
        ).click();


        // ============================================================
        // OPEN PIM
        // ============================================================

        driver.findElement(
                By.xpath("//a[normalize-space()='PIM']")
        ).click();


        // ============================================================
        // OPEN JOB TITLE DROPDOWN
        // ============================================================

        /*
         * This is a custom dropdown.
         *
         * We cannot use:
         *
         * Select select = new Select(element);
         *
         * because it is not a standard <select> element.
         *
         * Instead, first click the dropdown.
         */

        driver.findElement(
                By.xpath(
                    "//div[@class='oxd-table-filter-area']"
                    + "//div[contains(@class,'oxd-select-text-input')]"
                )
        ).click();


        // ============================================================
        // FIND ALL DROPDOWN OPTIONS
        // ============================================================

        /*
         * The dropdown options are displayed inside a listbox.
         *
         * role='listbox'
         *
         * is an ARIA attribute commonly used for dropdown lists.
         *
         * Each option can be located using:
         *
         * //div[@role='listbox']//span
         */

        List<WebElement> options =
                driver.findElements(
                    By.xpath("//div[@role='listbox']//span")
                );


        // ============================================================
        // COUNT OPTIONS
        // ============================================================

        System.out.println(
                "Number of dropdown options: " + options.size()
        );


        // ============================================================
        // PRINT ALL OPTIONS
        // ============================================================

        for (WebElement op : options) {

            System.out.println(
                    "Option: " + op.getText()
            );
        }


        // ============================================================
        // SELECT A SINGLE OPTION
        // ============================================================

        /*
         * We can select an option using its visible text.
         *
         * normalize-space() removes unwanted leading/trailing
         * whitespace from the text.
         */

        driver.findElement(
                By.xpath(
                    "//div[@role='listbox']//span"
                    + "[normalize-space()='Financial Analyst']"
                )
        ).click();


        // ============================================================
        // ANOTHER WAY TO SELECT OPTION
        // ============================================================

        /*
         * Instead of directly locating the option, we can loop
         * through all options.
         *
         * This approach is useful when we want to perform additional
         * conditions before selecting an option.
         */

        /*
        // Open dropdown again
        driver.findElement(
                By.xpath(
                    "//div[contains(@class,'oxd-select-text-input')]"
                )
        ).click();

        List<WebElement> jobTitles =
                driver.findElements(
                    By.xpath("//div[@role='listbox']//span")
                );

        for (WebElement op : jobTitles) {

            if (op.getText().trim().equals("Financial Analyst")) {

                op.click();
                break;
            }
        }
        */


        // ============================================================
        // findElement() vs findElements()
        // ============================================================

        /*
         * findElement()
         * -------------
         *
         * Returns a SINGLE WebElement.
         *
         * Example:
         *
         * WebElement element =
         *     driver.findElement(By.id("username"));
         *
         * If the element is not found, Selenium throws:
         *
         * NoSuchElementException
         *
         *
         * findElements()
         * --------------
         *
         * Returns a List<WebElement>.
         *
         * Example:
         *
         * List<WebElement> elements =
         *     driver.findElements(By.tagName("option"));
         *
         * If no elements are found, it returns an EMPTY LIST.
         *
         * It does NOT throw NoSuchElementException.
         */


        // ============================================================
        // CHECK WHETHER OPTIONS ARE AVAILABLE
        // ============================================================

        /*
         * We can check the size before processing the list.
         */

        if (options.size() > 0) {

            System.out.println(
                    "Dropdown contains options."
            );

        } else {

            System.out.println(
                    "Dropdown does not contain any options."
            );
        }


        // ============================================================
        // THREAD.SLEEP()
        // ============================================================

        /*
         * Thread.sleep(5000);
         *
         * This pauses the Java program for exactly 5 seconds.
         *
         * It is generally NOT recommended in Selenium automation
         * because it waits for the complete duration even if the
         * element becomes available earlier.
         *
         * Better approaches:
         *
         * - Implicit Wait
         * - Explicit Wait
         * - Fluent Wait
         *
         * Example of explicit wait:
         *
         * WebDriverWait wait =
         *     new WebDriverWait(driver, Duration.ofSeconds(10));
         *
         * WebElement option = wait.until(
         *     ExpectedConditions.visibilityOfElementLocated(
         *         By.xpath("//span[normalize-space()='Financial Analyst']")
         *     )
         * );
         */


        // ============================================================
        // normalize-space()
        // ============================================================

        /*
         * XPath:
         *
         * //span[normalize-space()='Financial Analyst']
         *
         * normalize-space() removes unnecessary spaces.
         *
         * It is useful when the HTML contains:
         *
         * <span>   Financial Analyst   </span>
         *
         * instead of:
         *
         * <span>Financial Analyst</span>
         */


        // ============================================================
        // IMPORTANT INTERVIEW QUESTIONS
        // ============================================================

        /*
         * Q1. Which class is used to handle standard dropdowns?
         *
         * Answer:
         * Select class.
         *
         *
         * Q2. When can Select class be used?
         *
         * Answer:
         * Only when the dropdown is implemented using the
         * HTML <select> tag.
         *
         *
         * Q3. What are the three methods used to select options?
         *
         * Answer:
         *
         * selectByVisibleText()
         * selectByValue()
         * selectByIndex()
         *
         *
         * Q4. How do you get all options?
         *
         * Answer:
         *
         * getOptions()
         *
         *
         * Q5. How do you handle a custom dropdown?
         *
         * Answer:
         *
         * Click the dropdown and locate the individual options
         * using Selenium locators such as XPath or CSS.
         *
         *
         * Q6. Difference between findElement() and findElements()?
         *
         * Answer:
         *
         * findElement() returns one WebElement and throws
         * NoSuchElementException if it cannot find the element.
         *
         * findElements() returns a List<WebElement> and returns
         * an empty list if no matching elements are found.
         *
         *
         * Q7. Can Select class handle Bootstrap dropdowns?
         *
         * Answer:
         * No, unless the Bootstrap dropdown is actually implemented
         * using the HTML <select> element.
         *
         *
         * Q8. What is the difference between visible text and value?
         *
         * Example:
         *
         * <option value="india">India</option>
         *
         * "India" = visible text
         * "india" = value
         */


        // ============================================================
        // CLOSE BROWSER
        // ============================================================

        /*
         * quit() closes all browser windows opened by WebDriver
         * and ends the WebDriver session.
         */

        driver.quit();
    }
}
