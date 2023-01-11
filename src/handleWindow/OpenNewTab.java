package handleWindow;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenNewTab {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	    driver.get("https://www.selenium.dev/");
	    
	    driver.switchTo().newWindow(WindowType.TAB);
	    driver.get("https://www.google.com");
	    
	    Set<String> allHandles = driver.getWindowHandles();
	    
	    for (String handle : allHandles) {
			System.out.println(handle);
		}
//	    driver.quit();
	}

}
