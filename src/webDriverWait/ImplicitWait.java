package webDriverWait;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWait {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		
		WebElement uploadFile = driver.findElement(By.xpath("//input[@type='file']"));
		File file=new File("./SpeckyfoxLogo.png");
		uploadFile.sendKeys(file.getAbsolutePath());
		driver.findElement(By.xpath("//span[.='Start upload']")).click();
		boolean visibility = driver.findElement(By.cssSelector("button[data-type='DELETE']")).isDisplayed();
		System.out.println("Is select button Visible: "+visibility);
	}

}
