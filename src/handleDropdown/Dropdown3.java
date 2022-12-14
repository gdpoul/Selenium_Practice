package handleDropdown;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown3 {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://omayo.blogspot.com/");
		
		WebElement mulitiSelect = driver.findElement(By.id("multiselect1"));
		
		Select sel=new Select(mulitiSelect);
		System.out.println(sel.isMultiple());
		
		List<WebElement> allOptions = sel.getOptions();
		for(WebElement option: allOptions)
		{
			System.out.println(option.getText());
		}
		for(int i=0;i<=3;i++)
		{
			sel.selectByIndex(i);
		}
		
		System.out.println("first selected option is: "+sel.getFirstSelectedOption().getText());
		Thread.sleep(3000);
		
		sel.deselectAll();
	}
	

}
