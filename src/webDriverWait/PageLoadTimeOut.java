package webDriverWait;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageLoadTimeOut {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.get("https://www.hyrtutorials.com/");
		System.out.println(driver.getTitle());
		
		driver.quit();
	}

}
