package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSLocators {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopCommerce.com/");
		driver.manage().window().maximize();
		
		
		//Tag id combination , Syntax :- tag#id ("But tag is option")
		//driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("T-shirts");
		//driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("Vipin");    //since tag is optional
		
		//tag classname combination , Synatx :- tag.classname
		//driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("T-shirts");
		//driver.findElement(By.cssSelector(".search-box-text")).sendKeys("Shirts");
		
		
		//tag attribute combination
		//driver.findElement(By.cssSelector("input[placeholder='Search store']")).sendKeys("Pants");
		
		
		//tag class attribute combination
		driver.findElement(By.cssSelector("input.search-box-text[placeholder='Search store']")).sendKeys("Trousers");
		
	}
}
