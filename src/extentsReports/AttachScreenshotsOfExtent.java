package extentsReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

public class AttachScreenshotsOfExtent {
	static WebDriver driver;
	public static String captureScreenShots(String file) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/"+file+"");
	    Files.copy(src, dest);
	    return dest.getAbsolutePath();
	}
	public static String captureScreenShot() {
		TakesScreenshot ts=(TakesScreenshot)driver;
		String base64Code = ts.getScreenshotAs(OutputType.BASE64);
		return base64Code;
	}
		
	public static void main(String[] args) throws IOException {
		
		ExtentReports extentReport = new ExtentReports();
		File file=new File("reoprter.html");
		ExtentSparkReporter sparkRporter = new ExtentSparkReporter(file);
		extentReport.attachReporter(sparkRporter);
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
	    driver.get("https://www.google.com");
		String path = captureScreenShots("Google.jpg");
	    String base64 = captureScreenShot();
	    
	    
	    extentReport.createTest("ScreenShot1","This is a Method to take screenshot at Test Level")
	    .info("this is info msg")
	    .addScreenCaptureFromPath(path)
	    .addScreenCaptureFromPath(path, "GoogleHomePage");

	    extentReport.createTest("ScreenShot2","This is a Method to take screenshot at Test Level")
	    .info("this is info msg")
	    .addScreenCaptureFromBase64String(base64)
	    .addScreenCaptureFromBase64String(base64, "GoogleHomePage");

	    extentReport.createTest("ScreenShot3","This is a Method to take screenshot at Test Level")
	    .info("this is info msg")
	    .addScreenCaptureFromPath(path, "GoogleHomePage1")
	    .addScreenCaptureFromPath(path, "GoogleHomePage2")
	    .addScreenCaptureFromPath(path, "GoogleHomePage3")
	    .addScreenCaptureFromPath(path, "GoogleHomePage4");

	    extentReport.createTest("ScreenShot4","This is a Method to take screenshot at Test Level")
	    .info("this is info msg")
        .addScreenCaptureFromBase64String(base64, "GoogleHomePage1")
	    .addScreenCaptureFromBase64String(base64, "GoogleHomePage2")
	    .addScreenCaptureFromBase64String(base64, "GoogleHomePage3")
	    .addScreenCaptureFromBase64String(base64, "GoogleHomePage4");

	    extentReport.createTest("ScreenShot5","This is a Method to take screenshot at Method Level")
	    .info("this is info msg")
	    .fail(MediaEntityBuilder.createScreenCaptureFromPath(path,"ss1").build())
	    .fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "ss1").build());
   
	    Throwable t=new Throwable("This is throwable expection");
	    extentReport.createTest("ScreenShot6","This is a Method to take screenshot at Method Level")
	    .info("this is info msg")
	    .fail(t, MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "ss1").build())
	    .fail(t, MediaEntityBuilder.createScreenCaptureFromPath(path, "ss2").build());
 
		extentReport.flush();
		driver.quit();
		Desktop.getDesktop().browse(new File("reoprter.html").toURI());


	}

}
