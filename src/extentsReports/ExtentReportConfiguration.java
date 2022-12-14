package extentsReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportConfiguration {

	public static void main(String[] args) throws IOException {
		ExtentReports extentReport = new ExtentReports();
		File file=new File("reoprter.html");
		ExtentSparkReporter sparkRporter = new ExtentSparkReporter(file);
		
		sparkRporter.loadXMLConfig(new File("./config/extentReports.xml"));
//		sparkRporter.loadJSONConfig(new File("./config/extentReoprts.json"));
		
//		extentReport.attachReporter(sparkRporter);
//		sparkRporter.config().setTheme(Theme.DARK);
//		sparkRporter.config().setDocumentTitle("DocTitle");
//		sparkRporter.config().setReportName("Reporter1");
//		sparkRporter.config().setTimeStampFormat("dd MMM, yyyy hh:mm:ss a");
//		sparkRporter.config().setCss(".badge-primary{background-color: #319932;}");
//		sparkRporter.config().setJs("document.getElementsByClassName('logo')[0].style.display=\"none\"");
		
		extentReport.createTest("Test1")
		.pass("Test is PAsseed")
		.assignAuthor("Ganesh")
		.assignCategory("SmokeTesting")
		.assignDevice("Chrome101");
	
		extentReport.flush();
		Desktop.getDesktop().browse(new File("reoprter.html").toURI());

	}
}
