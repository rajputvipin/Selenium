package day2;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;


/*
  Test Case 
  ---------
  1) Launch browser(chrome)
  2) Open url https://demo.opencart.com/
  3) Validate title should be "Your Store"
  4) Close browser
 */
public class FirstTestCase {
	
	public static void main(String[] args) {
		// Creating test script for above test case
		//Steps:
		//1) Launch browser (chrome)
		// For Chrome browser we need to call ChromeDriver class and create its object here
		//ChromeDriver driver = new ChromeDriver(); //internally chormedriver constructor will automatically work after creation of object and will launch chrome browser automatically
		WebDriver driver = new ChromeDriver(); // Since Webdriver class is parent of ChromeDriver we can also use it in this way as it is upcasting only. It is more Preferrable as we can store other browser drivers too.
		
		//2) Opening url https://demo.opencart.com/
		
		driver.get("https://demo.opencart.com/"); // from the driver object we are calling get method here. Get method is predefined method and it will open the passed url.
	
		//3) Validate title should be "Your Store"
		
		// Before validating title we need to capture the actual title of the web page.
		String actual_title = driver.getTitle(); //it will store the actual title of the page.
		
		if(actual_title.equals("Your Store")) {
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed");
		}
		
		//4) Closing the browser
		driver.close();
		//driver.quit(); // we can also use it to close the browser
	
	
	}
	
}
