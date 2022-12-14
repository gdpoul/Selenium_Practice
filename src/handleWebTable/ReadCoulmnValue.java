package handleWebTable;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadCoulmnValue {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://testautomationpractice.blogspot.com/");
		
		// check total row of the column
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr"));
		int rowCount = rows.size();
		System.out.println("Total Row count of table is :"+rowCount);
		
		
		//read all first column value
		
		String beforeXpath="//*[@id=\"HTML1\"]/div[1]/table/tbody/tr[";
		String afterXpath="]/td[1]";
		
		for(int i=2;i<=rowCount;i++)
		{
			String actualXpth=beforeXpath+i+afterXpath;
			WebElement element = driver.findElement(By.xpath(actualXpth));
			System.out.println(element.getText());
		}
		
	}

}
