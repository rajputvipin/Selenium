package day3;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorsDemo {
		public static void main(String[] args) {
			WebDriver driver = new ChromeDriver(); // Launch Chrome Browser
			
			driver.get("https://demo.nopcommerce.com/"); // Navigate to the website
			
			driver.manage().window().maximize(); // it will maximise the browser window
			
			//id
//			driver.findElement(By.id("small-searchterms")).sendKeys("Mac"); //it will locate and return the web element and .sendKeys() is the action which we are performing
//			
//			//name 
//			driver.findElement(By.name("q")).sendKeys("Vipin Rajput");
			
			//linktext 
//			driver.findElement(By.linkText("Electronics")).click(); //click will perform the action by clicking on Electronics
			
			//partialLinkText
//			driver.findElement(By.partialLinkText("Elect")).click(); //here we do not need to pass the whole linktext we can just pass a partial or shorter form of it 
			// for e.g I have passed here Elec instead of Electronics but it will redirect me to Electronics page
			//It is not preferable as it might lead to mixup as Elec can be short form for both Electronics and Election
			
			
			//ClassName :- It is used to capture or locate multiple web elements
//			List<WebElement> headerLinks = driver.findElements(By.className("header-links")); // All the header links will be stored in the List , we cannot use set here header links could be duplicate and set doesnt support duplicacy so the return type of WebElements is kept as List.
//			System.out.println("Total Number of header links:"+ headerLinks.size());
			
			//tageName
//			List<WebElement> links =  driver.findElements(By.tagName("a"));
//			System.out.println("Total number of links:"+links.size());
//			
			//To identify total number of images on the webpage
			List<WebElement> images = driver.findElements(By.tagName("img"));
			System.out.println("Total number of Images:"+images.size());
//			
		}
}
