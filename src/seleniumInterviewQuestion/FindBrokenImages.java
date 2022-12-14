package seleniumInterviewQuestion;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindBrokenImages {
	public static void main(String[] args) throws IOException {
		verifyBrokenImageUsingSeleium(); 
	}
	public static void verifyBrokenImageUsingSeleium() throws IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.theworldsworstwebsiteever.com/");
		
		List<WebElement> images = driver.findElements(By.tagName("img"));
	    System.out.println(images.size());
	    
	    for (WebElement image : images) {
			String imageSrc = image.getAttribute("src");
			try {
				URL url=new URL(imageSrc);
				URLConnection urlConnection = url.openConnection();
				HttpURLConnection httpsUrlConnection=(HttpURLConnection) urlConnection;
				httpsUrlConnection.setConnectTimeout(5000);
				httpsUrlConnection.connect();
				
				if(httpsUrlConnection.getResponseCode()==200) 
					System.out.println(imageSrc+" >>"+ httpsUrlConnection.getResponseCode()
					+" >>"+httpsUrlConnection.getResponseMessage());
				
				else
					System.err.println(imageSrc+" >>"+ httpsUrlConnection.getResponseCode()
					+" >>"+httpsUrlConnection.getResponseMessage());
				
				httpsUrlConnection.disconnect();
			} 
			catch (Exception e) {
		      System.err.println(imageSrc);
			}
		}
	    driver.quit();
	}
}
