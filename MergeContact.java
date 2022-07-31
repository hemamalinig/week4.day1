package week4.day1.assign;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class MergeContact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * //Pseudo Code
		 * 
		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 * 
		 * 2. Enter UserName and Password Using Id Locator
		 * 
		 * 3. Click on Login Button using Class Locator
		 * 
		 * 4. Click on CRM/SFA Link
		 * 
		 * 5. Click on contacts Button
		 * 	
		 * 6. Click on Merge Contacts using Xpath Locator
		 * 
		 * 7. Click on Widget of From Contact
		 * 
		 * 8. Click on First Resulting Contact
		 * 
		 * 9. Click on Widget of To Contact
		 * 
		 * 10. Click on Second Resulting Contact
		 * 
		 * 11. Click on Merge button using Xpath Locator
		 * 
		 * 12. Accept the Alert
		 * 
		 * 13. Verify the title of the page
		 */
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Merge Leads")).click();
		driver.findElement(By.xpath("//span[text()='From Lead']/following::img")).click();
		String windowHandle = driver.getWindowHandle();
		System.out.println("on : "+windowHandle);
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("Hoe many window "+ windowHandles);
		List<String> isWindows = new ArrayList<String>(windowHandles);
		String secondWindow = isWindows.get(1);
		driver.switchTo().window(secondWindow);		
		driver.findElement(By.name("firstName")).sendKeys("Babu");		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();	
		System.out.println("into second window "+driver.getTitle());
		driver.findElement(By.xpath("//div[text()='Lead ID']/following::a[text()[normalize-space()='10346']]")).click();
		driver.switchTo().window(windowHandle);
		driver.findElement(By.xpath("//span[text()='To Lead']/following::img")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		System.out.println("Hoe many window "+ windowHandles2);
		List<String> isWindows2 = new ArrayList<String>(windowHandles2);
		String secondWindow2 = isWindows2.get(1);
		driver.switchTo().window(secondWindow2);	
		driver.findElement(By.name("firstName")).sendKeys("Babu");	
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();	
		driver.findElement(By.xpath("//div[text()='Lead ID']/following::a[text()[normalize-space()='10356']]")).click();
		driver.switchTo().window(windowHandle);
		driver.findElement(By.className("buttonDangerous")).click();
		driver.switchTo().alert().accept();
		System.out.println(driver.getTitle());
		}

}
