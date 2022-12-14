package handleDropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingBootStrapDropdown2 {
	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.jquery-az.com/");
		
		Actions act=new Actions(driver);
		WebElement programming=driver.findElement(By.id("menu-item-7090"));	
		act.moveToElement(programming).build().perform();
		
		List<WebElement> options = driver.findElements(By.xpath("//li[@id='menu-item-7090']/ul/li"));
		
		for (WebElement option : options) {
			String optionText = option.getText();
			System.out.println(optionText);
			if(optionText.equals("C++")) {
				option.click();
			}
		}
		driver.quit();
	}

}
