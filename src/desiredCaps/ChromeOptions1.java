package desiredCaps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptions1 {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--start-maximized");
		co.addArguments("--headless");
		
		WebDriver driver=new ChromeDriver(co);
		System.out.println("hello");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		System.out.println(driver.getTitle());
		

	}

}
