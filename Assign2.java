package week4.day1.assign;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Click button to open home page in New Window
		driver.findElement(By.xpath("//button[text()='Open Home Page']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list1 = new ArrayList<String>(windowHandles);
		String secondWindow = list1.get(1);
		driver.switchTo().window(secondWindow);	
		System.out.println("Open Home Page :"+driver.getTitle());	
		driver.close();
		driver.switchTo().window(list1.get(0));
		
		//Find the number of opened windows
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		System.out.println("no of windows "+windowHandles2.size());
		
		//Close all except this window	
		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String> list2 = new ArrayList<String>(windowHandles3);
		for(int i=1; i<list2.size(); i++) {
			driver.switchTo().window(list2.get(i)).close();
		}
		driver.switchTo().window(list2.get(0));
		
		//Wait for 2 new Windows to open
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		Set<String> windowHandles4 = driver.getWindowHandles();
		List<String> list3 = new ArrayList<String>(windowHandles4);
		for(int i=1; i<list3.size(); i++) {
			System.out.println("tilte of child window "+ i+ " " + driver.switchTo().window(list3.get(i)).getTitle());
		}
		driver.quit();
		System.out.println("closed all the windows");}

}
