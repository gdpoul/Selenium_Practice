package mouseAction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClick {
	public static void main(String[] args) {
		
		    System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://omayo.blogspot.com/");		
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			WebElement target = driver.findElement(By.xpath("//button[text()=' Double click Here   ']"));
			
			Actions act = new Actions(driver);
		    act.doubleClick(target).perform();
	}

}
