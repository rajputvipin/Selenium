//URL https://demo.nopcommerce.com/
//Validate in chrome browser that title should be "nopCommerce demo store"

package day2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondTestCase {
	public static void main(String[] args) {
		//Step 1 : Launching Chrome Browser
		WebDriver driver = new ChromeDriver();
		
		//Step 2 : Opening required url
		driver.get("https://demo.nopcommerce.com/");
		
		//Step 3 : Getting actual title
		String actual_title = driver.getTitle();
		
		//Step 4 : Comparing with expected title
		if(actual_title.equals("nopCommerce demo store")) {
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed");
		}
		//System.out.println(actual_title); //it will print the actual title of the webpage
		
		//Step 5 : Closing the browser
		driver.close();
		
		// The result will be "Test Failed" as the actual title is "nopCommerce demo store. Home page title". 
		
		
	}
}
