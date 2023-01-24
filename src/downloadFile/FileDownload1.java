package downloadFile;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FileDownload1 {
	
	static String downloadPath="./Downloads/";
	public static void main(String[] args) {
		
		File downloadFolder=new File(downloadPath);
		downloadFolder.mkdir();
		Map<String, Object> preferences=new HashMap<>();
		preferences.put("download.default_directory", downloadPath);
		ChromeOptions option=new ChromeOptions();
		option.setExperimentalOption("prefs", preferences);
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://chromedriver.storage.googleapis.com/index.html?path=102.0.5005.27/");
		driver.findElement(By.linkText("chromedriver_win32.zip")).click();
		
	}

}
