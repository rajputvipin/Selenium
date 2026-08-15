package Day9;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAlertsUsingExplicitWait {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Open the application
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // Maximize browser window
        driver.manage().window().maximize();
        
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Thread.sleep(5000);
        
        Alert myalert=mywait.until(ExpectedConditions.alertIsPresent());
        
        System.out.println(myalert.getText());
        myalert.accept(); 
        
        
        // Authenticated Pop-up
        
        //driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        
        //Switch commands will not work , wait command will not work , normal attributes will not work , we have to inject creds directly
        driver.get("https://admin:admin@the-internte.herokuapp.com/basic-auth");
        
        
	}

}
