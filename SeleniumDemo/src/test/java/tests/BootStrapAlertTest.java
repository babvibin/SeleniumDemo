package tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.DriverInitializer;
import pages.AlertsAndModals;
import pages.BootStrapAlertPage;
import pages.HomePage;
import util.ScreenshotUtil;

public class BootStrapAlertTest extends DriverInitializer{
	WebDriver driver;
	HomePage homePage;
	AlertsAndModals alertsAndModals;
	BootStrapAlertPage bootStrapAlertPage;
	String exp_Text="Obsqura Zone ";
	String exp_Message="I'm a normal success message. To close use  the appropriate button.";
	Boolean b;
	ScreenshotUtil screenshotUtil;	
	
	@Test(priority = 1)
	public void verifyNormalSuccessMessageDisplay() throws IOException
	{
		driver=getDriver();
		homePage= new HomePage(driver);
		homePage.clickAlertsAndModalsMenu();
		alertsAndModals= new AlertsAndModals(driver);
		alertsAndModals.clickBootstrapAlert();
		bootStrapAlertPage=new BootStrapAlertPage(driver);
		bootStrapAlertPage.clickNormalSuccessButton();
		String act_Message=bootStrapAlertPage.normalSuccessMessage();
		b= act_Message.contains(act_Message);		
		Assert.assertEquals(b,true);	
		
		screenshotUtil= new ScreenshotUtil(driver, "verifyNormalSuccessMessageDisplay");
	}
}
