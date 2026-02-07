package day7;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;

public class BrwserMethods {
	
	
	public static void main(String[] args) throws InterruptedException{
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		driver.findElement(By.linkText("OrangeHRM, Inc")).click(); //this will open new browser
		
		Thread.sleep(5000);
//		driver.close(); //It will only close first browser window wherever the driver is focused
		
		driver.quit(); //It will close both browser windows
	}
}
