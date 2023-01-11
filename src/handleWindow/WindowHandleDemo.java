package handleWindow;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandleDemo {
	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		
		String parentHandle=driver.getWindowHandle();
//		System.out.println("parent handle --> "+ parentHandle);
		
		driver.findElement(By.id("newWindowBtn")).click();		
		Set<String> handles = driver.getWindowHandles();
		
		for (String handle : handles) {
			
			if(!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				driver.findElement(By.id("firstName")).sendKeys("Ganesh");
				Thread.sleep(4000);
				driver.close();
			}
		}
		
		driver.switchTo().window(parentHandle);
		driver.findElement(By.id("name")).sendKeys("Poul");
//		driver.quit();

	}

}
