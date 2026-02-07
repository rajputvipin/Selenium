package day5;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//Xpath with the single attribute
		// driver.findElement(By.xpath("//*[@id=\"small-searchterms\"]")).sendKeys("Tshirts");
		
		//Xpath with multiple attributes
		//driver.findElement(By.xpath("//input[@name='search'][@placeholder='Search']")).sendKeys("Tshirts");
		
		//Xpath with 'and' operator 
		driver.findElement(By.xpath("//input[@name='search'and @placeholder='Search']")).sendKeys("Tshirts");
		
		//Xpath with 'or' operator
		driver.findElement(By.xpath("//input[@name='search'and @placeholder='Search']")).sendKeys("Tshirts");
		
		//Xpath with text()
		driver.findElement(By.xpath("//*[text() = 'MacBook']")).click();
		
		
		boolean displayStatus=driver.findElement(By.xpath("//h3[text()='Featured']")).isDisplayed();
		System.out.println(displayStatus);
		
		String value = driver.findElement(By.xpath("//h3[text()='Featured']")).getText();
		System.out.println(value);
		
		
		//Xpath with contains method
		driver.findElement(By.xpath("//input[contains[@placeholder,'Sea')]")).sendKeys("Tshirts");
		
		
		//Xpath with start-with()
		driver.findElement(By.xpath("//input[start-with(@placeholder,'Sea')]")).sendKeys("Tshirts");
		
		
		//Handling dynamic attributes using contains and start-with method
		
		
		
		
		
		
		//chained X-path
	
	}
}
