package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.DriverInitializer;
import pages.DragAndDropPage;
import pages.DragNDropPage;
import pages.HomePage;
import pages.Others;

public class DragAndDropTest extends DriverInitializer {
	private WebDriver driver;
	private HomePage homePage;
	private Others others;
	DragAndDropPage dragAndDropPage;
	
	
	@Test
	public void verifyDragAndDrop() throws InterruptedException
	{
		driver=getDriver();
		homePage=new HomePage(driver);
		homePage.clickOthersMenu();
		others=new Others(driver);
		others.clickDragAndDrop();
		dragAndDropPage=new DragAndDropPage(driver);
		dragAndDropPage.dragsAndDropSorceElement1();
		dragAndDropPage.dragsAndDropSorceElement2();
		dragAndDropPage.dragsAndDropSorceElement3();
		dragAndDropPage.dragsAndDropSorceElement4();			
		
		Thread.sleep(2000);
		dragAndDropPage= new DragAndDropPage(driver);
		dragAndDropPage.dragsAndDropSorceElement1();
		dragAndDropPage.dragsAndDropSorceElement2();
		dragAndDropPage.dragsAndDropSorceElement3();
		dragAndDropPage.dragsAndDropSorceElement4();
	}
}
