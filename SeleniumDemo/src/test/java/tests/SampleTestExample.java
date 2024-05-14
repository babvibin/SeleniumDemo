
package tests;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import base.DriverInitializer;
import pages.HomePage;
import pages.InputForm;
import pages.SimpleFormDemo;
import util.ExcelUtil;
import util.PropertyReaderUtil;
import util.ReportUtil;
import util.RetryAnalyzer;
import util.ScreenshotUtil;

public class SampleTestExample extends DriverInitializer {
	
	WebDriver driver;
	HomePage homePage;
	InputForm inputForm;
	SimpleFormDemo simpleFormDemo;
	ReportUtil ReportUtil;
	ExcelUtil ExcelUtil;
	
	
	@Test(priority = 1)
	public void verifySimpleFormDemo_SingleInputField()
	{
		driver=getDriver();
		homePage=new HomePage(driver);
		homePage.clickInputFormMenu();
		inputForm=new InputForm(driver);
		inputForm.clickSimpleFormDemo();
		simpleFormDemo=new SimpleFormDemo(driver);
		simpleFormDemo.enterMessage("My First Message");
		simpleFormDemo.showMessageButtonClick();
		String actualMessageText=simpleFormDemo.yourMessageTextVerify();
//Hard Assert: Executions stops when a Hard Assert Fails.//		
		Assert.assertEquals(actualMessageText, "Your Message : My First Message");
	}		

	@Test(priority = 2)
	public void verifySimpleFormDemo_TwoInputFields() throws IOException
	{		
//		simpleFormDemo=new SimpleFormDemo(driver);
		simpleFormDemo.enterValueA(5);
		simpleFormDemo.enterValueB(4);
		simpleFormDemo.getTotalButtonClick();
		String totalTextValue= simpleFormDemo.totalTextVerify();
		System.out.println(totalTextValue);		
		SoftAssert softAssert = new SoftAssert(); 
//Soft Assert: Executions continues even  when a Soft Assert Fails.//		
		softAssert.assertEquals(totalTextValue, 9);
		softAssert.assertAll();		
		
//This is an example for Extent Report//
		ReportUtil=new ReportUtil();
		ReportUtil.generateReports();
		ReportUtil.generateReports1();
		ReportUtil.createTest1("Testing: verifySimpleFormDemoABCD");
		ReportUtil.extenTestLogINFO();
		ReportUtil.extenTestlogPASS();
	//	ReportUtil.extenTestlogERROR();
		ReportUtil.extenTestlogFAIL();
		ReportUtil.extenTestlogWARNING();
		ReportUtil.extenReportFLUSH();
		
		
//This is an example for taking Screenshot of a Web Page//
		ScreenshotUtil ScreenshotUtil= new ScreenshotUtil(driver, "verifySimpleFormDemo");	
		
		
//This is an example for Excel Read//
		ExcelUtil=new ExcelUtil();
		
		String name=ExcelUtil.getStringData(1, 0, "SampleExcelRead2.xlsx", "Sheet1");
		System.out.println(name);
		
		String position=ExcelUtil.getStringData(1, 1, "SampleExcelRead2.xlsx", "Sheet1");
		System.out.println(position);		
		
		String office=ExcelUtil.getStringData(1, 2, "SampleExcelRead2.xlsx", "Sheet1");
		System.out.println(office);				
		
		String age=ExcelUtil.getIntegerData(1, 3, "SampleExcelRead2.xlsx", "Sheet1");
		System.out.println(age);
		
		
		String startDate=ExcelUtil.getStringData(1, 4, "SampleExcelRead2.xlsx", "Sheet1");
		System.out.println(startDate);
		
		String salary=ExcelUtil.getStringData(1, 5, "SampleExcelRead2.xlsx", "Sheet1");
		System.out.println(salary);			
		
//This is an example for Property Reader//
		String pageURL=PropertyReaderUtil.getProperty("URL");
		System.out.println(pageURL);
		String messageText=PropertyReaderUtil.getProperty("message");
		System.out.println(messageText);		
	}
	
//This is an example for RetryAnalyzer//	
	@Test(priority = 2, retryAnalyzer = util.RetryAnalyzer.class)
	public void assertMessage()
	{
		String actualMessageText=simpleFormDemo.yourMessageTextVerify();
		System.out.println(actualMessageText);
		Assert.assertEquals("Your Message : My First Message", "Your Message : My First Message");
		System.out.println("Hard Assert: Executions stops when a Hard Assert Fails. Page title is compared & it is correct");
		
	/*	
		//This is an example for Extent Report//
		ReportUtil=new ReportUtil();
		ReportUtil.generateReports();
		ReportUtil.myTestReport("Testing: assertMessage");	
		*/
	}
}
