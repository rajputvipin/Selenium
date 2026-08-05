package day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SleepCommand {

	public static void main(String[] args) throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		Thread.sleep(5000); // it will pause the execution for the provided time
		//We will not get NoSuchElementException incase of using sleep command as it will pause the execution and the page will be loaded fully and element will be found 
		//But without it the next command will execute and since the page was not fully loaded , selenium will not be able to detect the placeholder.
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
	}
}


//We will notice two kind of exceptions 
// 1. NoSuchElementException - When we have correct locator but synchronization problem is there that is element is not present on the page
// 2. ElementNotFoundException - We will get it when locator is not correct
