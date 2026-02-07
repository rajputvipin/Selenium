package day7;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		
		//get(url) - opens the url on the browser
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000); //wait method to maintain synchronisation i.e. slow loading of webpage
		
		//getTitle() - return the title of the web page
		System.out.println(driver.getTitle());
		
		//getCurrentUrl() - return url of the current page
		System.out.println(driver.getCurrentUrl());
		
		//getPageSource() - returns source code of the page
		System.out.println(driver.getPageSource());
		
		//getWindowHandle() - return the ID of single browser window
		System.out.println(driver.getWindowHandle());
		
		//This window ID is not constant as it keeps changing whenever we will run the browser , it is dynamic in nature and created at run time of the browser.
		
		//getWindowHandles() - return ID of multiple browser window
		driver.findElement(By.linkText("OrangeHRM,Inc")).click(); //this will opens new browser window.
		
		Set<String> windowID=driver.getWindowHandles();
		
		//extracting/printing both window ids from set collection
		System.out.println(windowID);
		
		
	}
}
