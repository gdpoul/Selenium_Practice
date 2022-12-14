package relevel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Relevel {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.myntra.com/");

//		MouseHover to Mens by using mouse action
	    Actions act =new Actions(driver);
	    WebElement mens = driver.findElement(By.xpath("//div[@class='desktop-navLink']/descendant::a[text()='Men']"));
	    act.moveToElement(mens).build().perform();
	    driver.findElement(By.xpath("//a[text()='T-Shirts']")).click();
	    driver.findElement(By.xpath("//div[@class='brand-more']")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//ul[@class='FilterDirectory-indices']/child::li[text()='h']")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("(//label[text()='HRX by Hrithik Roshan'])[2]")).click();
	    String hrxCount = driver.findElement(By.xpath("(//label[text()='HRX by Hrithik Roshan'])"
	    		+ "[2]/span[@class='FilterDirectory-count']")).getText();
	    System.out.println(hrxCount);
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//label[text()='HERE&NOW']")).click();
        String hereCount = driver.findElement(By.xpath("//label[text()='HERE&NOW']/"
        		+ "span[@class='FilterDirectory-count']")).getText();
        System.out.println(hereCount);
        
	    driver.findElement(By.xpath("//span[contains(@class,'close sprites-remove')]")).click();
	  
	    String titleCount = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
	    System.out.println(titleCount);

	    
	}

}
