package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import base.DriverInitializer;
import pages.HomePage;
import pages.InputForm;
import pages.SimpleFormDemo;
import util.ExcelUtil;
import util.ReportUtil;
import util.ScreenshotUtil;

public class SimpleFormTest extends DriverInitializer {
	
	WebDriver driver;
	HomePage homePage;
	InputForm inputForm;
	SimpleFormDemo simpleFormDemo;
	
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
		simpleFormDemo.enterValueA(5);
		simpleFormDemo.enterValueB(4);
		simpleFormDemo.getTotalButtonClick();
		String totalTextValue= simpleFormDemo.totalTextVerify();
		Boolean value = totalTextValue.contains("9");
		SoftAssert softAssert = new SoftAssert(); 
		softAssert.assertTrue(value);		
		
//This is an example for taking Screenshot of a Web Page//
		ScreenshotUtil ScreenshotUtil= new ScreenshotUtil(driver, "verifySimpleFormDemo");	
		
		softAssert.assertAll();
	}
}