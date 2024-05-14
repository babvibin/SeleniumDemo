package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.DriverInitializer;
import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;
import pages.AlertsAndModals;
import pages.HomePage;
import pages.JavaScriptAlert;

public class JavaScriptAlertTest extends DriverInitializer {
	WebDriver driver;
	HomePage homePage;
	AlertsAndModals alertsAndModals;
	JavaScriptAlert javaScriptAlert;
	
	static String expectedValue_JavaScriptAlertBox="I am a Javascript alert box!";
	static String expectedValue_JavaScriptPromptBox="Please enter your name";
	
	@Test(priority = 1)
	public void verifyJavaScriptAlertBox()
	{
		driver=getDriver();
		homePage=new HomePage(driver);
		homePage.clickAlertsAndModalsMenu();
		alertsAndModals= new AlertsAndModals(driver);
		alertsAndModals.clickJavascriptAlert();
		javaScriptAlert=new JavaScriptAlert(driver);
		javaScriptAlert.clickClickMeButtonJavaScriptAlertBox();
		String actualValue_JavaScriptAlertBox=javaScriptAlert.getTextJavaScriptAlertBox();
		Assert.assertEquals(actualValue_JavaScriptAlertBox, expectedValue_JavaScriptAlertBox);
		javaScriptAlert.closeJavaScriptAlertBox();
	}
	
	@Test(priority = 2)
	public void verifyJavaScriptPromptBox_dismiss()
	{
		javaScriptAlert.clickclickMeButtonJavaScriptPromptBox();
		String actualValue_JavaScriptPromptBox=javaScriptAlert.getTextJavaScriptPromptBox();
		javaScriptAlert.dismissJavaScriptPromptBox();		
	}
	
	@Test(priority = 3)
	public void verifyJavaScriptPromptBox_accept()
	{
		javaScriptAlert.clickclickMeButtonJavaScriptPromptBox();
		javaScriptAlert.acceptJavaScriptPromptBox();		
	}
}
