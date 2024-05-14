package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.DriverInitializer;
import pages.HomePage;
import pages.InputForm;
import pages.RadioButton;

public class RadioButtonTest extends DriverInitializer {
	WebDriver driver;
	HomePage homePage;
	InputForm inputForm;
	RadioButton radioButton;
	String expectedMaleGenderMessage="Gender : Male\r\n"
			+ "Age group:";
	String expectedFemaleGenderMessage="";
	
	
	@Test(priority = 1)
	public void verifyMaleGenderRadioButton()
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
		System.out.println(actualMaleGenderMessage);
		boolean actual_Male= actualMaleGenderMessage.contains("Gender : Male");
		Assert.assertEquals(actual_Male, true);
	}
	
	@Test(priority = 2)
	public void verifyFemaleGenderRadioButton()
	{
		inputForm.clickRadioButtonsDemo();
		radioButton.clickPatientGenderFemale();
		radioButton.clickGetResultsButton();
		String actualFemaleGenderMessage= radioButton.getMessageText();
		System.out.println(actualFemaleGenderMessage);
		boolean actual_Female= actualFemaleGenderMessage.contains("Gender : Female");
		Assert.assertEquals(actual_Female, true);		
	}
}
