package handleWindow;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowHandle {
	
	static WebDriver driver;
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		String parentWindowId = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[contains(@href,'linkedin')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'facebook')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'twitter')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'youtube')]")).click();
		
		Set<String> allHandles = driver.getWindowHandles();
		List<String> hList=new ArrayList<String>(allHandles);
		
		if(switchToRightWindow("Facebook", hList)) {
			System.out.println("title of current window :"+driver.getTitle());
		}
		
		closeAllWindow(hList, parentWindowId);
		driver.switchTo().window(parentWindowId);
		System.out.println("title of parent window :"+driver.getTitle());
		
		
	}
	public static boolean switchToRightWindow(String windowTitle, List<String>hList) {
		for(String handle: hList) {
			String title = driver.switchTo().window(handle).getTitle();
			
			if(title.contains(windowTitle)) {
				System.out.println("found the right window...");
				return true;
			}
		}
		return false;		
	}
	
	public static void closeAllWindow(List<String> hList,String parentWindowId) {
		
		for(String e:hList) {
			if(!e.equals(parentWindowId)) {
				driver.switchTo().window(e).close();
			}
		}
	}

}
