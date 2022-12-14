package relevel;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class Relevel_Parkhe {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
//		open the browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
//		Step 1: Open the filpkart 
		driver.get("https://www.flipkart.com/");
		
//		Step 2: close login popup
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();

//		step 3: search the fridge and select Fridge in Refrigerator
		driver.findElement(By.name("q")).sendKeys("fridge");
		driver.findElement(By.xpath("//div[text()='in Refrigerators']")).click();
		
//		step 4: select first option
		driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]")).click();
		
//		step 5 and Step 6: switch control to the new tab and set pin code 
		
		String parentHandle=driver.getWindowHandle();
		Set<String> allHAndle = driver.getWindowHandles();
		
		for(String s: allHAndle) {
			
			if(!(parentHandle).equals(s))
			{
				driver.switchTo().window(s);
				
				driver.findElement(By.id("pincodeInputId")).sendKeys("110092",Keys.ENTER);
				driver.close();
			}
		}
		
//		step 7: apply brand filter samsung
		driver.switchTo().window(parentHandle);
		driver.findElement(By.xpath("//div[text()='SAMSUNG']")).click();
		
//      step 8: Scroll down apply capacity filter 
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Capacity']")).click();
		driver.findElement(By.xpath("//div[text()='301 - 400 L']")).click();
		
//      step 9: display total number of result:
		Thread.sleep(2000);
		String result = driver.findElement(By.xpath("//span[@class='_10Ermr']")).getText();
		System.out.println(result);
		
//		step 11 : take a snapshot of last result
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/scr1.png");
		Files.copy(src, dest);
		

	}
}
