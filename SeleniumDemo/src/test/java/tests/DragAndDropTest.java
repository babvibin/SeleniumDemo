package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.DriverInitializer;
import pages.DragAndDropPage;
import pages.HomePage;
import pages.Others;

public class DragAndDropTest extends DriverInitializer {
	WebDriver driver;
	HomePage homePage;
	Others others;
	DragAndDropPage dragAndDropPage;
	
	@Test(priority = 1)
	public void verifyDragAndDrop()
	{
		driver=getDriver();
		homePage=new HomePage(driver);
		homePage.clickOthersMenu();
		others=new Others(driver);
		others.clickDragAndDrop();
		dragAndDropPage=new DragAndDropPage(driver);
		dragAndDropPage.dragsAndDropSorceElement1();
	//	dragAndDropPage.dragsAndDropSorceElement2();
	//	dragAndDropPage.dragsAndDropSorceElement3();
	//	dragAndDropPage.dragsAndDropSorceElement4();			
		
	}
}
