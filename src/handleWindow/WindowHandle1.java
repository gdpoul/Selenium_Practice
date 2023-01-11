package handleWindow;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle1 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.findElement(By.xpath("//img[@class='wikipedia-icon']")).click();
		
//	    Window handling
		String parentHandle = driver.getWindowHandle();
		Set<String> allHandle = driver.getWindowHandles();
		
		for(String handle:allHandle)
		{
			if(!(parentHandle).equals(handle))
			{
				driver.switchTo().window(handle);
				driver.findElement(By.xpath("//input[@placeholder='Search Wikipedia']")).sendKeys("Selenium");
				driver.findElement(By.id("searchButton")).click();
			}
		}
		
		
		
	}

}
