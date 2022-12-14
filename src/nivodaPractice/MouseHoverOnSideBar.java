package nivodaPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseHoverOnSideBar {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();		
		Actions act=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://website-beta.nivodaapi.net/");
		
		//LoginOperation
		driver.findElement(By.name("email")).sendKeys("ubaid@nivoda.net");
		driver.findElement(By.name("password")).sendKeys("Nivoda123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		//Mouse Action
		
		Thread.sleep(10000);
		
		WebElement sideBar=driver.findElement(By.xpath("//div[@class='rounded-circle']"));
		
//		WebElement sideBar = driver.findElement(By.xpath("//span[text()='Melee Dashboard']/ancestor::div[@class='nav__item_content']/descendant::div[@class='wdc-nav--icon']"));
	
		act.moveToElement(sideBar).build().perform();
		driver.findElement(By.xpath("//div[@class='sc-epGmkI oBjWT name_tag']")).click();
		
     	driver.quit();
	}
	

}
