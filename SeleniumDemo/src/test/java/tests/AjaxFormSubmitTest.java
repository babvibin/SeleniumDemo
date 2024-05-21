package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.DriverInitializer;
import pages.AjaxFormSubmit;
import pages.HomePage;
import pages.InputForm;
import util.ReportUtil;
import util.ScreenshotUtil;

public class AjaxFormSubmitTest extends DriverInitializer{
	WebDriver driver;
	HomePage homePage;
	InputForm inputForm;
	AjaxFormSubmit ajaxFormSubmit;
	ScreenshotUtil screenshotUtil;
//	ReportUtil reportUtil;
	
	String expected_Message="Form has been submitted successfully!";
	
	@Test(priority = 1)
	public void verifyAjaxFormStringSubmit() throws IOException
	{
		driver=getDriver();
		homePage=new HomePage(driver);
		homePage.clickInputFormMenu();
		inputForm=new InputForm(driver);
		inputForm.clickAjaxFormSubmit();
		ajaxFormSubmit=new AjaxFormSubmit(driver);
		ajaxFormSubmit.enterSubjectText("Here is my Subject");
		ajaxFormSubmit.enterDescriptionText("Here is my Description");
		ajaxFormSubmit.submitButtonClick();
		String actual_message=ajaxFormSubmit.successMessageDisplay();
		Assert.assertEquals(actual_message, expected_Message);
		
		screenshotUtil= new ScreenshotUtil(driver, "verifyAjaxFormStringSubmit");
/*
		reportUtil=new ReportUtil();
		reportUtil.generateReports();
		reportUtil.generateReports1();
		reportUtil.createTest1("Testing: verifyAjaxFormStringSubmit");
		reportUtil.extenTestLogINFO();
		reportUtil.extenTestlogPASS();
		reportUtil.extenReportFLUSH();		
*/
	}
}