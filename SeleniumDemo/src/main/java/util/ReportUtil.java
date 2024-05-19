package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportUtil {
	public ExtentReports generateReports(){
	    String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
	    ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportPath);
	    htmlReporter.config().setDocumentTitle("Automation Report");
	    htmlReporter.config().setReportName("Test Automation Results");
	    htmlReporter.config().setTheme(Theme.STANDARD);
	    ExtentReports extentReports= new ExtentReports();
	    extentReports.attachReporter(htmlReporter);
	    return extentReports;
	}
	
	ExtentReports extentReports;
	public void generateReports1()
	{
		extentReports = generateReports();
	}
	
	ExtentTest extenTest;
	public void createTest1(String testReportName)
	{
		extenTest =extentReports.createTest(testReportName);
	}
	
	public void extenTestLogINFO()
	{
		extenTest.log(Status.INFO,"entering test");
	}
	
	public void extenTestlogPASS()
	{
		extenTest.log(Status.PASS,"test passed");
	}
	
	public void extenTestlogFAIL()
	{
		extenTest.log(Status.FAIL, "test Fail");
	}
	
	public void extenTestlogWARNING()
	{
		extenTest.log(Status.WARNING, "test Warning");
	}
	
	public void extenReportFLUSH()
	{
		extentReports.flush();
	}
}