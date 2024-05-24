package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.DriverInitializer;
import pages.FormSubmit;
import pages.HomePage;
import pages.InputForm;
import util.ReportUtil;
import util.ScreenshotUtil;

public class FormSubmitTest extends DriverInitializer{
	WebDriver driver;
	HomePage homePage;
	InputForm inputForm;
	FormSubmit formSubmit;
	String expectedMessage= "Form has been submitted successfully!";
	String expectedCheckBoxValidationMessage="You must agree before submitting.";
	ScreenshotUtil screenshotUtil;
	
	@Test(priority = 1)
	public void verifyFormSubmitSuccessfully() throws IOException
	{
		driver=getDriver();
		homePage=new HomePage(driver);
		homePage.clickInputFormMenu();
		inputForm=new InputForm(driver);
		inputForm.clickFormSubmit();
		formSubmit=new FormSubmit(driver);
		formSubmit.enterFirstName("John");
		formSubmit.enterLastName("Doe");
		formSubmit.enterUserName("jdoe");
		formSubmit.enterCity("Ashburn");
		formSubmit.enterState("Virgenia");
		formSubmit.enterZip(20101);
		formSubmit.selectTermsAndConditionsCheckBox();
		formSubmit.clickSubmitFormButton();
		String actualMessage= formSubmit.displaySubmittedSuccessfullyMessage();
		Assert.assertEquals(actualMessage, expectedMessage);
		
		screenshotUtil= new ScreenshotUtil(driver, "verifyFormSubmitSuccessfully");	
	}
	
	@Test(priority = 2, retryAnalyzer = util.RetryAnalyzer.class )
	public void verifyFormSubmit_CheckBoxValidationMessageDisplay() throws IOException
	{
		inputForm.clickFormSubmit();
		formSubmit=new FormSubmit(driver);
		formSubmit.enterFirstName("John");
		formSubmit.enterLastName("Doe");
		formSubmit.enterUserName("jdoe");
		formSubmit.enterCity("Ashburn");
		formSubmit.enterState("Virgenia");
		formSubmit.enterZip(20101);
		formSubmit.clickSubmitFormButton();
		String actualCheckBoxValidationMessage= formSubmit.displaycheckboxValidationMessage();
		Assert.assertEquals(actualCheckBoxValidationMessage, expectedCheckBoxValidationMessage);
		
		screenshotUtil= new ScreenshotUtil(driver, "verifyFormSubmit_CheckBoxValidationMessageDisplay");
	}
}