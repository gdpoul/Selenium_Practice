package javaScriptScrolling;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScript2 {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.globalsqa.com/");
		
//		scroll to particular element
		
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Trainings we deliver')]"));		
		Point location = element.getLocation();
		int xAxis = location.getX();
		int yAxis =location.getY();
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		
		Thread.sleep(3000);
		jse.executeScript("window.scrollBy("+xAxis+","+yAxis+")");
 
	}

}
