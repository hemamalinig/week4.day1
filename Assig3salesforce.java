package week4.day1.assign;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assig3salesforce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Salesforce Customer service:
			1.Launch the browser
			2.Load the url as " https://login.salesforce.com/ "
			3.Enter the username as " ramkumar.ramaiah@testleaf.com "
			4. Enter the password as " Password$123 "
			5.click on the login button
			6.click on the learn more option in the Mobile publisher
			7.Switch to the next window using Windowhandles.
			8.click on the confirm button in the redirecting page
			9.Get the title
			10.Get back to the parent window
			11.close the browser*/
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password$123");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> List1 =  new ArrayList<String>(windowHandles);
		driver.switchTo().window(List1.get(1));
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		System.out.println("New window title :"+driver.switchTo().window(List1.get(1)).getTitle());
		driver.switchTo().window(List1.get(0));
		System.out.println("Back to parent window :"+ driver.getTitle());
		driver.quit();
		System.out.println("closed all the windows");
		
	}

}
