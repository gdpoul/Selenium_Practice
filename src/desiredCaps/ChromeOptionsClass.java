package desiredCaps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeOptionsClass {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--start-maximized");
		co.addArguments("--incognito");
		co.setAcceptInsecureCerts(true);
		
		WebDriver driver=new ChromeDriver(co);
		driver.get("https://cacert.com");
	}

}
