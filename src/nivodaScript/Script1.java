package nivodaScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Script1 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://website-fbn.nivodaapi.net/");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ubaid@nivoda.net");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Nivoda123");
		driver.findElement(By.xpath("//button[contains(text(),'Log In')]")).click();
	}

}
