package extentsReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AddEnvironment {
	public static void main(String[] args) throws IOException {
		
		ExtentReports extentReport = new ExtentReports();
		File file=new File("reoprter.html");
		ExtentSparkReporter sparkRporter = new ExtentSparkReporter(file);
		
		extentReport.setSystemInfo("OS", System.getProperty("os.name"));
		extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));

		extentReport.createTest("Test1")
		.pass("Test is PAsseed")
		.assignAuthor("Ganesh")
		.assignCategory("SmokeTesting")
		.assignDevice("Chrome101");
	
		extentReport.flush();
		Desktop.getDesktop().browse(new File("reoprter.html").toURI());

	}

}
