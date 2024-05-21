package util;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportUtil implements ITestListener {
	ExtentTest extentTest;
	private static final ExtentReports extentReports;
	
	static{
        String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportPath);
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Test Automation Results");
        htmlReporter.config().setTheme(Theme.STANDARD);
        extentReports = new ExtentReports();
         extentReports.attachReporter(htmlReporter);        
     }	
	
	@Override
	public void onTestStart(ITestResult result) {
	   
		String testName = result.getMethod().getMethodName();
		extentTest = extentReports.createTest(testName);
		extentTest.log(Status.INFO, "Test Script Started");
	  }
	  
	@Override
	  public void onTestSuccess(ITestResult result) {
	    
		extentTest.log(Status.PASS, "Test Passed");
	  }
	  
	@Override
	  public void onTestFailure(ITestResult result) {
	    extentTest.log(Status.FAIL, "Test Failed");	    
	  }
	  
	@Override
	  public void onTestSkipped(ITestResult result) {
	    extentTest.log(Status.SKIP, "Test Script Skipped");
	  }
	  
	@Override
	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	   
	  }
	  
	@Override
	  public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }
	 
	@Override
	  public void onStart(ITestContext context) {
	    System.out.println("Extent Report - Test Suite Started: " + context.getName());
	  }
	 
	@Override
	  public void onFinish(ITestContext context) {
		System.out.println("Extent Report - Test Suite Finished: " + context.getName());
		extentReports.flush();
	  }
}