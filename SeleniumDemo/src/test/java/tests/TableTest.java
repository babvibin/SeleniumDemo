package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.DriverInitializer;
import pages.HomePage;
import pages.Table;
import pages.TableWithPagination;
import util.ExcelUtil;
import util.ReportUtil;
import util.ScreenshotUtil;

public class TableTest extends DriverInitializer{
	WebDriver driver;
	HomePage homePage;	
	Table table;
	TableWithPagination tableWithPagination;
	ExcelUtil excelUtil;
	String name, position, office, age, startDay, salary;
	String fileName="SampleExcelRead2.xlsx";
	String sheetName="Sheet1";
	int rowNumber;
	
	ScreenshotUtil screenshotUtil;
	ReportUtil reportUtil;	
	
	@Test(priority = 1)
	public void getValuesFromExcel() throws IOException
	{		
		name= excelUtil.getStringData(1, 0, fileName, sheetName);	
		position= excelUtil.getStringData(1, 1, fileName, sheetName);
		office= excelUtil.getStringData(1, 2, fileName, sheetName);
		age=excelUtil.getIntegerData(1, 3, fileName, sheetName);
		startDay= excelUtil.getStringData(1, 4, fileName, sheetName);
		salary= excelUtil.getStringData(1, 5, fileName, sheetName);
		System.out.println("Values read from Excel");
		System.out.println(name);
		System.out.println(position);
		System.out.println(office);
		System.out.println(age);
		System.out.println(startDay);
		System.out.println(salary);
	}	
	
	@Test(priority = 2)
	public void toGetRowNumber()
	{
		driver=getDriver();
		homePage=new HomePage(driver);
		homePage.clickTableMenu();
		table=new Table(driver);
		table.clickTableWithPagination();
		tableWithPagination=new TableWithPagination(driver);
		rowNumber=tableWithPagination.getRowNumber(name);	
		System.out.println(rowNumber+ " :Row Number");
	}	
	
	@Test(priority = 3)
	public void verifyPosition()
	{
		String currentPosition=tableWithPagination.getCurrentPosition(position, rowNumber);
		Assert.assertEquals(currentPosition, position);
		System.out.println(currentPosition+ " :CurrentPosition is correct");
	}
	
	@Test(priority = 4)
	public void verifyOffice()
	{
		String currentOffice=tableWithPagination.getCurrentOffice(office, rowNumber);
		Assert.assertEquals(currentOffice, office);
		System.out.println(currentOffice+ " :CurrentOffice is correct");		
	}
	
	@Test(priority = 5)
	public void verifyAge()
	{
		String currentAge=tableWithPagination.getCurrentAge(age, rowNumber);
		Assert.assertEquals(currentAge, age);
		System.out.println(currentAge+ " :CurrentAge is correct");			
	}
	
	@Test(priority = 6)
	public void verifyStartDay()
	{
		String currentStartDay=tableWithPagination.getCurrentStartDay(startDay, rowNumber);
		Assert.assertEquals(currentStartDay, startDay);
		System.out.println(currentStartDay+ " :CurrentStartDay is correct");			
	}
	
	@Test(priority = 7)
	public void verifySalary() throws IOException
	{
		String currentSalary=tableWithPagination.getCurrentSalary(salary, rowNumber);
		Assert.assertEquals(currentSalary, salary);
		System.out.println(currentSalary+ " :CurrentSalary is correct");
		
		screenshotUtil= new ScreenshotUtil(driver, "Table-Excel Test");

		reportUtil=new ReportUtil();
		reportUtil.generateReports();
		reportUtil.generateReports1();
		reportUtil.createTest1("Testing: Table-Excel Test");
		reportUtil.extenTestLogINFO();
		reportUtil.extenTestlogPASS();
		reportUtil.extenReportFLUSH();
	}
}
