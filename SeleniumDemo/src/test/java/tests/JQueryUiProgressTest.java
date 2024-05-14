package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.DriverInitializer;
import pages.HomePage;
import pages.JQueryUiProgress;
import pages.ProgressBars;

public class JQueryUiProgressTest extends DriverInitializer {
	WebDriver driver;
	HomePage homePage;
	ProgressBars progressBars;
	JQueryUiProgress jQueryUiProgress;
	
	@Test(priority = 1)
	public void verifyJQueryUiProgressCloseButton()
	{
		driver=getDriver();
		homePage=new HomePage(driver);
		homePage.clickProgressBarMenu();
		progressBars= new ProgressBars(driver);
		progressBars.clickJQueryUiProgress();
		jQueryUiProgress=new JQueryUiProgress(driver);
		jQueryUiProgress.clickStartDownloadBotton();
		jQueryUiProgress.clickCloseButton();	
	}
}
