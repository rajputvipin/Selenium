package day7;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/register");
		
		driver.manage().window().maximize();
		
		//isDisplayed() - it will check the element is displayed or not (or elements is operational or not)
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		System.out.println("Display status of logo:"+logo.isDisplayed());
		
		// another way 
		//boolean status = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		//System.out.println("Display status:"+ status);
		
		//is displayed method is applicable on all kind of elements
		
		
		
		//isEnabled() :- it is also used on top of web elements and will check that the element is enabled or not
		//if something is disabled . we can't pass any value in it.
		//we can check it for elements on which we can perform any action like , input fields or buttons or links or buttons not on logos or titles(which are not links).
		
		boolean status = driver.findElement(By.xpath("//input[@id='FirstName']")).isEnabled();
		System.out.println("Enabled Status:"+status);
		
		
		
		//isSelected() - it is applicable on radio buttons or check-boxes to identify whether the element is selected or not.
		//to capture them inspect the boxes not the label or whole thing just the boxes.
		WebElement male_rd = driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement female_rd = driver.findElement(By.xpath("//input[@id='gender-female']"));
		
		System.out.println("Before selection.........");
		System.out.println(male_rd.isSelected()); //false
		System.out.println(female_rd.isSelected());  //false
		
		System.out.println("After selecting male...");
		male_rd.click();
		
		System.out.println(female_rd.isSelected()); //false
		System.out.println(male_rd.isSelected()); // true
		
		System.out.println("After selecting Female...");
		female_rd.click();
		
		System.out.println(male_rd.isSelected()); //false
		System.out.println(female_rd.isSelected()); // true
		
		
		//Applying isSelect method on checkbox
		boolean newsletterstatus = driver.findElement(By.xpath("//input[@id='NewsLetterSubscriptions_0__IsActive']")).isSelected();
		System.out.println("News letter checkbox status:"+ newsletterstatus); // true
		
		
		
	}
}
