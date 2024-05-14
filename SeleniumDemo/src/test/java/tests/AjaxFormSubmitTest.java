package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.DriverInitializer;
import pages.AjaxFormSubmit;
import pages.HomePage;
import pages.InputForm;

public class AjaxFormSubmitTest extends DriverInitializer{
	WebDriver driver;
	HomePage homePage;
	InputForm inputForm;
	AjaxFormSubmit ajaxFormSubmit;
	
	String expected_Message="Form has been submitted successfully!";
	
	@Test(priority = 1)
	public void verifyAjaxFormStringSubmit()
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
		System.out.println("Expected & Actual message is same!!!");
	}
}
