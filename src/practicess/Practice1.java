package practicess;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Practice1 {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// login to application
		driver.get("https://test.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("pev4.7.2_trial113_admin@navatarplatform.com.tr5sb16");
		driver.findElement(By.id("password")).sendKeys("navatar@1");
		driver.findElement(By.id("Login")).click();
		
// 
//		driver.findElement(By.xpath("//a[@title='Contacts']/following-sibling::one-app-nav-bar-item-dropdown")).click();
//		
//		JavascriptExecutor js=(JavascriptExecutor) driver;
//		
//		js.executeScript("arguments[0].click()",driver.findElement(By.xpath("//span[text()='smith11']")));
		
		driver.findElement(By.xpath("//div[@class='uiMenu']")).click();
		driver.findElement(By.xpath("//a[@role='menuitem']/descendant::span[text()='Setup']")).click();
		
		String parentHandle=driver.getWindowHandle();
		Set<String> allHandle = driver.getWindowHandles();
		
		for(String handle:allHandle) {
			if(!(handle.equals(parentHandle))){
				driver.switchTo().window(handle);
			}
		}
		
		String headerTitle=driver.findElement(By.xpath("//span[@title='Setup']")).getText();
		
		Assert.assertEquals(headerTitle, "Setup");
	    System.out.println("Test pass");	    
	    driver.close();
	    driver.switchTo().window(parentHandle);    
		driver.findElement(By.cssSelector("div[data-component-id='navatarEdgeMenu']")).click();
		driver.findElement(By.xpath("//span[text()='Task']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@data-id='combobox-id-1']")).click();
		
		List<WebElement> listBox = driver.findElements(By.xpath("//div[@data-id='listbox-id-1']/ul/li"));
		
		for(WebElement option:listBox) {
			System.out.println(option.getText());
		}
	}

}
