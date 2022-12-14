package launchBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchFireFox {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");	
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.google.com");
		//driver.findElement(By.name("q")).sendKeys("Java");
		driver.switchTo().activeElement().sendKeys("Java");
	}

}
