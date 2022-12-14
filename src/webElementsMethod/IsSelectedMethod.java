package webElementsMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsSelectedMethod {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.globalsqa.com/samplepagetest/");
		
		WebElement checkbox = driver.findElement(By.xpath("//input[@value='Automation Testing']"));
		System.out.println(checkbox.isSelected());
		
		checkbox.click();
		System.out.println(checkbox.isSelected());
		
	}
}
