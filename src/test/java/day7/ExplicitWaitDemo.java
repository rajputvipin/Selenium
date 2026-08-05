package day7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		//Declaration of Explicit wait method
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));  
		//WebDriverWait is a selenium webdriver class having constructor named as WebDriverWait which requires two parameters (driver, duration)
		// Since declaration is not enough to apply it so we need to identify which element or statement is causing synchronization problem
		
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		WebElement txtusername = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']"))); //until is method
		txtusername.sendKeys("Admin");
		
		WebElement txtpassword = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
		txtpassword.sendKeys("admin123");
		//ExpectedConditions is a class
		// visibility is a method of ExpectedConditions class which will help in locating the elemnt which is not visible
		
		
		//driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");// here in this eg , this statement is causing the synchronization problem , so we need to apply explicit wait method here
		
		WebElement loginbtn = mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Login']")));
		loginbtn.click();
		
		
		
        // Conditions (ExpectedConditions)

        // 1. alertIsPresent()
        // Waits until an alert is present.

        // 2. visibilityOf(WebElement element)
        // Waits until the given WebElement is visible.

        // 3. visibilityOfElementLocated(By locator)
        // Waits until an element located by the locator is visible.

        // 4. presenceOfElementLocated(By locator)
        // Waits until an element is present in the DOM (may not be visible).

        // 5. elementToBeClickable(By locator)
        // Waits until the element is visible and clickable.

        // 6. elementToBeSelected(WebElement element)
        // Waits until the element is selected.

        // 7. elementSelectionStateToBe(WebElement element, boolean selected)
        // Waits until the element reaches the specified selection state.

        // 8. invisibilityOf(WebElement element)
        // Waits until the given element becomes invisible.

        // 9. invisibilityOfElementLocated(By locator)
        // Waits until the located element becomes invisible or is removed.

        // 10. textToBePresentInElement(WebElement element, String text)
        // Waits until the specified text appears in the element.

        // 11. textToBePresentInElementLocated(By locator, String text)
        // Waits until the specified text appears in the located element.

        // 12. textToBePresentInElementValue(By locator, String text)
        // Waits until the specified text appears in the value attribute.

        // 13. titleIs(String title)
        // Waits until the page title exactly matches the given title.

        // 14. titleContains(String title)
        // Waits until the page title contains the given text.

        // 15. urlToBe(String url)
        // Waits until the current URL exactly matches the given URL.

        // 16. urlContains(String fraction)
        // Waits until the current URL contains the specified text.

        // 17. urlMatches(String regex)
        // Waits until the current URL matches the given regular expression.

        // 18. frameToBeAvailableAndSwitchToIt(By locator)
        // Waits until a frame is available and switches to it.

        // 19. numberOfWindowsToBe(int number)
        // Waits until the specified number of browser windows are open.

        // 20. visibilityOfAllElements(List<WebElement> elements)
        // Waits until all given elements are visible.

        // 21. visibilityOfAllElementsLocatedBy(By locator)
        // Waits until all elements located by the locator are visible.

        // 22. presenceOfAllElementsLocatedBy(By locator)
        // Waits until all matching elements are present in the DOM.

        // 23. stalenessOf(WebElement element)
        // Waits until the element is no longer attached to the DOM.
		
		
		// Advantages:
		/* 1) Conditional based
		 * 2) Finding Element is inclusive ( for some conditions)
		 * 3 It will wait for condition to be true, then consider the time
		 * 4) We need to write multiple statements for multiple elements.
		 */
		
	}
}
