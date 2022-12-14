package screenShots;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class Screenshot2 {
	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");		
		WebElement logo = driver.findElement(By.xpath("//img[@class='lnXdpd']"));
		
		Thread.sleep(2000);
		File src = logo.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/scr1.jpg");
		Files.copy(src, dest);	
		driver.close();
	}

}
