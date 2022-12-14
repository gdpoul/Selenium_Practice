package extentsReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class DifferentLogTypes {
	public static void main(String[] args) throws IOException {
		
		ExtentReports extentReport = new ExtentReports();
		File file=new File("reoprter.html");
		ExtentSparkReporter sparkRporter = new ExtentSparkReporter(file);
		extentReport.attachReporter(sparkRporter);
		
		extentReport
		.createTest("Text based Test")
		.info("simple text")
		.info("<b>bold text</b>")
		.info("<i>Italic text </i>");
		
		String xmlData="<menu id=\"file\" value=\"File\">\r\n"
				+ "  <popup>\r\n"
				+ "    <menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\r\n"
				+ "    <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\r\n"
				+ "    <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\r\n"
				+ "  </popup>\r\n"
				+ "</menu>";
		
		String jsonData="{\"menu\": {\r\n"
				+ "  \"id\": \"file\",\r\n"
				+ "  \"value\": \"File\",\r\n"
				+ "  \"popup\": {\r\n"
				+ "    \"menuitem\": [\r\n"
				+ "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\r\n"
				+ "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\r\n"
				+ "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\r\n"
				+ "    ]\r\n"
				+ "  }\r\n"
				+ "}}";
		
		
		extentReport
		.createTest("Xml based Test")
		.info(MarkupHelper.createCodeBlock(xmlData,CodeLanguage.XML));

		extentReport
		.createTest("Json based Test")
		.log(Status.INFO,MarkupHelper.createCodeBlock(jsonData, CodeLanguage.JSON));

		
		List<String> listData=new ArrayList<String>();
		listData.add("Ganesh");
		listData.add("Dileep");
		listData.add("Poul");

		Set<String> setData=new HashSet<>();
		setData.add("GANESH");
		setData.add("DILEEP");
		setData.add("POUL");
		
		Map<Integer,String> mapData=new HashMap<>();
		mapData.put(001, "Ganesh");
		mapData.put(002, "Dileep");
		mapData.put(003, "Poul");
			
		extentReport
		.createTest("List Data based Test")
		.info(MarkupHelper.createOrderedList(listData))
		.info(MarkupHelper.createUnorderedList(listData));

		extentReport
		.createTest("Set Data based Test")
		.info(MarkupHelper.createOrderedList(setData))
		.info(MarkupHelper.createUnorderedList(setData));

		extentReport
		.createTest("MAp Data based Test")
		.info(MarkupHelper.createOrderedList(mapData))
		.info(MarkupHelper.createUnorderedList(mapData));

		extentReport
		.createTest("Highlighted Log Test")
		.info("Normal Text")
		.info(MarkupHelper.createLabel("Highlighted Text", ExtentColor.RED));
		
		try {
			int i=10/0;
		} catch (Exception e) {
			extentReport
			.createTest("Exception1 Log Test")
			.fail(e);
		}
		
		Throwable t=new RuntimeException("This is a Custome Exception");
		extentReport
		.createTest("Exception2 Log Test")
		.fail(t);

		Throwable t2=new RuntimeException("This is a Custome Exception");
		extentReport
		.createTest("Exception3 Log Test")
		.fail(t2);

	
		
		extentReport.flush();
		Desktop.getDesktop().browse(new File("reoprter.html").toURI());

	}

}
