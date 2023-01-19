package desiredCaps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Class1 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
//		driver.manage().timeouts()
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
//		wait.until(ExpectedConditions.ele)
	}

}
