package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.DriverInitializer;
import pages.HomePage;
import pages.InputForm;
import pages.RadioButton;
import util.ReportUtil;
import util.ScreenshotUtil;

public class RadioButtonTest extends DriverInitializer {
	WebDriver driver;
	HomePage homePage;
	InputForm inputForm;
	RadioButton radioButton;
	ScreenshotUtil screenshotUtil;
	
	@Test(priority = 1)
	public void verifyMaleGenderRadioButton() throws IOException
	{
		driver=getDriver();
		homePage=new HomePage(driver);
		homePage.clickInputFormMenu();
		inputForm=new InputForm(driver);
		inputForm.clickRadioButtonsDemo();
		radioButton=new RadioButton(driver);
		radioButton.clickPatientGenderMale();
		radioButton.clickGetResultsButton();
		String actualMaleGenderMessage= radioButton.getMessageText();		
		boolean actual_Male= actualMaleGenderMessage.contains("Gender : Male");
		Assert.assertEquals(actual_Male, true);
		
		screenshotUtil= new ScreenshotUtil(driver, "verifyMaleGenderRadioButton");	
	}
	
	@Test(priority = 2)
	public void verifyFemaleGenderRadioButton() throws IOException
	{
		inputForm.clickRadioButtonsDemo();
		radioButton.clickPatientGenderFemale();
		radioButton.clickGetResultsButton();
		String actualFemaleGenderMessage= radioButton.getMessageText();		
		boolean actual_Female= actualFemaleGenderMessage.contains("Gender : Female");
		Assert.assertEquals(actual_Female, true);	
		
		screenshotUtil= new ScreenshotUtil(driver, "verifyFemaleGenderRadioButton");	
	}
}