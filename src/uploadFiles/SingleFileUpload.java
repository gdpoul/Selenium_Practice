package uploadFiles;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingleFileUpload {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));		
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		
		// upload file using sendKeys()
		WebElement uploadFile = driver.findElement(By.id("filesToUpload"));
		File file=new File("./SpeckyfoxLogo.png");
		uploadFile.sendKeys(file.getAbsolutePath());
	}

}
