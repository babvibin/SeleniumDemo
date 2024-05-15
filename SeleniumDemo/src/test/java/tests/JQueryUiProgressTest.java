package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.DriverInitializer;
import pages.HomePage;
import pages.JQueryUiProgress;
import pages.ProgressBars;
import util.ReportUtil;
import util.ScreenshotUtil;

public class JQueryUiProgressTest extends DriverInitializer {
	WebDriver driver;
	HomePage homePage;
	ProgressBars progressBars;
	JQueryUiProgress jQueryUiProgress;
	
	ScreenshotUtil screenshotUtil;
	ReportUtil reportUtil;
	
	@Test(priority = 1, retryAnalyzer = util.RetryAnalyzer.class)
	public void verifyJQueryUiProgressCloseButton() throws IOException
	{
		driver=getDriver();
		homePage=new HomePage(driver);
		homePage.clickProgressBarMenu();
		progressBars= new ProgressBars(driver);
		progressBars.clickJQueryUiProgress();
		jQueryUiProgress=new JQueryUiProgress(driver);
		jQueryUiProgress.clickStartDownloadBotton();
		jQueryUiProgress.clickCloseButton();	
		
		screenshotUtil= new ScreenshotUtil(driver, "verifyJQueryUiProgressCloseButton");

		reportUtil=new ReportUtil();
		reportUtil.generateReports();
		reportUtil.generateReports1();
		reportUtil.createTest1("Testing: verifyJQueryUiProgressCloseButton");
		reportUtil.extenTestLogINFO();
		reportUtil.extenTestlogPASS();
		reportUtil.extenReportFLUSH();
	}
}
