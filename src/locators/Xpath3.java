package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath3 {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/");	
		Thread.sleep(4000);
		
//		Xpath: //tagname[contains(arg1,arg2)]
		
		driver.findElement(By.xpath("//a[contains(@class,'grid')]")).click();
	}

}
