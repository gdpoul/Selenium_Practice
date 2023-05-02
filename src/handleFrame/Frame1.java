package handleFrame;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Frame1 {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/#iFrame");

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='globalSqa']")));
//		WebDriverWait wb=new WebDriverWait(driver, Duration.ofSeconds(10));
//		wb.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("globalSqa"));
		
	
		Actions act = new Actions(driver);
		WebElement target = driver.findElement(By.id("current_filter"));
		act.moveToElement(target).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[.='Performance Testing']")).click();
		
	}

}
