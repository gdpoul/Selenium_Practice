package webElementsMethod;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsEnabledMethod {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.instagram.com");
		
		
		WebElement loginButton=driver.findElement(By.xpath("//button[contains(@class,'L3NKy')]"));
		
		System.out.println(loginButton.isEnabled());   //false
		
		// enter username and password
		
		driver.findElement(By.name("username")).sendKeys("username");
		driver.findElement(By.name("password")).sendKeys("abc123");
		
		System.out.println(loginButton.isEnabled());  //true

		
		
		
		
		
		
		
	}

}
