package day8;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationalCommands {

    public static void main(String[] args) throws Exception {

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Open the URL using the get() method.
        // get() accepts only a String URL.
        // It waits until the page is completely loaded before returning control.
        // driver.get("https://demo.nopcommerce.com/");

        // Open the URL using navigate().to()
        // navigate() returns a Navigation interface.
        // to() is a method of the Navigation interface.
        // It can accept either:
        // 1. A String URL
        // 2. A URL object
        // Internally, navigate().to(String) behaves similarly to get().
        // navigate() also provides browser navigation methods such as
        // back(), forward(), and refresh().

        // Passing URL as a String
        driver.navigate().to("https://demo.nopcommerce.com/");

        // Passing URL as a URL object
        URL myurl = new URL("https://demo.nopcommerce.com/");
        driver.navigate().to(myurl);

        // Navigation methods available:

        // Goes to the previous page in browser history
        // driver.navigate().back();

        // Goes to the next page in browser history
        // driver.navigate().forward();

        // Reloads the current web page
        // driver.navigate().refresh();
        
        //To capture current Url
        //driver.getCurrentUrl(); 
        
        
        
        

        // Close all browser windows and end the WebDriver session
        driver.quit();
    }
}