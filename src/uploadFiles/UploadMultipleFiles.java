package uploadFiles;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadMultipleFiles {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");

		// Upload Multiple files using sendKeys()
		WebElement uploadFile = driver.findElement(By.id("filesToUpload"));
		File file1 = new File("./screenshots/SpeckyfoxLogo.png");
		File file2 = new File("./screenshots/Google.jpg");
		File file3 = new File("./screenshots/scr1.jpg");
		String allFilePath = file1.getAbsolutePath() + "\n" + file2.getAbsolutePath() + "\n" + file3.getAbsolutePath();
		uploadFile.sendKeys(allFilePath);
	}

}
