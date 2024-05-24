package tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.DriverInitializer;
import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;
import pages.AlertsAndModals;
import pages.HomePage;
import pages.JavaScriptAlert;
import util.ReportUtil;
import util.ScreenshotUtil;

public class JavaScriptAlertTest extends DriverInitializer {
	WebDriver driver;
	HomePage homePage;
	AlertsAndModals alertsAndModals;
	JavaScriptAlert javaScriptAlert;
	ScreenshotUtil screenshotUtil;
	
	static String expectedValue_JavaScriptAlertBox="I am a Javascript alert box!";
	static String expectedValue_JavaScriptPromptBox="Please enter your name";
	
	@Test(priority = 1)
	public void verifyJavaScriptAlertBox() throws IOException
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
		
		screenshotUtil= new ScreenshotUtil(driver, "verifyJavaScriptAlertBox");
	}
	
	@Test(priority = 2)
	public void verifyJavaScriptPromptBox_dismiss() throws IOException
	{
		javaScriptAlert.clickclickMeButtonJavaScriptPromptBox();
		String actualValue_JavaScriptPromptBox=javaScriptAlert.getTextJavaScriptPromptBox();
		javaScriptAlert.dismissJavaScriptPromptBox();	
		
		screenshotUtil= new ScreenshotUtil(driver, "verifyJavaScriptPromptBox_dismiss");		
	}
	
	@Test(priority = 3)
	public void verifyJavaScriptPromptBox_accept() throws IOException
	{
		javaScriptAlert.clickclickMeButtonJavaScriptPromptBox();
		javaScriptAlert.acceptJavaScriptPromptBox();	
		
		screenshotUtil= new ScreenshotUtil(driver, "verifyJavaScriptPromptBox_accept");
	}
}