package webElementsMethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationMethods {
	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		// navigation methods
		Navigation nav = driver.navigate();
		nav.to("https://www.facebook.com/");
		
		Thread.sleep(3000);
		nav.refresh();
		
		Thread.sleep(3000);
		nav.back();
		
		Thread.sleep(3000);
		nav.forward();
	}

}
