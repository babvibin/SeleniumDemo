package pages;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TableWithPagination {
	WebDriver driver;
	public TableWithPagination(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	@FindBy(xpath = "//*[@id='dtBasicExample']/tbody/tr")
//	List<WebElement> droppedElements;	
	
	
	public int getRowNumber(String name)
	{		
		int size = driver.findElements(By.xpath("//*[@id='dtBasicExample']/tbody/tr")).size();
		String rowName;
		for(int i=1;i<size;i++)
		{
			rowName=driver.findElement(By.xpath("//*[@id='dtBasicExample']/tbody/tr["+i+"]/td[1]")).getText();
			if(rowName.equalsIgnoreCase(name))
			{							
				size= i;
			}
		}
		return size;		
	}
	
	public String getCurrentPosition(String position, int i)
	{
		String CurrentPosition=driver.findElement(By.xpath("//*[@id='dtBasicExample']/tbody/tr["+i+"]/td[2]")).getText();
		return CurrentPosition;
	}	

	public String getCurrentOffice(String office, int i)
	{
		String CurrentOffice=driver.findElement(By.xpath("//*[@id='dtBasicExample']/tbody/tr["+i+"]/td[3]")).getText();
		return CurrentOffice;
	}	
	
	public String getCurrentAge(String age, int i)
	{
		String CurrentAge = driver.findElement(By.xpath("//*[@id='dtBasicExample']/tbody/tr["+i+"]/td[4]")).getText();
		return CurrentAge;
	}	
	
	public String getCurrentStartDay(String startDate, int i)
	{
		String CurrentStartDay=driver.findElement(By.xpath("//*[@id='dtBasicExample']/tbody/tr["+i+"]/td[5]")).getText();
		return CurrentStartDay;
	}	
	
	public String getCurrentSalary(String salary, int i)
	{
		String CurrentSalary=driver.findElement(By.xpath("//*[@id='dtBasicExample']/tbody/tr["+i+"]/td[6]")).getText();
		return CurrentSalary;
	}
}
