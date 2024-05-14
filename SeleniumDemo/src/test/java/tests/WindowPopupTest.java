package tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.DriverInitializer;
import pages.AlertsAndModals;
import pages.HomePage;
import pages.WindowPopup;
import util.ReportUtil;
import util.ScreenshotUtil;
import util.SwitchToNewWindow;

public class WindowPopupTest extends DriverInitializer {
	WebDriver driver;
	HomePage homePage;
	AlertsAndModals alertsAndModals;
	WindowPopup windowPopup;
	SwitchToNewWindow switchToNewWindow;
	ScreenshotUtil screenshotUtil;
	ReportUtil reportUtil;
	String exp_Text="Obsqura Zone ";
	
	@Test(priority = 1)
	public void verifyClicklikeUsOnFacebook() throws IOException
	{
		driver=getDriver();
		homePage= new HomePage(driver);
		homePage.clickAlertsAndModalsMenu();
		alertsAndModals= new AlertsAndModals(driver);
		alertsAndModals.clickWindowPopup();
		windowPopup= new WindowPopup(driver);
		windowPopup.clicklikeUsOnFacebook();
		switchToNewWindow=new SwitchToNewWindow(driver);		
		windowPopup.enterEmail("john.doe@abcmail.com");
		windowPopup.enterPassword("Password@123");
	//	windowPopup.clickLoginButton();
		windowPopup.clickCloseButton();
		String act_Text=windowPopup.getText();
		Assert.assertEquals(act_Text, exp_Text);
		
		screenshotUtil= new ScreenshotUtil(driver, "ClicklikeUsOnFacebook");
		
		reportUtil=new ReportUtil();
		reportUtil.generateReports();
		reportUtil.generateReports1();
		reportUtil.createTest1("Testing: verifyClicklikeUsOnFacebook");
		reportUtil.extenTestLogINFO();
		reportUtil.extenTestlogPASS();
	//	reportUtil.extenTestlogFAIL();
	//	reportUtil.extenTestlogWARNING();
		reportUtil.extenReportFLUSH();
		
		
	}
}
